package com.swipeTest;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyActivity extends Activity implements View.OnTouchListener {
    private GestureDetector mGestureDetector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mGestureDetector = new GestureDetector(new FlingDetector(this));

        ListView list1 = (ListView) findViewById(R.id.list1);
        list1.setOnTouchListener(this);

        list1.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                new String[]{"one", "two", "three"}));

    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (mGestureDetector.onTouchEvent(motionEvent))
            return true;

        return false;
    }
}
