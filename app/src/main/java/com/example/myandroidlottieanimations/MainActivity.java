package com.example.myandroidlottieanimations;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import static com.airbnb.lottie.LottieDrawable.INFINITE;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final float PLAY_START = 0f;
    private static final float PLAY_END = 0.5f;
    private static final float PAUSE_START = 0.5f;
    private static final float PAUSE_END = 1f;

    LottieAnimationView lottieConfetti;
    LottieAnimationView lottieFavorite;
    LottieAnimationView btnPlayPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottieFavorite = findViewById(R.id.lottie_anim_favourite);
        btnPlayPause = findViewById(R.id.btn_play_pause);

        lottieConfetti = findViewById(R.id.lottie_anim_confetti);
        lottieConfetti.setAnimation("confetti.json");
        lottieConfetti.setRepeatCount(INFINITE);

        btnPlayPause.setOnClickListener(view -> {

            if (lottieFavorite.isAnimating() && lottieConfetti.isAnimating()) {
                lottieConfetti.pauseAnimation();
                lottieFavorite.pauseAnimation();
                changePauseToPlay();
            } else {
                lottieConfetti.resumeAnimation();
                lottieFavorite.playAnimation();
                changePlayToPause();
            }

        });

    }

    private void changePlayToPause() {
        ValueAnimator animator = ValueAnimator.ofFloat(PLAY_START, PLAY_END).setDuration(500);
        animator.addUpdateListener(animation -> btnPlayPause.setProgress((float) animation.getAnimatedValue()));
        animator.start();
    }

    private void changePauseToPlay() {
        ValueAnimator animator = ValueAnimator.ofFloat(PAUSE_START, PAUSE_END).setDuration(500);
        animator.addUpdateListener(animation -> btnPlayPause.setProgress((float) animation.getAnimatedValue()));
        animator.start();
    }
}
