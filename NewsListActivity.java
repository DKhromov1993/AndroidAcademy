package com.example.den.androidacademyhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.den.androidacademyhomework.Data.DataUtils;

import static android.support.v7.widget.RecyclerView.*;

public class NewsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,((LinearLayoutManager) layoutManager).getOrientation());

        VerticalSpaceItemDecoration itemDecoration1 = new VerticalSpaceItemDecoration(4);


        RecyclerView recyclerView = findViewById(R.id.rv_news);
        recyclerView.setAdapter(new NewsAdapter(this, DataUtils.generateNews()));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(itemDecoration1);


    }
}
