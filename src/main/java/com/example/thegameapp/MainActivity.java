package com.example.thegameapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private Button mainBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBtn = findViewById(R.id.failBtn);


    }

    public static void main(String[] args) {
        System.out.println("hello");

    }

}