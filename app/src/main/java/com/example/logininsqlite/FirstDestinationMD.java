package com.example.logininsqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ScrollView;

public class FirstDestinationMD extends AppCompatActivity {

    //declare the variables
    ImageView mainImage;
    ScrollView scrollView;
    Animation anim_from_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Hide the actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_destination_md);

        //define the variables
        mainImage = (ImageView) findViewById(R.id.header_background);
        scrollView = (ScrollView) findViewById(R.id.scrollView);

        //Load the animations
        anim_from_bottom = AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom);

        //Set the animation for the elements used
        scrollView.setAnimation(anim_from_bottom);




    }
}