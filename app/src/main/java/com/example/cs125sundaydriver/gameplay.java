package com.example.cs125sundaydriver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class gameplay extends AppCompatActivity {
    AnimationDrawable interstateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        Button eject = findViewById(R.id.ejectcarbutton);
        eject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CrashMenu.class);
                startActivity(intent);
            }
        });

        ImageView imageView = findViewById(R.id.interstate125);
        imageView.setBackgroundResource(R.drawable.interstateanimation);
        interstateAnimation = (AnimationDrawable) imageView.getBackground();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        interstateAnimation.start();
    }
}

