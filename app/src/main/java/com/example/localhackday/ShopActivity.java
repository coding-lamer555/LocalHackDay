package com.example.localhackday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localhackday.utils.AnimatedTextView;

public class ShopActivity extends AppCompatActivity {

    private User user;
    private AnimatedTextView question;
    private Button answerA;
    private Button answerB;
    private Button answerC;
    private Button answerD;
    private static int TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        user = (User) getIntent().getSerializableExtra("USER");
        question = findViewById(R.id.question);
        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);
        answerC = findViewById(R.id.answerC);
        answerD = findViewById(R.id.answerD);

        question.setDuration(TIME_OUT);
        question.setIsVisible(false);
        question.toggle();
    }

    public void onMenuClick(View view) {

    }

    public void onAnswerAClick(View view) {
        question.setText(R.string.shop_answerA_result);
        answerC.setText(R.string.buy);
        goToNext();
    }

    public void onAnswerBClick(View view) {
        question.setText(R.string.shop_answerB_result);
        answerC.setText(R.string.buy);
        goToNext();
    }

    public void onAnswerCClick(View view) {
        question.setText(R.string.shop_answerC_result);
        answerC.setText(R.string.home);
        goToNext();
    }

    public void onAnswerDClick(View view) {
        question.setText(R.string.shop_answerD_result);
        answerC.setText(R.string.home);
        goToNext();
    }

    private void goToNext() {
        question.setIsVisible(false);
        question.toggle();
        answerA.setVisibility(View.INVISIBLE);
        answerB.setVisibility(View.INVISIBLE);
        answerD.setVisibility(View.INVISIBLE);
        answerC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShopActivity.this, WardrobeFinalActivity.class);
                intent.putExtra("USER", user);
                startActivity(intent);
            }
        });
    }
}
