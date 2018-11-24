package com.example.den.androidacademyhomework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.den.androidacademyhomework.Data.NewsItem;

public class AboutActivity extends AppCompatActivity {
    private static final String TAG = "AboutActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            NewsItem newsItem = (NewsItem) getIntent().getExtras().getSerializable(NewsItem.class.getSimpleName());


            String newsImgUrl = newsItem.getImageUrl();
            String newsCategory = newsItem.getCategory().getName();
            String newsFullText = newsItem.getFullText();
            String newsDate = newsItem.getPublishDate("MMM d HH:mm");
            String newsTitle = newsItem.getTitle();

            this.setTitle(newsCategory);

            ImageView imageView = findViewById(R.id.about_iv);

            Glide.with(this).load(newsImgUrl).into(imageView);
            TextView date = findViewById(R.id.about_date);
            date.setText(newsDate);

            TextView fullText = findViewById(R.id.about_text);
            fullText.setText(newsFullText);

            TextView title = findViewById(R.id.about_title);
            title.setText(newsTitle);
        } else {
            Log.e(TAG, "Не переданы аргументы для текущей активити");
        }
    }

    public static void start(Activity activity, NewsItem newsItem){
        Intent intent = new Intent(activity, AboutActivity.class);
        intent.putExtra(NewsItem.class.getSimpleName(), newsItem);
        activity.startActivity(intent);
    }
}
