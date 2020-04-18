package com.example.localhackday;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localhackday.utils.AnimatedTextView;

public class WelcomeActivity extends AppCompatActivity {

    private AnimatedTextView title;
    private static int TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        title = findViewById(R.id.title);
        title.setDuration(TIME_OUT);
        title.setIsVisible(false);
        title.toggle();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, InfoActivity.class);
                startActivity(intent);
                finish();
            }
        }, TIME_OUT + 1000);
    }
}
