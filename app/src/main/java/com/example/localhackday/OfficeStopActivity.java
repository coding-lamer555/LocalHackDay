package com.example.localhackday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localhackday.utils.AnimatedTextView;

public class OfficeStopActivity extends AppCompatActivity {

    private User user;
    private AnimatedTextView question;
    private static int TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_stop);

        user = (User) getIntent().getSerializableExtra("USER");
        question = findViewById(R.id.question);

        question.setDuration(TIME_OUT);
        question.setIsVisible(false);
        question.toggle();
    }

    public void onMenuClick(View view) {

    }

    public void onAnswerAClick(View view) {
        goToNext();
    }

    public void onAnswerBClick(View view) {
        user.incStupidityPoints(1);
        goToNext();
    }

    private void goToNext() {
        Intent intent = new Intent(OfficeStopActivity.this, OfficeBeginActivity.class);
        intent.putExtra("USER", user);
        startActivity(intent);
    }
}
