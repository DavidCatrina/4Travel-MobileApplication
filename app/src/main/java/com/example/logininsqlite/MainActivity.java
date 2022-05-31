package com.example.logininsqlite;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declare the variables
    TextView pagetitle;
    EditText fname, lname, email, password, repassword;
    Button login, register;
    DBHelper DB;
    Animation anim_from_bottom, anim_from_top, anim_from_left, anim_from_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Hide the actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define the variables based on the ID
        pagetitle= (TextView) findViewById(R.id.txtcreateyouraccount);
        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        login = (Button) findViewById(R.id.btnlogin);
        register = (Button) findViewById(R.id.btnregister);
        DB = new DBHelper(this);

        //Load the animations
        anim_from_bottom = AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom);
        anim_from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
        anim_from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        anim_from_right = AnimationUtils.loadAnimation(this, R.anim.anim_from_right);

        //Set the animation for the elements used
        pagetitle.setAnimation(anim_from_top);
        fname.setAnimation(anim_from_left);
        lname.setAnimation(anim_from_right);
        email.setAnimation(anim_from_left);
        password.setAnimation(anim_from_right);
        repassword.setAnimation(anim_from_left);
        register.setAnimation(anim_from_bottom);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname = fname.getText().toString();
                String lastname = lname.getText().toString();
                String user = email.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(firstname.equals("")||lastname.equals("")||user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(MainActivity.this, "Please complete all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkemail(user);
                        if(checkuser == false) {
                            Boolean insert = DB.insertData(firstname, lastname, user, pass);
                            if (insert == true) {
                                Toast.makeText(MainActivity.this, "Registration completed succesfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Email already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent (getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}