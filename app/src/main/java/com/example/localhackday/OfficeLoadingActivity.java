package com.example.localhackday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.localhackday.utils.AnimatedTextView;

public class OfficeLoadingActivity extends AppCompatActivity {

    private User user;
    private AnimatedTextView question;
    private static int TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_loading);

        user = (User) getIntent().getSerializableExtra("USER");
        question = findViewById(R.id.question);

        question.setDuration(TIME_OUT);
        question.setIsVisible(false);
        question.toggle();
    }

    public void onMenuClick(View view) {

    }

    public void onNextClick(View view) {
        Intent intent = new Intent(OfficeLoadingActivity.this, OfficeWorkingActivity.class);
        intent.putExtra("USER", user);
        startActivity(intent);
    }
}
