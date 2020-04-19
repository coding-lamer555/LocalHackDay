package com.example.localhackday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localhackday.utils.AnimatedTextView;

public class CafeActivity extends AppCompatActivity {

    private User user;
    private AnimatedTextView question;
    private Button answerA;
    private Button answerB;
    private Button answerC;
    private static int TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);

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
        goToNext();
    }

    public void onAnswerBClick(View view) {
        goToNext();
    }

    public void onAnswerCClick(View view) {
        goToNext();
    }

    private void goToNext() {
        question.setText(R.string.cafe_result);
        question.setDuration(TIME_OUT);
        question.setIsVisible(false);
        question.toggle();

        answerA.setVisibility(View.INVISIBLE);
        answerC.setVisibility(View.INVISIBLE);
        answerB.setText(R.string.next);
        answerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CafeActivity.this, WardrobeFinalActivity.class);
                intent.putExtra("USER", user);
                startActivity(intent);
            }
        });
    }
}
