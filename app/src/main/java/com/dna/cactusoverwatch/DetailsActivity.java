package com.dna.cactusoverwatch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dna.cactusoverwatch.cashe.TendersCache;
import com.dna.cactusoverwatch.fragments.FragmentDetails;
import com.dna.cactusoverwatch.utils.Tender;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    public static ViewPager mPagerDetail;
    private MyAdapterDetail myAdapterDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPagerDetail = (ViewPager) findViewById(R.id.viewPager);
        myAdapterDetail = new MyAdapterDetail(getSupportFragmentManager(), TendersCache.tenders);
        mPagerDetail.setAdapter(myAdapterDetail);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public static class MyAdapterDetail extends FragmentPagerAdapter {

        private ArrayList<Tender> mTenders = new ArrayList<Tender>();

        public MyAdapterDetail(FragmentManager fm, ArrayList<Tender> tenders) {
            super(fm);
            mTenders = tenders;
        }

        @Override
        public int getCount() {
            return mTenders.size();
        }

        @Override
        public Fragment getItem(int position) {
            return new FragmentDetails(mTenders.get(position));
        }
    }

}
