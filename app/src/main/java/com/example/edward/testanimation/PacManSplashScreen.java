package com.example.edward.testanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class PacManSplashScreen extends ActionBarActivity {

    ImageView orangePacMan,orange;
    Animation animationSlideInLeft, animationSlideOutRight, animationFadeIn;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orangePacMan = (ImageView)findViewById(R.id.pacMan);
        orange = (ImageView) findViewById(R.id.orange);

        animationSlideInLeft = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
        animationSlideOutRight = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        animationSlideInLeft.setDuration(1500);
        animationSlideOutRight.setDuration(1500);

        animationFadeIn.setDuration(3000);

        animationSlideInLeft.setAnimationListener(animationSlideInLeftListener);
        animationSlideOutRight.setAnimationListener(animationSlideOutRightListener);

        orange.startAnimation(animationFadeIn);

        orange.setVisibility(View.VISIBLE);

        orangePacMan.bringToFront();
        orangePacMan.startAnimation(animationSlideInLeft);
        orangePacMan.post(new Runnable() {

            @Override
            public void run() {
                ((AnimationDrawable) orangePacMan.getBackground()).start();

            }

        });

        orangePacMan.setVisibility(View.VISIBLE);

    }

    AnimationListener animationSlideInLeftListener = new AnimationListener(){
        @Override
        public void onAnimationEnd(Animation animation) {
            // TODO Auto-generated method stub
                orangePacMan.startAnimation(animationSlideOutRight);
        }
        @Override
        public void onAnimationRepeat(Animation animation) {
            // TODO Auto-generated method stub
        }
        @Override
        public void onAnimationStart(Animation animation) {
            // TODO Auto-generated method stub
        }};
    AnimationListener animationSlideOutRightListener = new AnimationListener(){
        @Override
        public void onAnimationEnd(Animation animation) {
            // TODO Auto-generated method stub
                orangePacMan.setVisibility(View.INVISIBLE);
        }
        @Override
        public void onAnimationRepeat(Animation animation) {
            // TODO Auto-generated method stub
        }
        @Override
        public void onAnimationStart(Animation animation) {
            // TODO Auto-generated method stub
        }};
}