package com.slavafleer.ratingbartest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static float STEP_SIZE = 0.1f;

    private RatingBar mRatingBar;
    private TextView mTextViewRating;

    private float mRating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRatingBar = (RatingBar)findViewById(R.id.ratingBar);
        mTextViewRating = (TextView)findViewById(R.id.textViewRating);

        mRatingBar.setStepSize(STEP_SIZE);

        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                mRating = rating;
                mTextViewRating.setText(rating + "");
            }
        });
    }

    public void buttonPlus_onClick(View view) {
        if(mRating < 5) {
            mRating += STEP_SIZE;
            mRatingBar.setRating(mRating);
            mTextViewRating.setText(mRating + "");
        }
    }

    public void buttonMinus_onClick(View view) {
        if(mRating > 0) {
            mRating -= STEP_SIZE;
            mRatingBar.setRating(mRating);
            mTextViewRating.setText(mRating + "");
        }
    }
}
