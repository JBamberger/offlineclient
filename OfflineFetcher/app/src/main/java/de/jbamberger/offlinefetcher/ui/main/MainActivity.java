package de.jbamberger.offlinefetcher.ui.main;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import de.jbamberger.offlinefetcher.App;
import de.jbamberger.offlinefetcher.ui.components.DataBindingBaseAdapter;
import de.jbamberger.offlinefetcher.source.jodel.GetPostsComboResponse;
import de.jbamberger.offlinefetcher.source.jodel.JodelApi;
import de.jbamberger.offlinefetcher.source.jodel.Post;
import de.jbamberger.offlinefetcher.R;
import de.jbamberger.offlinefetcher.source.jodel.SecurePreferences;
import de.jbamberger.offlinefetcher.databinding.ActivityMainBinding;
import de.jbamberger.offlinefetcher.util.ExecuteAsRootBase;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Inject
    JodelApi api;

    ActivityMainBinding binding;

    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ((App) getApplication()).getAppComponent().inject(this);

        adapter = new Adapter();

        binding.list.setLayoutManager(new LinearLayoutManager(this));
        binding.list.setAdapter(adapter);
        binding.list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        runApi();

        Log.d(TAG, "onCreate: " + getApplicationInfo().uid);
    }

    public void run(View v) {
        ExecuteAsRootBase cmd = new ExecuteAsRootBase() {
            @Override
            protected ArrayList<String> getCommandsToExecute() {
                ArrayList<String> commands = new ArrayList<>();
                String jodelPath = "/data/data/com.tellm.android.app";
                commands.add("[ -f " + jodelPath + "/files/INSTALLATION ] && cp " + jodelPath + "/files/INSTALLATION " + getFilesDir()
                        + "&& chmod 755 " + getFilesDir().getAbsolutePath() + "/INSTALLATION");
                commands.add("[ -f " + jodelPath + "/shared_prefs/tellm.xml ] && cp " + jodelPath + "/shared_prefs/tellm.xml " +
                        getApplicationInfo().dataDir + "/shared_prefs/tellm.xml" +
                        "&& chmod 755 " + getApplicationInfo().dataDir + "/shared_prefs/tellm.xml");
                return commands;
            }
        };
        cmd.execute();
        SharedPreferences p = getSharedPreferences("tellm", MODE_PRIVATE);
        SecurePreferences pref = new SecurePreferences(getApplicationContext());
        Map<String, ?> m = p.getAll();
        for (String k : m.keySet()) {
            try {
            Log.d(TAG, "run: key: [" + pref.decryptString(k) + "], val: [" + pref.decryptString((String) m.get(k)) + "]");
        } catch (ClassCastException e) {}}
    }

    public void test(View v) {
        String filename = "Meta.txt";
        String content = "Hallo das ist ein Test\nWir möchten schauen ob das schreiben geht!";



        //Check if we have user permission to access external storage and request if not!
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            Log.d(TAG, "We have no permission to write to external storage");
            return;
        }

        //Get DOWNLOADS directory
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        //Create dir if not existing
        if(!dir.exists()){
            dir.mkdir();
            Log.d(TAG, "Created new export directory at " + dir.getAbsolutePath() );
        }

        //Create new file
        File newFile = new File(dir, filename);

        try {
            newFile.createNewFile();
            Log.d(TAG, "Created file " + newFile.getAbsolutePath());

            FileOutputStream fout = new FileOutputStream(newFile);
            OutputStreamWriter writer = new OutputStreamWriter(fout);

            writer.append(content);
            writer.close();

            fout.flush();
            fout.close();

        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "Could not create file " + newFile.getAbsolutePath());
        }
        Log.d(TAG, "test: written");
    }

    public void runApi() {
        new AsyncTask<Void, Void, List<Post>>() {
            @Override
            protected List<Post> doInBackground(Void[] params) {
                try {
                    Response<GetPostsComboResponse> r = api.getPostsCombo(47.75027847290039D, 8.978754997253418D, true, true, false).execute();
                    r.body();
                    return r.body().getRecent();
                } catch (NullPointerException | IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(List<Post> posts) {
                super.onPostExecute(posts);

                if (posts != null) {
                    adapter.setItems(posts);
                }
            }
        }.execute();
    }

    private class Adapter extends DataBindingBaseAdapter {

        private List<Post> items = new ArrayList<>();

        public void setItems(List<Post> items) {
            this.items = items;
            notifyDataSetChanged();
        }

        @Override
        protected Object getObjForPosition(int position) {
            return items.get(position);
        }

        @Override
        protected int getLayoutIdForPosition(int position) {
            return R.layout.post;
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }
}
