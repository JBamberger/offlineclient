package de.jbamberger.offlineclient.ui.jodel;

import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import de.jbamberger.offlineclient.R;
import de.jbamberger.offlineclient.databinding.ActivityJodelBinding;
import de.jbamberger.offlineclient.source.jodel.JodelApi;
import de.jbamberger.offlineclient.source.jodel.SecurePreferences;
import de.jbamberger.offlineclient.ui.jodel.feed.JodelFeedFragment;
import de.jbamberger.offlineclient.util.ExecuteAsRootBase;
import timber.log.Timber;

public class JodelActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    private static final String TAG = JodelActivity.class.getSimpleName();

    @Inject
    JodelApi api;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    ActivityJodelBinding binding;

    @Inject
    SharedPreferences prefs;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new JodelFeedFragment())
                        .commit();
                return true;
            case R.id.navigation_dashboard:
                return true;
            case R.id.navigation_notifications:
                return true;
        }
        return false;
    };

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_jodel);
        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void run(View v) {
        try {
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
                    String key = pref.decryptString(k);
                    String value = pref.decryptString((String) m.get(k));
                    Log.d(TAG, "run: key: [" + key + "], val: [" + value + "]");

                    if (key.equals("accessToken")) {
                        prefs.edit().putString("accessToken", value).apply();
                    }
                } catch (ClassCastException e) {
                    Timber.e(e);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
