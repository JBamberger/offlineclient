package de.jbamberger.offlinefetcher.ui.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import dagger.android.AndroidInjection;
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
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        adapter = new DataBindingAdapter();

        binding.list.setLayoutManager(new LinearLayoutManager(this));
        binding.list.setAdapter(adapter);
        binding.list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        ArrayList<ListItem> items = new ArrayList<>();
        items.add(new TwoLineItem("Jodel", "", v -> startActivity(new Intent(MainActivity.this, JodelActivity.class))));
        items.add(new TwoLineItem("Reddit", "", v -> startActivity(new Intent(MainActivity.this, RedditActivity.class))));

        adapter.setItems(items);
    }


}
