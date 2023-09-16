package com.test.testingdesigns;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class BlurViewTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blur_view_test);

        //We're initialing the BlurView widget here
        BlurView blurView = findViewById(R.id.blurView);
        View decorView = getWindow().getDecorView();

        // ViewGroup is where you want to start blur from.
        // Choose root as close to BlurView in hierarchy as possible.
        //If you are seeking for linear, it is the id of our layout which is the constraint layout.
        ViewGroup rootView = findViewById(R.id.view);

        //Setting the blurRadius here, we're using a float and we can adjust it up to 25.0f
        int blurRadius = (int) 2.0f; // Convert float to int
        Drawable windowBackground = decorView.getBackground();

        blurView.setupWith(rootView, new RenderScriptBlur(this)) // or RenderEffectBlur
                .setFrameClearDrawable(windowBackground) // Optional
                .setBlurRadius(blurRadius);

        //and we've done setting up, you can run it now
    }
}