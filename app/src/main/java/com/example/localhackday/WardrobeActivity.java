package com.example.localhackday;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.localhackday.utils.AnimatedTextView;

public class WardrobeActivity extends AppCompatActivity {

    private User user;
    private AnimatedTextView question;
    private Button answerA;
    private Button answerB;
    private Button answerC;
    private ImageButton personA;
    private ImageButton personB;
    private ImageButton personC;
    private TextView personAText;
    private TextView personBText;
    private TextView personCText;
    private static int TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wardrobe);

        user = (User) getIntent().getSerializableExtra("USER");
        question = findViewById(R.id.question);
        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);
        answerC = findViewById(R.id.answerC);
        personA = findViewById(R.id.personA);
        personB = findViewById(R.id.personB);
        personC = findViewById(R.id.personC);
        personAText = findViewById(R.id.personAText);
        personBText = findViewById(R.id.personBText);
        personCText = findViewById(R.id.personCText);

        //changeSize();
    }

    public void onMenuClick(View view) {

    }

    public void onAnswerAClick(View view) {
        user.incStupidityPoints(5);

        question.setText(R.string.wardrobe_answerA_result);
        hideAndShow();
    }

    public void onAnswerBClick(View view) {
        question.setText(R.string.wardrobe_answerBC_result);
        hideAndShow();
    }

    public void onAnswerCClick(View view) {
        question.setText(R.string.wardrobe_answerBC_result);
        hideAndShow();
    }

    private void hideAndShow() {
        personA.setVisibility(View.INVISIBLE);
        personB.setVisibility(View.INVISIBLE);
        personC.setVisibility(View.INVISIBLE);
        personAText.setVisibility(View.INVISIBLE);
        personBText.setVisibility(View.INVISIBLE);
        personCText.setVisibility(View.INVISIBLE);
        question.setVisibility(View.VISIBLE);

        question.setDuration(TIME_OUT);
        question.setIsVisible(false);
        question.toggle();

        answerA.setVisibility(View.INVISIBLE);
        answerC.setVisibility(View.INVISIBLE);
        answerB.setText(R.string.next);
        answerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WardrobeActivity.this, EntranceActivity.class);
                intent.putExtra("USER", user);
                startActivity(intent);
            }
        });
    }

    private void changeSize() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        ConstraintLayout.LayoutParams personAParams = (ConstraintLayout.LayoutParams) personA.getLayoutParams();
        personAParams.width = width / 2 - 16 - 16 - 16;
        personA.setLayoutParams(personAParams);

        ConstraintLayout.LayoutParams personBParams = (ConstraintLayout.LayoutParams) personB.getLayoutParams();
        personBParams.width = width / 2 - 16 - 16 - 16;
        personB.setLayoutParams(personBParams);

        ConstraintLayout.LayoutParams personCParams = (ConstraintLayout.LayoutParams) personC.getLayoutParams();
        personCParams.width = width / 2 - 16 - 16 - 16;
        personC.setLayoutParams(personCParams);
    }
}
