package com.example.cs125sundaydriver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    MediaPlayer intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        intro = MediaPlayer.create(getApplicationContext(), R.raw.hellotwo);
        intro.start();
        //Create a button to exit the game
        Button exitGameBtn = findViewById(R.id.button_Exit_Game);
        //create a setonclicklistener to give the button an action
        exitGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish and exit the game
                System.exit(0);
                finish();
            }
        });
        //create a button to start the game
        Button startGameBtn = findViewById(R.id.button_Start_Game);
        //Create a setOnClickListener to give the button an action
        startGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create an Intent to swicth to the fullscreen activity once clicked
                Intent startintent = new Intent(getApplicationContext(), gamePlay_Right.class);
                startActivity(startintent);
            }
        });
    }
}
