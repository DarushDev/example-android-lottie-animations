package com.example.myandroidlottieanimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

import static com.airbnb.lottie.LottieDrawable.INFINITE;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottieAnimationView = findViewById(R.id.lottie_from_code);
        lottieAnimationView.setAnimation("favourite_icon.json");
        lottieAnimationView.playAnimation();
        lottieAnimationView.setRepeatCount(INFINITE);


    }
}
