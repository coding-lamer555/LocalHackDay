package com.example.localhackday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localhackday.utils.AnimatedTextView;

public class StopActivity extends AppCompatActivity {

    private User user;
    private AnimatedTextView question;
    private Button answerA;
    private Button answerB;
    private static int TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);

        user = (User) getIntent().getSerializableExtra("USER");
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
        question.setText(R.string.stop_answerA_result);
        goToNext();
    }

    public void onAnswerBClick(View view) {
        question.setText(R.string.stop_answerB_result);
        goToNext();
    }

    private void goToNext() {
        question.setIsVisible(false);
        question.toggle();
        answerB.setVisibility(View.INVISIBLE);
        answerA.setText(R.string.next);
        answerA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StopActivity.this, BusActivity.class);
                intent.putExtra("USER", user);
                startActivity(intent);
            }
        });
    }
}
