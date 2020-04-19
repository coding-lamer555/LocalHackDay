package com.example.localhackday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localhackday.utils.AnimatedTextView;

public class OfficeStreetActivity extends AppCompatActivity {

    private User user;
    private AnimatedTextView question;
    private Button answerA;
    private Button answerB;
    private Button answerC;
    private static int TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_street);

        user = (User) getIntent().getSerializableExtra("USER");
        question = findViewById(R.id.question);
        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);
        answerC = findViewById(R.id.answerC);

        question.setDuration(TIME_OUT);
        question.setIsVisible(false);
        question.toggle();
    }

    public void onMenuClick(View view) {

    }

    public void onAnswerAClick(View view) {
        Intent intent = new Intent(OfficeStreetActivity.this, WardrobeFinalActivity.class);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void onAnswerBClick(View view) {
        user.incStupidityPoints(3);

        Intent intent = new Intent(OfficeStreetActivity.this, CafeActivity.class);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void onAnswerCClick(View view) {
        user.incStupidityPoints(1);

        Intent intent = new Intent(OfficeStreetActivity.this, ShopActivity.class);
        intent.putExtra("USER", user);
        startActivity(intent);
    }
}
