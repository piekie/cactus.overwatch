package com.dna.cactusoverwatch.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dna.cactusoverwatch.R;
import com.dna.cactusoverwatch.adapters.RecyclerAdapter;
import com.dna.cactusoverwatch.cashe.TendersCache;
import com.dna.cactusoverwatch.utils.Tender;

import java.util.ArrayList;

/**
 * Created by Alex on 14.05.2016.
 */
public class FragmentListConflict extends Fragment {

    private static final String ARG_POSITION = "position";

    private ArrayList<Tender> tenders = new ArrayList<Tender>();
    private RecyclerView recyclerViewActual;
    private RecyclerView.LayoutManager mLayoutManager;
    private int position;

    public static FragmentListConflict newInstance(int position) {
        FragmentListConflict f = new FragmentListConflict();
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_actual, container, false);
        //TODO: NORMAL GET
        TendersCache.loadTenders(getActivity().getApplicationContext());
        recyclerViewActual = (RecyclerView) rootView.findViewById(R.id.recyclerViewActual);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewActual.setLayoutManager(mLayoutManager);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(TendersCache.tenders,getActivity());
        recyclerViewActual.setAdapter(recyclerAdapter);
        return rootView;
    }

}
