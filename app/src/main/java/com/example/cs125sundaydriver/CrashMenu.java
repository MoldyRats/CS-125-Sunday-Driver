package com.example.cs125sundaydriver;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CrashMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash_menu);
        Button mainMenuBtn = findViewById(R.id.button_Main_Menu);
        mainMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuintent = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(menuintent);
            }
        });
        Button restartGameBtn = findViewById(R.id.button_Restart_Game);
        //Create a setOnClickListener to give the button an action
        restartGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create an Intent to swicth to the fullscreen activity once clicked
                Intent startintent = new Intent(getApplicationContext(), gameplay.class);
                startActivity(startintent);
            }
        });
    }
}
