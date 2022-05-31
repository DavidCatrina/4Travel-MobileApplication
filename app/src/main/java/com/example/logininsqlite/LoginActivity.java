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


public class LoginActivity extends AppCompatActivity {

    //declare the variables
    TextView logo;
    EditText email, password;
    Button register, login;
    DBHelper DB;
    Animation anim_from_bottom, anim_from_top, anim_from_left, anim_from_right;
    public static String globalemail = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Hide the actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        //define the variables based on the ID
        logo = (TextView) findViewById(R.id.loginlogo);
        email = (EditText) findViewById(R.id.loginemail);
        password = (EditText) findViewById(R.id.loginpassword);
        login = (Button) findViewById(R.id.loginbtnlogin);
        register = (Button) findViewById(R.id.loginbtnregister);
        DB = new DBHelper(this);

        //Load the animations
        anim_from_bottom = AnimationUtils.loadAnimation(this,R.anim.anim_from_bottom);
        anim_from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
        anim_from_top = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        anim_from_right = AnimationUtils.loadAnimation(this, R.anim.anim_from_right);

        //Set the animation for the elements used
        logo.setAnimation(anim_from_top);
        email.setAnimation(anim_from_left);
        password.setAnimation(anim_from_right);
        login.setAnimation(anim_from_bottom);

        //login button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //save the email and password input as variables
                String user = email.getText().toString();
                String pass = password.getText().toString();

                //check if the fields are empty
                if (user.equals("")||pass.equals("")){
                    Toast.makeText(LoginActivity.this, "Please complete all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    //check the password for the email used
                    Boolean checkuserpass = DB.checkemailpassword(user, pass);
                    //if successful login credentials are used
                    if (checkuserpass == true) {
                        //successful feedback popup
                        Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        //create intent to redirect to Main Menu Activity
                        Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
                        //create global variable to use it for fetching the details in the setting activity
                        globalemail = user;

                        startActivity(intent);


                    }
                    else{
                        //invalid feedback popup
                        Toast.makeText(LoginActivity.this, "Details are incorrect", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        //Dont have an account, register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create intent to redirect to Main Activity(RegisterForm)
                Intent intent = new Intent (getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}