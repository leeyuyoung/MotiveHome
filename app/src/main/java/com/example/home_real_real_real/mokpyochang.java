package com.example.home_real_real_real;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class mokpyochang extends AppCompatActivity {

    ImageView cb;
    ImageView cb2;
    ImageView cb3;

    ImageView back;

    private boolean isClicked = false;
    private int achievementCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mokpyochang);

        cb = findViewById(R.id.cb);
        cb.setOnClickListener(view -> {
            isClicked = !isClicked;

            if (isClicked)
                cb.setImageResource(R.drawable.shape_clicked);
            else
                cb.setImageResource(R.drawable.shape_unclicked);
        });

        cb2 = findViewById(R.id.cb2);
        cb2.setOnClickListener(view -> {
            isClicked = !isClicked;

            if (isClicked)
                cb2.setImageResource(R.drawable.shape_clicked);
            else
                cb2.setImageResource(R.drawable.shape_unclicked);
        });

        cb3 = findViewById(R.id.cb3);
        cb3.setOnClickListener(view -> {
            isClicked = !isClicked;

            if (isClicked)
                cb3.setImageResource(R.drawable.shape_clicked);
            else
                cb3.setImageResource(R.drawable.shape_unclicked);
        });

        back = findViewById(R.id.back);
        back.setOnClickListener(view -> {
            Intent intent = new
                    Intent(getApplicationContext(),
                    MainActivity.class);
            startActivity(intent);
        });
    }
}