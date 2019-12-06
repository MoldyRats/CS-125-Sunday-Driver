package com.example.cs125sundaydriver;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class gamePlay_Left extends AppCompatActivity {
    AnimationDrawable interstateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play__left);
        Button eject = findViewById(R.id.eject_left_button);
        eject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CrashMenu.class);
                startActivity(intent);
            }
        });
        Button Skrrt = findViewById(R.id.left_button);
        Skrrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), gamePlay_Right.class);
                startActivity(intent);
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
