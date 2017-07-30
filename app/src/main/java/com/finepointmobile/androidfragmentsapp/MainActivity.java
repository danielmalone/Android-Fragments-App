package com.finepointmobile.androidfragmentsapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    FloatingActionButton mFab;
    boolean mTwoPaneMode;
    FrameLayout mHeadlines;
    FrameLayout mDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mHeadlines = (FrameLayout) findViewById(R.id.headlines);
        mDetails = (FrameLayout) findViewById(R.id.details);
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mTwoPaneMode = getResources().getBoolean(R.bool.twoPaneMode);

        if (mTwoPaneMode) {
            mHeadlines.setLayoutParams(new LinearLayout.LayoutParams(3, ViewGroup.LayoutParams.MATCH_PARENT, 3));
            mDetails.setLayoutParams(new LinearLayout.LayoutParams(0, 0, 0));
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.headlines, new FragmentHeadlines());
        ft.replace(R.id.details, new FragmentDetails());
        ft.commit();
    }
}
