package de.jbamberger.offlineclient.ui.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import dagger.android.AndroidInjection;
import de.jbamberger.offlineclient.R;
import de.jbamberger.offlineclient.databinding.ActivityMainBinding;
import de.jbamberger.offlineclient.ui.components.DataBindingAdapter;
import de.jbamberger.offlineclient.ui.components.ListItem;
import de.jbamberger.offlineclient.ui.components.TwoLineItem;
import de.jbamberger.offlineclient.ui.hackernews.HackerNewsActivity;
import de.jbamberger.offlineclient.ui.jodel.JodelActivity;
import de.jbamberger.offlineclient.ui.reddit.RedditActivity;
import de.jbamberger.offlineclient.ui.twitter.TwitterActivity;

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
        items.add(new TwoLineItem("Jodel", "anonymous location based chat", v -> startActivity(new Intent(this, JodelActivity.class))));
        items.add(new TwoLineItem("Reddit", "front page of the internet", v -> startActivity(new Intent(this, RedditActivity.class))));
        items.add(new TwoLineItem("HackerNews", "y-combinator hacker news", v -> startActivity(new Intent(this, HackerNewsActivity.class))));
        items.add(new TwoLineItem("Twitter", "birds..?!", v -> startActivity(new Intent(this, TwitterActivity.class))));

        adapter.setItems(items);
    }


}
