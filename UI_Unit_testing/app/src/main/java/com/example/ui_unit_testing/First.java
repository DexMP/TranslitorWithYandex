package com.example.ui_unit_testing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @autor DexMP
 * @version 1.1
 * @see {@link MainActivity}
 */
public class First extends AppCompatActivity {

    ImageView slider;
    Button singIn, registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        setTitle("Меню");
        initData();

        AnimationDrawable animation = new AnimationDrawable();
        animation.addFrame(getResources().getDrawable(R.drawable.logo), 3000);
        animation.addFrame(getResources().getDrawable(R.drawable.slider1), 3000);
        animation.addFrame(getResources().getDrawable(R.drawable.slider2), 3000);
        animation.addFrame(getResources().getDrawable(R.drawable.slider3), 3000);
        animation.addFrame(getResources().getDrawable(R.drawable.slider4), 3000);
        animation.addFrame(getResources().getDrawable(R.drawable.slider5), 3000);
        animation.setOneShot(false);
        ImageView imageAnim = (ImageView) findViewById(R.id.slider);
        imageAnim.setBackgroundDrawable(animation);
        animation.start();

        singIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(First.this, SingIn.class));
            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(First.this, Registration.class));
            }
        });
    }

    private void initData() {
        slider = findViewById(R.id.slider);
       /* singIn = findViewById(R.id.singIn);
        registration = findViewById(R.id.registration);*/
    }
}
