package com.example.localhackday;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.localhackday.utils.AnimatedTextView;

public class BedroomFinalActivity extends AppCompatActivity {

    private User user;
    private ConstraintLayout root;
    private AnimatedTextView question;
    private static int TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedroom_final);

        user = (User) getIntent().getSerializableExtra("USER");
        root = findViewById(R.id.root);
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
        goToNext();
    }

    public void onAnswerCClick(View view) {
        goToNext();
    }

    private void goToNext() {
        root.removeAllViews();
        root.setBackgroundColor(getResources().getColor(R.color.violet));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(BedroomFinalActivity.this, FinalActivity.class);
                intent.putExtra("USER", user);
                startActivity(intent);
            }
        }, TIME_OUT * 2);
    }
}
