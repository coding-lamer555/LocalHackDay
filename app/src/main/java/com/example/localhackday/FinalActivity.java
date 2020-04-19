package com.example.localhackday;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localhackday.utils.AnimatedTextView;

public class FinalActivity extends AppCompatActivity {

    private AnimatedTextView info;
    private static int TIME_OUT = 3000;
    private static int TIME_OUT_LONG = 6000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        info = findViewById(R.id.info);
        info.setMovementMethod(new ScrollingMovementMethod());
        info.setText(R.string.final_text);
        info.setIsVisible(true);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                info.setTextSize(18);
                info.setText(R.string.final_text2);
                info.setIsVisible(false);
                info.setDuration(TIME_OUT_LONG);
                info.toggle();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        info.setText(R.string.final_text3);
                        info.setIsVisible(false);
                        info.setDuration(TIME_OUT_LONG);
                        info.toggle();

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                info.setText(R.string.final_text4);
                                info.setIsVisible(false);
                                info.setDuration(TIME_OUT_LONG);
                                info.toggle();

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        info.setText(R.string.final_text5);
                                        info.setIsVisible(false);
                                        info.setDuration(TIME_OUT_LONG);
                                        info.toggle();

                                        Intent intent = new Intent(FinalActivity.this, RepeatActivity.class);
                                        startActivity(intent);
                                    }
                                }, TIME_OUT_LONG);
                            }
                        }, TIME_OUT_LONG);
                    }
                }, TIME_OUT_LONG);
            }
        }, TIME_OUT);
    }
}
