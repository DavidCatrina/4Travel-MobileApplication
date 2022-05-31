package com.example.logininsqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    //declare the variables
    CardView cardView, cardView2, cardView3;
    SearchView searchView;
    Animation anim_from_bottom, anim_from_top, anim_from_left;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Hide the actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //define the variables
        cardView = (CardView) findViewById(R.id.cardView);
        cardView2 = (CardView) findViewById(R.id.cardView2);
        cardView3 = (CardView) findViewById(R.id.cardView3);
        searchView = (SearchView) findViewById(R.id.searchView);

        //Load the animations
        anim_from_bottom = AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom);
        anim_from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
        anim_from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);

        //Set animations the elements used
        cardView.setAnimation(anim_from_bottom);
        cardView2.setAnimation(anim_from_bottom);
        cardView3.setAnimation(anim_from_bottom);
        searchView.setAnimation(anim_from_top);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FirstDestination.class);
                startActivity(intent);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondDestination.class);
                startActivity(intent);
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ThirdDestination.class);
                startActivity(intent);
            }
        });


    }
}