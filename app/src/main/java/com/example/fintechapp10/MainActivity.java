package com.example.fintechapp10;

import static android.view.FrameMetrics.ANIMATION_DURATION;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.RequiresApi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Duration of the splash screen animation in milliseconds
        final long ANIMATION_DURATION = 4000; // 2 seconds
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This finds the view to animate
        View splashView = findViewById(R.id.splashImage);

        // This block of code starts the fadeIn animation
        splashView.setAlpha(0f);
        splashView.animate()
                .alpha(1f)
                .setDuration(ANIMATION_DURATION)
                .withEndAction(() -> {
                    // Animation ended, start the MainActivity
                    Intent intent = new Intent(MainActivity.this, LoginActvity.class);
                    startActivity(intent);
                    finish();
                });
        //this block of code implements the hidden status bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            buildOverStatusBar();
        }
   }
    //This block of code is to hide the status bar so we can build over it
    @RequiresApi(api = Build.VERSION_CODES.R)
    private void buildOverStatusBar() {
        View decorView = getWindow().getDecorView();

        // Hide the status bar
        int flags = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
        decorView.setSystemUiVisibility(flags);

        // Utilize the space in the status bar area by building over it
        FrameLayout rootLayout = findViewById(android.R.id.content);
        rootLayout.setOnApplyWindowInsetsListener((v, insets) -> {
            WindowInsetsController insetsController = v.getWindowInsetsController();
            insetsController.hide(WindowInsets.Type.statusBars());
            return insets;
        });
    }

}
