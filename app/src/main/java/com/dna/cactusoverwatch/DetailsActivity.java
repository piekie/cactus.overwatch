package com.dna.cactusoverwatch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.dna.cactusoverwatch.cashe.TendersCache;
import com.dna.cactusoverwatch.fragments.FragmentDetails;
import com.dna.cactusoverwatch.utils.Tender;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {


    public static ViewPager mPagerDetail;

    public static ViewPager getmPagerDetail() {
        return mPagerDetail;
    }

    private MyAdapterDetail myAdapterDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Тендери");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mPagerDetail = (ViewPager) findViewById(R.id.viewPager);
        myAdapterDetail = new MyAdapterDetail(getSupportFragmentManager(), TendersCache.tenders);
        mPagerDetail.setAdapter(myAdapterDetail);
        String id = getIntent().getExtras().getString("tenderId");
        for (int i = 0; i < TendersCache.tenders.size(); i++) {
            if (TendersCache.tenders.get(i).getTenderId().equals(id)) {
                mPagerDetail.setCurrentItem(i);
            }
        }
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
            return new FragmentDetails(mTenders.get(position), position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {
            Intent intent = new Intent(DetailsActivity.this, InfoActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
