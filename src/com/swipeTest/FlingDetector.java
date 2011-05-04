package com.swipeTest;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

class FlingDetector extends GestureDetector.SimpleOnGestureListener {

    private int swipeMinDistance;
    private int swipeMinVelocity;
    private static final int swipeMaxDeviation = 250;

    public FlingDetector(Context context) {
        final ViewConfiguration vc = ViewConfiguration.get(context);
        swipeMinDistance = vc.getScaledTouchSlop();
        swipeMinVelocity = vc.getScaledMinimumFlingVelocity();
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        try {
            if (Math.abs(e1.getY() - e2.getY()) > swipeMaxDeviation)
                return false;

            if (e1.getX() - e2.getX() > swipeMinDistance && Math.abs(velocityX) > swipeMinVelocity) {
                Log.i("swipeTest", "Right -> Left Swipe");
                return true;
            } else if (e2.getX() - e1.getX() > swipeMinDistance && Math.abs(velocityX) > swipeMinVelocity) {
                Log.i("swipeTest", "Left -> Right Swipe");
                return true;
            }
        } catch (Exception e) {
            // nothing
        }
        return false;
    }
}