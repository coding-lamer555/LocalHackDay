package com.example.localhackday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localhackday.utils.AnimatedTextView;

public class KitchenActivity extends AppCompatActivity {

    private User user;
    private AnimatedTextView question;
    private Button answerA;
    private Button answerB;
    private Button answerC;
    private static int TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);

        user = (User) getIntent().getSerializableExtra("USER");
        question = findViewById(R.id.question);
        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);
        answerC = findViewById(R.id.answerC);

        if (user.isDidUserChooseToSleep()) {
            question.setText(R.string.kitchen_if_choose_sleep);
            answerA.setVisibility(View.INVISIBLE);
            answerC.setVisibility(View.INVISIBLE);
            answerB.setText(R.string.next);
        }

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
        goToNext();
    }

    public void onAnswerCClick(View view) {
        goToNext();
    }

    private void goToNext() {
        Intent intent = new Intent(KitchenActivity.this, WardrobeActivity.class);
        intent.putExtra("USER", user);
        startActivity(intent);
    }
}
