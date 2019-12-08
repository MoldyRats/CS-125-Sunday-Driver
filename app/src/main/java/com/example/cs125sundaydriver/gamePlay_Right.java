package com.example.cs125sundaydriver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class gamePlay_Right extends AppCompatActivity {
    AnimationDrawable interstateAnimation;
    MediaPlayer lifeisahighway;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game_play_right);
        lifeisahighway = MediaPlayer.create(getApplicationContext(), R.raw.lifeisahighwayedited);
        lifeisahighway.start();
        Button eject = findViewById(R.id.eject_rightbutton);
        eject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CrashMenu.class);
                startActivity(intent);
                lifeisahighway.stop();
            }
        });
        Button Skrrt = findViewById(R.id.right_button);
        Skrrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), gamePlay_Left.class);
                startActivity(intent);
                lifeisahighway.stop();
            }
        });
        ImageView imageView = findViewById(R.id.interstate125_right);
        imageView.setBackgroundResource(R.drawable.interstateanimation_right);
        interstateAnimation = (AnimationDrawable) imageView.getBackground();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        interstateAnimation.start();
    }
}

