package com.example.groupmp3player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void music_screen(View view)
    {
        Intent intent2 = new Intent(getApplicationContext(), musicActivity.class);


        startActivity(intent2);
    }

    public void game_screen(View View)
    {

        Intent intent = new Intent(getApplicationContext(), gameActivity.class);


        startActivity(intent);

    }
}