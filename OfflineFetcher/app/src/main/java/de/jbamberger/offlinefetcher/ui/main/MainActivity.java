package de.jbamberger.offlinefetcher.ui.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.ArrayList;

import de.jbamberger.offlinefetcher.R;
import de.jbamberger.offlinefetcher.databinding.ActivityMainBinding;
import de.jbamberger.offlinefetcher.ui.components.DataBindingAdapter;
import de.jbamberger.offlinefetcher.ui.components.ListItem;
import de.jbamberger.offlinefetcher.ui.components.TwoLineItem;
import de.jbamberger.offlinefetcher.ui.jodel.JodelActivity;
import de.jbamberger.offlinefetcher.ui.reddit.RedditActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    ActivityMainBinding binding;

    DataBindingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //((App) getApplication()).getAppComponent().inject(this);

        adapter = new DataBindingAdapter();

        binding.list.setLayoutManager(new LinearLayoutManager(this));
        binding.list.setAdapter(adapter);
        binding.list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        ArrayList<ListItem> items = new ArrayList<>();
        items.add(new TwoLineItem("Jodel", "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, JodelActivity.class));
            }
        }));
        items.add(new TwoLineItem("Reddit", "", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RedditActivity.class));
            }
        }));

        adapter.setItems(items);
    }


}
