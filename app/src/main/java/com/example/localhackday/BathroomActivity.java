package com.example.localhackday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localhackday.utils.AnimatedTextView;

public class BathroomActivity extends AppCompatActivity {

    private User user;
    private AnimatedTextView question;
    private Button answerA;
    private Button answerB;
    private Button answerC;
    private static int TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bathroom);

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
        question.setIsVisible(false);
        question.setText(R.string.bathroom_answerA_result);
        question.toggle();

        hideButtonsAndShowNext();
    }

    public void onAnswerBClick(View view) {
        question.setIsVisible(false);
        question.setText(R.string.bathroom_answerBC_result);
        question.toggle();

        hideButtonsAndShowNext();
    }

    public void onAnswerCClick(View view) {
        question.setIsVisible(false);
        question.setText(R.string.bathroom_answerBC_result);
        question.toggle();

        hideButtonsAndShowNext();
    }

    private void hideButtonsAndShowNext() {
        answerA.setVisibility(View.INVISIBLE);
        answerC.setVisibility(View.INVISIBLE);
        answerB.setText(R.string.next);
        answerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question.setIsVisible(false);
                question.setText(R.string.bathroom_question2);
                question.toggle();
                answerA.setText(R.string.bathroom_answerA2);
                answerA.setVisibility(View.VISIBLE);
                answerB.setText(R.string.bathroom_answerB2);
                answerB.setVisibility(View.VISIBLE);
                answerC.setText(R.string.bathroom_answerC2);
                answerC.setVisibility(View.VISIBLE);

                answerA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        question.setIsVisible(false);
                        question.setText(R.string.bathroom_answerA_result2);
                        question.toggle();

                        answerA.setVisibility(View.INVISIBLE);
                        answerC.setVisibility(View.INVISIBLE);
                        answerB.setText(R.string.next);
                        answerB.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(BathroomActivity.this, KitchenActivity.class);
                                intent.putExtra("USER", user);
                                startActivity(intent);
                            }
                        });
                    }
                });

                answerB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        user.incStupidityPoints(1);

                        question.setIsVisible(false);
                        question.setText(R.string.bathroom_answerB_result2);
                        question.toggle();

                        answerA.setVisibility(View.INVISIBLE);
                        answerC.setVisibility(View.INVISIBLE);
                        answerB.setText(R.string.next);
                        answerB.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(BathroomActivity.this, KitchenActivity.class);
                                intent.putExtra("USER", user);
                                startActivity(intent);
                            }
                        });
                    }
                });

                answerC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        question.setIsVisible(false);
                        question.setText(R.string.bathroom_answerC_result2);
                        question.toggle();

                        answerA.setVisibility(View.INVISIBLE);
                        answerC.setVisibility(View.INVISIBLE);
                        answerB.setText(R.string.next);
                        answerB.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(BathroomActivity.this, KitchenActivity.class);
                                intent.putExtra("USER", user);
                                startActivity(intent);
                            }
                        });
                    }
                });
            }
        });
    }
}
