package com.example.logininsqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    //declare the variables
    ImageView profile_pic;
    TextView logo, page_title, fname_field, fname_value, lname_field, lname_value, email_field, email_value;
    Button btn_logout;
    Animation anim_from_top, anim_from_right, anim_from_bottom, anim_from_left;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Hide the actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        profile_pic = (ImageView) findViewById(R.id.profile_pic);
        logo = (TextView) findViewById(R.id.logo);
        page_title = (TextView) findViewById(R.id.page_title);
        fname_field = (TextView) findViewById(R.id.fname_field);
        fname_value = (TextView) findViewById(R.id.fname_value);
        lname_field = (TextView) findViewById(R.id.lname_field);
        lname_value = (TextView) findViewById(R.id.lname_value);
        email_field = (TextView) findViewById(R.id.email_field);
        email_value = (TextView) findViewById(R.id.email_value);
        btn_logout = (Button) findViewById(R.id.btn_logout);
        DB = new DBHelper(this);

        //Load the animations
        anim_from_bottom = AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom);
        anim_from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
        anim_from_right = AnimationUtils.loadAnimation(this, R.anim.anim_from_right);
        anim_from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);

        //Set the animation for the elements used
        logo.setAnimation(anim_from_top);
        page_title.setAnimation(anim_from_top);
        fname_field.setAnimation(anim_from_top);
        fname_value.setAnimation(anim_from_top);
        lname_field.setAnimation(anim_from_top);
        lname_value.setAnimation(anim_from_top);
        email_field.setAnimation(anim_from_top);
        email_value.setAnimation(anim_from_top);
        btn_logout.setAnimation(anim_from_bottom);


        Cursor res = DB.getDetails(LoginActivity.globalemail);
        if(res.getCount()==0){
            Toast.makeText(SettingsActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();

        }
        else{
            res.moveToFirst();
            fname_value.setText(res.getString(0));
            lname_value.setText(res.getString(1));
            email_value.setText(res.getString(2));
        }

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });








    }
}