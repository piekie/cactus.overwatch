package com.dna.cactusoverwatch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dna.cactusoverwatch.utils.Authentication;
import com.dna.cactusoverwatch.utils.Hierarchy;
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

        Firebase.setAndroidContext(this);
        final Firebase root = new Firebase(Hierarchy.DB_ROOT);

        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);

        btnLogin = (Button) findViewById(R.id.button_login);

        btnLogin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int action = motionEvent.getAction();

                switch (action) {
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        String email = etEmail.getText().toString();
                        String password = etPassword.getText().toString();
                        if (validEmail(email) && validPassword(password)) {
                            Authentication.login(root, email, password);
                        } else {
                            Toast.makeText(LoginActivity.this, "Some field is not valid", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        btnSignUp = (Button) findViewById(R.id.button_sign_up);
        btnSignUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int action = motionEvent.getAction();

                switch (action) {
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);

                        intent.putExtra("email", etEmail.getText().toString());
                        intent.putExtra("password", etPassword.getText().toString());

                        startActivity(intent);
                    default:
                        break;
                }

                return true;
            }
        });
    }

    private boolean validPassword(String password) {
        if (password != "") {
            return true;
        }
        return false;
    }

    private static boolean validEmail(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

}
