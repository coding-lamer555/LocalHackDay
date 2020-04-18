package com.example.localhackday;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localhackday.utils.AnimatedTextView;

public class InfoActivity extends AppCompatActivity {

    private AnimatedTextView info;
    private Button begin;
    private static int TIME_OUT = 3000;
    private static int TIME_OUT_LONG = 6000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        info = findViewById(R.id.info);
        info.setMovementMethod(new ScrollingMovementMethod());
        begin = findViewById(R.id.begin);
        /*final ConstraintLayout.LayoutParams currentParams = (ConstraintLayout.LayoutParams) begin.getLayoutParams();
        final ConstraintLayout.LayoutParams touchParams = (ConstraintLayout.LayoutParams) begin.getLayoutParams();
        touchParams.width = begin.getWidth() + 8;
        touchParams.height = begin.getHeight() + 8;

        begin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        begin.setLayoutParams(touchParams);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        //TODO ANIM
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        begin.setLayoutParams(currentParams);
                        break;
                }

                return true;
            }
        });*/
        info.setText(R.string.info);
        info.setDuration(TIME_OUT);
        info.setIsVisible(false);
        info.toggle();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                info.setText(R.string.info2);
                info.setIsVisible(false);
                info.setDuration(TIME_OUT_LONG);
                info.toggle();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        begin.setVisibility(View.VISIBLE);
                    }
                }, TIME_OUT_LONG * 2);
            }
        }, TIME_OUT * 2);
    }

    public void onBeginClick(View view) {
        Intent intent = new Intent(InfoActivity.this, NameActivity.class);
        startActivity(intent);
    }
}
