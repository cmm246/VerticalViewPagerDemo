package com.district3.verticalviewpagerdemo;

import android.animation.Animator;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.TextView;

/**
 * Created by chung on 4/19/16.
 */
public class DepthPageTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.75f;
    private TextView mDescription;

    public void transformPage(View view, float position) {
        //int pageWidth = view.getWidth();
        int pageHeight= view.getHeight();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);

        } else if (position <= 0) { // [-1,0]
            // Use the default slide transition when moving to the left page
            view.setAlpha(1);
            //view.setTranslationX(0);
            view.setTranslationY(0);
            view.setScaleX(1);
            view.setScaleY(1);

            // Slide text back down
            mDescription = (TextView) view.findViewById(R.id.myDescription);
            mDescription.setTranslationY(pageHeight * +position);
        } else if (position <= 1) { // (0,1]
            // Fade the page out.
            view.setAlpha(1 - position);

            // Counteract the default slide transition
            //view.setTranslationX(pageWidth * -position);
            view.setTranslationY(pageHeight * -position);

            // Scale the page down (between MIN_SCALE and 1)
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            // Slide text up
            mDescription = (TextView) view.findViewById(R.id.myDescription);
            mDescription.setTranslationY(pageHeight * +position);

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);
        }
    }
}