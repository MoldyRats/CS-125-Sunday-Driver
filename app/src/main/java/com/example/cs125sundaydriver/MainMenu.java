package com.example.cs125sundaydriver;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_menu);
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
                Intent startintent = new Intent(getApplicationContext(), gameplay.class);
                startActivity(startintent);
            }
        });
    }
}
