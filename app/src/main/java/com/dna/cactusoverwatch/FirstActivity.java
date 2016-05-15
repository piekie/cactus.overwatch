package com.dna.cactusoverwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

public class FirstActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        addSlide(new FragmentSlide.Builder()
                .background(R.color.colorPrimary)
                .backgroundDark(R.color.colorPrimaryDark)
                .fragment(R.layout.fragment_first)
                .build());
        addSlide(new FragmentSlide.Builder()
                .background(R.color.colorOrange)
                .backgroundDark(R.color.colorOrangeDark)
                .fragment(R.layout.fragment_second)
                .build());
        addSlide(new FragmentSlide.Builder()
                .background(R.color.colorBlue)
                .backgroundDark(R.color.colorBlueDark)
                .fragment(R.layout.fragment_third)
                .build());
        addSlide(new FragmentSlide.Builder()
                .background(R.color.colorPurpur)
                .backgroundDark(R.color.colorPurpurDark)
                .fragment(R.layout.fragment_four)
                .build());
    }
}
