package com.dna.cactusoverwatch.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dna.cactusoverwatch.MainActivity;
import com.dna.cactusoverwatch.R;
import com.dna.cactusoverwatch.adapters.RecyclerAdapter;
import com.dna.cactusoverwatch.cashe.TendersCache;
import com.dna.cactusoverwatch.utils.Tender;
import com.pnikosis.materialishprogress.ProgressWheel;

import org.json.JSONArray;
import org.json.JSONObject;
import org.shaded.apache.http.util.ByteArrayBuffer;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by Alex on 14.05.2016.
 */
public class FragmentListActual extends Fragment  implements MainActivity.onLoadListener{

    private static final String ARG_POSITION = "position";

    private static ProgressWheel wheel;
    private RecyclerView recyclerViewActual;
    private RecyclerView.LayoutManager mLayoutManager;
    private int position;

    public static FragmentListActual newInstance(int position) {
        FragmentListActual f = new FragmentListActual();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_actual, container, false);
        recyclerViewActual = (RecyclerView) rootView.findViewById(R.id.recyclerViewActual);
        wheel = (ProgressWheel)rootView.findViewById(R.id.progress_wheel);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewActual.setLayoutManager(mLayoutManager);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(TendersCache.tenders, getActivity());
        recyclerViewActual.setAdapter(recyclerAdapter);

        wheel.setVisibility(View.VISIBLE);
        TendersCache.loadTenders(getActivity());
        wheel.setVisibility(View.GONE);
        return rootView;
    }

    @Override
    public void onLoad() {
    }

    public static class ProgressTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... arg0) {
            String result;
            String temp = "";

            JSONArray jA = new JSONArray();

            try{
                for (int i = 0; i < Integer.parseInt(arg0[0]); i++) {
                    URL myURL = new URL(arg0[i + 1]);

                    URLConnection ucon = myURL.openConnection();

                    InputStream is = ucon.getInputStream();

                    BufferedInputStream bis = new BufferedInputStream(is);

                    ByteArrayBuffer baf = new ByteArrayBuffer(50);

                    int current = 0;
                    while ((current = bis.read()) != -1) {
                        baf.append((byte) current);
                    }

                    temp = new String(baf.toByteArray());
                    JSONObject j = new JSONObject(temp);
                    jA.put(j);
                }

                if (Integer.parseInt(arg0[0]) == 1) {
                    result = temp;
                } else {
                    result = jA.toString();
                }
            }catch(Exception e){
                result = e.getMessage();
            }
            return result;
        }

    }

}
