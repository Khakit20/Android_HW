package com.example.a109590037_hw06_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public CheckBox Chocolate_syrup;
    public CheckBox Sprinklse;
    public CheckBox Crushed_nuts;
    public CheckBox Cherries;
    public CheckBox Orio_cookie_crumbles;
    public String message="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSubmit(View view) {
        Chocolate_syrup = findViewById(R.id.checkBox2);
        Sprinklse = findViewById(R.id.checkBox3);
        Crushed_nuts = findViewById(R.id.checkBox4);
        Cherries = findViewById(R.id.checkBox5);
        Orio_cookie_crumbles = findViewById(R.id.checkBox);
        if (Orio_cookie_crumbles.isChecked() == true){
            message += "Orio_cookie_crumbles ";
        }
        if (Chocolate_syrup.isChecked() == true){
            message += "Chocolate_syrup ";
        }
        if (Sprinklse.isChecked() == true){
            message += "Sprinklse ";
        }
        if (Crushed_nuts.isChecked() == true){
            message += "Crushed_nuts ";
        }
        if (Cherries.isChecked() == true){
            message += "Cherries ";
        }
        displayToast(message);
        message="";
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
}