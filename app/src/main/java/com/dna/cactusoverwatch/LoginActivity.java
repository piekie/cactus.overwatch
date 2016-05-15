package com.dna.cactusoverwatch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dna.cactusoverwatch.utils.Authentication;
import com.dna.cactusoverwatch.utils.Constants;
import com.dna.cactusoverwatch.utils.Hierarchy;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

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

        String token = getSharedPreferences(Constants.APP_PREFS, Context.MODE_PRIVATE).getString("token", "");
        if (!token.equals("")) {
            root.authWithCustomToken(token, new Firebase.AuthResultHandler() {
                @Override
                public void onAuthenticated(AuthData authData) {
                    //TODO: handler
                }

                @Override
                public void onAuthenticationError(FirebaseError firebaseError) {
                    //TODO: handler
                }
            });

            AuthData authData = root.getAuth();
            if (authData != null) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }

        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_password);

        btnLogin = (Button)findViewById(R.id.button_login);
        btnLogin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int action = motionEvent.getAction();

                switch (action) {
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        String email = etEmail.getText().toString();
                        String password = etPassword.getText().toString();

                        Authentication.login(root, email, password);
                        AuthData authData = root.getAuth();
                        if (authData != null) {
                            //Remembering token (auth)
                            getSharedPreferences(Constants.APP_PREFS, MODE_PRIVATE).edit().
                                    putString("token", authData.getToken()).
                                    commit();

                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

        btnSignUp = (Button)findViewById(R.id.button_sign_up);
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

}
