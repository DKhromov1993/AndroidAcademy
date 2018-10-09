package com.example.den.androidacademyhomework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AboutActivity extends AppCompatActivity {

    private static final String KEY_IMG = "KEY_IMG";
    private static final String KEY_CAT = "KEY_CAT";
    private static final String KEY_FULL_TEXT = "KEY_FULL_TEXT";
    private static final String KEY_DATE = "KEY_DATE";
    private static final String KEY_TITLE = "KEY_TITLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        String newsImgUrl = getIntent().getStringExtra(KEY_IMG);
        String newsCategory = getIntent().getStringExtra(KEY_CAT);
        String newsFullText = getIntent().getStringExtra(KEY_FULL_TEXT);
        String newsDate = getIntent().getStringExtra(KEY_DATE);
        String newsTitle = getIntent().getStringExtra(KEY_TITLE);

        this.setTitle(newsCategory);


        ImageView imageView = findViewById(R.id.about_iv);

        Glide.with(this).load(newsImgUrl).into(imageView);
        TextView date = findViewById(R.id.about_date);
        date.setText(newsDate);

        TextView fullText = findViewById(R.id.about_text);
        fullText.setText(newsFullText);

        TextView title = findViewById(R.id.about_title);
        title.setText(newsTitle);


    }

    public static void start(Activity activity, String imgUrl, String category, String fullText, String date, String title) {
        Intent intent = new Intent(activity, AboutActivity.class);
        intent.putExtra(KEY_IMG, imgUrl);
        intent.putExtra(KEY_CAT, category);
        intent.putExtra(KEY_FULL_TEXT, fullText);
        intent.putExtra(KEY_DATE, date);
        intent.putExtra(KEY_TITLE, title);
        activity.startActivity(intent);
    }
}
