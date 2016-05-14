package com.dna.cactusoverwatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dna.cactusoverwatch.utils.Authentication;
import com.firebase.client.Firebase;

public class RegistrationActivity extends AppCompatActivity {

    Button btnSignUp;
    EditText etPassword;
    EditText etPasswordConfirm;
    EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btnSignUp = (Button) findViewById(R.id.button_sign_up);
        btnSignUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int action = motionEvent.getAction();

                switch (action) {
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        registration();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        etPassword = (EditText) findViewById(R.id.et_password);
        etPasswordConfirm = (EditText) findViewById(R.id.et_password_confirm);
        etEmail = (EditText) findViewById(R.id.et_email);
    }

    public void registration() {
        if (passwordValid() && emailValid()) {
            Firebase root = new Firebase("https://amanda.firebaseio.com");

            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();

            Authentication.signup(root, email, password);
        }
    }

    private boolean emailValid() {
        return true;
    }

    private boolean passwordValid() {
        return true;
    }

}
