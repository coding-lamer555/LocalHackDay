package com.example.localhackday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.localhackday.utils.AnimatedTextView;

public class NameActivity extends AppCompatActivity {

    private AnimatedTextView nameTitle;
    private EditText name;
    private static int TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        nameTitle = findViewById(R.id.nameTitle);
        nameTitle.setDuration(TIME_OUT);
        nameTitle.setIsVisible(false);
        nameTitle.toggle();
        name = findViewById(R.id.name);
    }

    public void onNextClick(View view) {
        User user = new User();
        user.setName(String.valueOf(name.getText()));
        Intent intent = new Intent(this, BedroomActivity.class);
        intent.putExtra("USER", user);
        startActivity(intent);
    }
}
