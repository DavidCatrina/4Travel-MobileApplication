package com.example.logininsqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainMenuActivity extends AppCompatActivity {

    //Declare the variables
    TextView logo, pagetitle;
    ImageButton search, calendar, settings;
    Animation anim_from_bottom, anim_from_top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Hide the actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //define the variables based on the ID
        logo = (TextView) findViewById(R.id.mainmenulogo);
        pagetitle = (TextView) findViewById(R.id.txtmainmenutitle);
        search = (ImageButton) findViewById(R.id.btnsearch);
        calendar = (ImageButton) findViewById(R.id.btncalendar);
        settings = (ImageButton) findViewById(R.id.btnsettings);

        //Load the animations
        anim_from_bottom = AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom);
        anim_from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);

        //Set the animation for the elements used
        logo.setAnimation(anim_from_top);
        pagetitle.setAnimation(anim_from_top);
        search.setAnimation(anim_from_bottom);
        calendar.setAnimation(anim_from_bottom);
        settings.setAnimation(anim_from_bottom);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(), CalendarActivity.class);
                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}