package com.example.geogg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start1(View v) {
        Intent intent = new Intent(this, MainActivity1.class);
        startActivity(intent);
    }

    public void start2(View v) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    public void start3(View v) {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    public void start4(View v) {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }
}