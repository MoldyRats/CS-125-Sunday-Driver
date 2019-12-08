package com.example.cs125sundaydriver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class CrashMenu extends AppCompatActivity {
    MediaPlayer hacked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash_menu);
        hacked = MediaPlayer.create(getApplicationContext(), R.raw.hackedintochromecast);
        hacked.start();
        Button mainMenuBtn = findViewById(R.id.button_Main_Menu);
        mainMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuintent = new Intent(getApplicationContext(), MainMenu.class);
                hacked.stop();
                startActivity(menuintent);
            }
        });
        Button restartGameBtn = findViewById(R.id.button_Restart_Game);
        //Create a setOnClickListener to give the button an action
        restartGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create an Intent to swicth to the fullscreen activity once clicked
                Intent startintent = new Intent(getApplicationContext(), gamePlay_Right.class);
                hacked.stop();
                startActivity(startintent);

            }
        });
    }
}
