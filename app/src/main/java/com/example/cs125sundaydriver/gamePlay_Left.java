package com.example.cs125sundaydriver;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class gamePlay_Left extends AppCompatActivity {
    AnimationDrawable interstateAnimation;
    MediaPlayer robZombie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game_play__left);
        robZombie = MediaPlayer.create(getApplicationContext(), R.raw.robzombieedited);
        robZombie.start();
        Button eject = findViewById(R.id.eject_left_button);
        eject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CrashMenu.class);
                startActivity(intent);
                robZombie.stop();
            }
        });
        Button Skrrt = findViewById(R.id.left_button);
        Skrrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), gamePlay_Right.class);
                startActivity(intent);
                robZombie.stop();
            }
        });
        ImageView imageView = findViewById(R.id.interstate125_left);
        imageView.setBackgroundResource(R.drawable.interstateanimation_left);
        interstateAnimation = (AnimationDrawable) imageView.getBackground();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        interstateAnimation.start();
    }
}
