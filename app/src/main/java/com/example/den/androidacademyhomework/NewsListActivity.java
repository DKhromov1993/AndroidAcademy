package com.example.den.androidacademyhomework;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.den.androidacademyhomework.Data.DataUtils;
import com.example.den.androidacademyhomework.Data.NewsItem;

import static android.support.v7.widget.RecyclerView.LayoutManager;

public class NewsListActivity extends AppCompatActivity {
    NewsAdapter newsAdapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        context = this;

        LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        VerticalSpaceItemDecoration itemDecoration1 = new VerticalSpaceItemDecoration(4);
        RecyclerView recyclerView = findViewById(R.id.rv_news);
        newsAdapter = new NewsAdapter(this, DataUtils.generateNews());
        recyclerView.setAdapter(newsAdapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(itemDecoration1);

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
            AboutActivity.start((Activity) context,
                    newsItem.getImageUrl(),
                    newsItem.getCategory().getName(),
                    newsItem.getFullText(),
                    newsItem.getPublishDate("MMM d HH:mm"),
                    newsItem.getTitle()
            );
        }
    };
}
