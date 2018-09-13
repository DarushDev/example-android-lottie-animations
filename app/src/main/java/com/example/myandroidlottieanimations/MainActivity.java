package com.example.myandroidlottieanimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

import static com.airbnb.lottie.LottieDrawable.INFINITE;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView lottieConfetti;
    LottieAnimationView lottieFavorite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottieFavorite = findViewById(R.id.lottie_anim_favourite);

        lottieConfetti = findViewById(R.id.lottie_anim_confetti);
        lottieConfetti.setAnimation("confetti.json");
        lottieConfetti.playAnimation();
        lottieConfetti.setRepeatCount(INFINITE);

        findViewById(R.id.btn_main_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lottieConfetti.isAnimating()) {
                    lottieConfetti.pauseAnimation();
                }

                if (lottieFavorite.isAnimating()) {
                    lottieFavorite.pauseAnimation();
                }
            }
        });

        findViewById(R.id.btn_main_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!lottieConfetti.isAnimating()) {
                    lottieConfetti.resumeAnimation();
                }

                if (!lottieFavorite.isAnimating()) {
                    lottieFavorite.resumeAnimation();
                }
            }
        });

    }
}
