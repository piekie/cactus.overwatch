package com.dna.cactusoverwatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

            finish();
        } else {
            Toast.makeText(RegistrationActivity.this, "Some field is not valid", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean emailValid() {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(etEmail.getText().toString());
        return m.matches();
    }

    private boolean passwordValid() {
        if (etPassword.getText().toString().equals(etPasswordConfirm.getText().toString())) {
            if(!etPassword.equals("")){
                return true;
            }
        }
        return false;
    }

}
