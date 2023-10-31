package com.example.vitpyqs;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactUs extends AppCompatActivity {
    Button github;
    TextView textView;
    String email=ApplicationClass.user.getEmail();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        github=findViewById(R.id.github);
        textView=findViewById(R.id.textView);

        textView.setText("ThankYou For Using this Application "+email);


        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/PRINCEKUMAR2025/VIT_PYQs"));
                startActivity(intent);
            }
        });
    }
}