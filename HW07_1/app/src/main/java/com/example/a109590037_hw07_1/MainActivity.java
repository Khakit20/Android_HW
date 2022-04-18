package com.example.a109590037_hw07_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE =
            "com.example.android.MainAcitvity.extra.MESSAGE";
    public String Order;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDonutOrder(View view) {
        Intent intent = new Intent(this,
                OrderDount.class);
        startActivity(intent);
    }

    public void showFroyoOrder(View view) {
        Intent intent = new Intent(this,
                OrderCream.class);
        startActivity(intent);
    }

    public void showIceCreamOrder(View view) {
        Intent intent = new Intent(this,
                OrderFroyo.class);
        startActivity(intent);
    }
}