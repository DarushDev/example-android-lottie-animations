package com.example.myandroidlottieanimations;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;

import static com.airbnb.lottie.LottieDrawable.INFINITE;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final float PLAY_START = 0f;
    private static final float PLAY_END = 0.5f;
    private static final float PAUSE_START = 0.5f;
    private static final float PAUSE_END = 1f;

    RelativeLayout layoutCheckbox;
    LottieAnimationView lottieConfetti;
    LottieAnimationView lottieFavorite;
    LottieAnimationView btnPlayPause;
    LottieAnimationView lottieCheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottieFavorite = findViewById(R.id.lottie_anim_favourite);
        btnPlayPause = findViewById(R.id.btn_play_pause);
        layoutCheckbox = findViewById(R.id.layout_checkbox);
        lottieCheckbox = findViewById(R.id.lottie_checkbox);

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

        layoutCheckbox.setOnClickListener(view -> {
            startCheckboxAnimation();
        });

    }

    private void startCheckboxAnimation() {

        ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f).setDuration(500);
        animator.addUpdateListener(valueAnimator -> {
            lottieCheckbox.setProgress((float) valueAnimator.getAnimatedValue());
        });

        if (lottieCheckbox.getProgress() == 0f) {
            animator.start();
        } else {
            lottieCheckbox.setProgress(0f);
        }

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
