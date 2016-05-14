package com.dna.cactusoverwatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dna.cactusoverwatch.utils.Authentication;
import com.firebase.client.Firebase;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    Button btnSignUp;
    EditText etEmail;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        Firebase.setAndroidContext(this);

        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);

        btnLogin = (Button)findViewById(R.id.button_login);
        btnLogin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                boolean success = Authentication.login(email, password);

                if (success) {
                    Toast.makeText(getApplicationContext(), "login success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "login failure", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        btnSignUp = (Button)findViewById(R.id.button_sign_up);
        btnSignUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                boolean success = Authentication.signup(email, password);

                if (success) {
                    Toast.makeText(getApplicationContext(), "signup success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "signup failure", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
