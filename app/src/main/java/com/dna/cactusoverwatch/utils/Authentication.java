package com.dna.cactusoverwatch.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

/**
 * Created by piekie on 5/14/2016.
 */
public class Authentication {

    private static boolean success;

    static public boolean login(String email, String password) {
        Firebase root = new Firebase(Hierarchy.DB_ROOT);

        success = true;

        root.authWithPassword(email, password, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                success = true;
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                success = false;
                Log.e("ERROR", "auth error" + firebaseError.toString());
            }
        });

        return success;
    }


    static public boolean signup(String email, String password) {
        Firebase root = new Firebase(Hierarchy.DB_ROOT);

        success = true;

        root.createUser(email, password, new Firebase.ResultHandler() {
            @Override
            public void onSuccess() {
                success = true;
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                Log.e("ERROR", "auth error" + firebaseError.toString());
                success = false;
            }
        });
        return success;
    }
}
