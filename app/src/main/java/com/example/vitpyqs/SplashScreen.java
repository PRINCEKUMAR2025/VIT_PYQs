package com.example.vitpyqs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {

    TextView appName;
    LottieAnimationView Lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        appName=findViewById(R.id.appName);
        Lottie=findViewById(R.id.Lottie);

        appName.animate().translationY(-1400).setDuration(2700).setStartDelay(0);
        Lottie.animate().translationY(2000).setDuration(2000).setStartDelay(2900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        },5000);
    }
}