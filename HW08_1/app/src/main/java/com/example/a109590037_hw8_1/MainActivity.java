package com.example.a109590037_hw8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    private int level_set;
    private Button plus;
    private Button minu;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plus = findViewById(R.id.button);
        minu = findViewById(R.id.button2);
        level_set = 3;
        img = findViewById(R.id.batteryImageView);
        img.setImageLevel(level_set);
    }
    public void plus(View view) {
        if(level_set <=5) {
            level_set += 1;
            img.setImageLevel(level_set);
        }
    }

    public void minus(View view) {
        if (level_set >= 1){
            level_set -= 1;
            img.setImageLevel(level_set);
        }
    }
}