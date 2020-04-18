package com.example.localhackday;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.localhackday.utils.AnimatedTextView;

public class BedroomActivity extends AppCompatActivity {

    private User user;
    private ConstraintLayout root;
    private AnimatedTextView question;
    private static int TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedroom);

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
    }

    public void onAnswerBClick(View view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                root.removeAllViews();
                root.setBackgroundColor(getResources().getColor(R.color.colorBack));
                Intent intent = new Intent(BedroomActivity.this, BathroomActivity.class);
                intent.putExtra("USER", user);
                startActivity(intent);
                finish();
            }
        }, TIME_OUT);
    }
}
