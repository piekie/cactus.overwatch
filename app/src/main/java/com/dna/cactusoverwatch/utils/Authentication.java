package com.dna.cactusoverwatch.utils;

import android.util.Log;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

/**
 * Created by piekie on 5/14/2016.
 */
public class Authentication {

    public static boolean working;

    static public boolean loginWithToken(Firebase root, String token) {
        final boolean[] success = new boolean[1];

        root.authWithCustomToken(token, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                success[1] = true;
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                success[1] = false;
                Log.e("ERROR", "auth error" + firebaseError.toString());
            }
        });

        return success[0];
    }

    static public boolean login(Firebase root, String email, String password) {
        final boolean[] success = new boolean[1];

        root.authWithPassword(email, password, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                success[0] = true;
                Log.i("LOGIN", "LOGIN: okay");
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                Log.i("LOGIN", "LOGIN: not okay " + firebaseError.getMessage());
                success[0] = false;
            }
        });

        return success[0];
    }


    static public boolean signup(Firebase root, String email, String password) {
        final boolean[] success = new boolean[1];

        root.createUser(email, password, new Firebase.ResultHandler() {
            @Override
            public void onSuccess() {
                success[0] = true;
                Log.i("SIGN_UP", "SIGN_UP: okay");
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                success[0] = false;
                Log.i("SIGN_UP", "SIGN_UP: not okay " + firebaseError.getMessage());
            }
        });
        return success[0];
    }
}
