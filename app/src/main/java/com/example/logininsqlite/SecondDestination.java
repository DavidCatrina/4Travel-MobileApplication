package com.example.logininsqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class SecondDestination extends AppCompatActivity {

    //declare the variables
    TextView title, description, ratingno, voteno, moredetails;
    ImageView up_arrow_details;
    RatingBar ratingbar;
    Animation anim_from_right, anim_from_bottom, anim_from_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Hide the actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_destination);

        //define the variables
        title = (TextView) findViewById(R.id.sd_title);
        description = (TextView) findViewById(R.id.sd_desc);
        ratingno = (TextView) findViewById(R.id.sd_ratingno);
        voteno = (TextView) findViewById(R.id.sd_rating_voteno);
        moredetails = (TextView) findViewById(R.id.sd_more_details);
        up_arrow_details = (ImageView) findViewById(R.id.sd_arrow_up);
        ratingbar = (RatingBar) findViewById(R.id.sd_rating);

        //Load the animations
        anim_from_bottom = AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom);
        anim_from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
        anim_from_right = AnimationUtils.loadAnimation(this, R.anim.anim_from_right);

        //Set the animation for the elements used
        ratingbar.setAnimation(anim_from_left);
        title.setAnimation(anim_from_right);
        description.setAnimation(anim_from_right);
        ratingno.setAnimation(anim_from_right);
        voteno.setAnimation(anim_from_right);
        up_arrow_details.setAnimation(anim_from_bottom);
        moredetails.setAnimation(anim_from_bottom);

        up_arrow_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondDestinationMD.class);
                startActivity(intent);
            }
        });

        moredetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondDestinationMD.class);
                startActivity(intent);
            }
        });

        up_arrow_details.setOnClickListener((view -> {
            Intent intent = new Intent(getApplicationContext(), SecondDestinationMD.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(up_arrow_details, "background_image_transition");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SecondDestination.this, pairs);
            startActivity(intent, options.toBundle());
        }));

        moredetails.setOnClickListener((view -> {
            Intent intent = new Intent(getApplicationContext(), SecondDestinationMD.class);

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(moredetails, "background_image_transition");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SecondDestination.this, pairs);
            startActivity(intent, options.toBundle());
        }));
    }
}