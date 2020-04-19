package com.example.localhackday;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.localhackday.utils.AnimatedTextView;

public class BedroomActivity extends AppCompatActivity {

    private User user;
    private ConstraintLayout root;
    private Button menu;
    private AnimatedTextView question;
    private Button answerA;
    private Button answerB;
    private static int TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedroom);

        user = (User) getIntent().getSerializableExtra("USER");
        root = findViewById(R.id.root);
        menu = findViewById(R.id.menu);
        question = findViewById(R.id.question);
        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);

        question.setDuration(TIME_OUT);
        question.setIsVisible(false);
        question.toggle();
    }

    public void onMenuClick(View view) {

    }

    public void onAnswerAClick(View view) {
        Intent intent = new Intent(this, BathroomActivity.class);
        intent.putExtra("USER", user);
        startActivity(intent);
    }

    public void onAnswerBClick(final View view) {
        user.setDidUserChooseToSleep(true);

        root.setBackgroundColor(getResources().getColor(R.color.violet));
        menu.setVisibility(View.INVISIBLE);
        question.setVisibility(View.INVISIBLE);
        answerA.setVisibility(View.INVISIBLE);
        answerB.setVisibility(View.INVISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                root.setBackgroundResource(R.drawable.bedroom);
                menu.setVisibility(View.VISIBLE);
                question.setText(R.string.bedroom_end);
                question.setVisibility(View.VISIBLE);
                answerA.setText(R.string.to_bathroom);
                answerA.setVisibility(View.VISIBLE);
            }
        }, TIME_OUT * 2);
    }
}
