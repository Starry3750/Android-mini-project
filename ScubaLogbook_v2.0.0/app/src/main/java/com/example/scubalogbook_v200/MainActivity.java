package com.example.scubalogbook_v200;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button AddNewLogBtn = (findViewById(R.id.add_new_log_btn));
        AddNewLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View revealView = findViewById(R.id.reveal_layout);     // Layout to use FULL SCREEN animation
                View buttonView = findViewById(R.id.add_new_log_btn);   // View of "DIVE" button

                int add_new_log_btn_locationX = (int)buttonView.getX();     // X coordinate of "DIVE" button
                int add_new_log_btn_locationY = (int)buttonView.getY();     // Y coordinate of "DIVE" button

                int cx = buttonView.getWidth() / 2;
                int cy = buttonView.getHeight() / 2;

                int circular_reveal_animation_start_coordinateX = add_new_log_btn_locationX + cx;
                int circular_reveal_animation_start_coordinateY = add_new_log_btn_locationY + cy;

                int finalRadius = Math.max(revealView.getWidth(), revealView.getHeight());  // Radius which that Circular reveal animation ends.

                Animator animator =
                        ViewAnimationUtils.createCircularReveal( // set Animator
                                revealView,
                                circular_reveal_animation_start_coordinateX,
                                circular_reveal_animation_start_coordinateY,
                                0,
                                finalRadius);


                animator.setInterpolator(new AccelerateDecelerateInterpolator());   // Interpolator for giving effect to animation
                animator.setDuration(500);                                          // Duration of the animation

                revealView.setVisibility(View.VISIBLE);     // make the view visible
                animator.start();                           // animation starts

                // When Animation ends
                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        revealView.setVisibility(View.INVISIBLE);   // make the view invisible

                        Intent intent = new Intent(MainActivity.this, EnterPrevDiveNum.class);
                        startActivity(intent);      // move to next activity(Enter Previous Dive Number)
                    }
                });

            }
        });
    }

}