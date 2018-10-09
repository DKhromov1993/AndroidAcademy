package com.example.den.androidacademyhomework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class AboutActivity extends AppCompatActivity {

    private static final String KEY_IMG = "KEY_IMG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ImageView imageView = findViewById(R.id.about_iv);
        String qwe = getIntent().getStringExtra(KEY_IMG);
        System.out.println(qwe);
        Glide.with(this).load(qwe).into(imageView);

    }

    public static void start(Activity activity, String imgUrl){
        Intent intent = new Intent(activity, AboutActivity.class);
        intent.putExtra(KEY_IMG, imgUrl);
        activity.startActivity(intent);
    }
}
