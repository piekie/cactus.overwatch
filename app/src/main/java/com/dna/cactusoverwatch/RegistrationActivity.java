package com.dna.cactusoverwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
        etPassword = (EditText) findViewById(R.id.et_password);
        etPasswordConfirm = (EditText) findViewById(R.id.et_password_confirm);
        etEmail = (EditText) findViewById(R.id.et_email);
    }

    public void registration() {
        if (passwordValid() && emailValid()) {

        }
    }

    private boolean emailValid() {
        return true;
    }

    private boolean passwordValid() {
        return true;
    }

}
