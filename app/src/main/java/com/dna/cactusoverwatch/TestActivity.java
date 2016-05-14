package com.dna.cactusoverwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.firebase.client.Firebase;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Firebase.setAndroidContext(this);
        Firebase root = new Firebase("https://amanda.firebaseio.com/");

        String s = "hello world";

        root.setValue(s);
    }
}
