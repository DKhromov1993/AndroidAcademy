package com.example.den.androidacademyhomework;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.den.androidacademyhomework.Data.DataUtils;
import com.example.den.androidacademyhomework.Data.NewsItem;

import java.util.List;

import static android.support.v7.widget.RecyclerView.LayoutManager;

public class NewsListActivity extends AppCompatActivity {
    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        List<NewsItem> news = DataUtils.generateNews();

        LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        VerticalSpaceItemDecoration itemDecoration = new VerticalSpaceItemDecoration(4);
        RecyclerView recyclerView = findViewById(R.id.rv_news);
        newsAdapter = new NewsAdapter(this, news);
        recyclerView.setAdapter(newsAdapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(itemDecoration);

    }

    protected void onStart() {
        super.onStart();
        newsAdapter.setOnItemClickListener(onItemClickListener);
    }

    @Override
    protected void onStop() {
        newsAdapter.setOnItemClickListener(null);
        super.onStop();
    }

    private final NewsAdapter.OnItemClickListener onItemClickListener = new NewsAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(NewsItem newsItem) {
            AboutActivity.start(NewsListActivity.this, newsItem);
        }
    };
}
