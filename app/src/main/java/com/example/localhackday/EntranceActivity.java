package com.example.localhackday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localhackday.utils.AnimatedTextView;

public class EntranceActivity extends AppCompatActivity {

    private User user;
    private AnimatedTextView question;
    private static int TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        user = (User) getIntent().getSerializableExtra("USER");
        question = findViewById(R.id.question);

        question.setDuration(TIME_OUT);
        question.setIsVisible(false);
        question.toggle();
    }

    public void onMenuClick(View view) {

    }

    public void onAnswerAClick(View view) {
        user.incStupidityPoints(2);

        Intent intent = new Intent(EntranceActivity.this, ElevatorActivity.class);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void onAnswerBClick(View view) {
        Intent intent = new Intent(EntranceActivity.this, StairsActivity.class);
        intent.putExtra("USER", user);
        startActivity(intent);
    }
}
