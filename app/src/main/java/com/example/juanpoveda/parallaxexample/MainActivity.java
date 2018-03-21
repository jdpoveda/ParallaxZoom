package com.example.juanpoveda.parallaxexample;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NestedScrollView ndv = (NestedScrollView) findViewById(R.id.storyDetailScrollView);
        //ndv.setNestedScrollingEnabled(false);

        ndv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                System.out.println("******* ME" + motionEvent);
                return false;
            }
        });

        ndv.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                System.out.println("******* SC new: " + scrollY + "; old: " + oldScrollY);
            }
        });


        AppBarLayout abl = (AppBarLayout) findViewById(R.id.appBarLayout);
        abl.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                System.out.println("******* Offset: " + verticalOffset);
                if (verticalOffset >= 0) {
                    ObjectAnimator anim = ObjectAnimator.ofFloat(ndv, "Y", 450, 900);
                    anim.setDuration(9000);
                    anim.start();
                }
            }
        });



    }

}
