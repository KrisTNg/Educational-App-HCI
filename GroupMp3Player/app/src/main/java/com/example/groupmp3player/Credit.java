package com.example.groupmp3player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Credit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
    }
    public void back(View view)
    {
        Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);


        startActivity(intent2);
    }
}