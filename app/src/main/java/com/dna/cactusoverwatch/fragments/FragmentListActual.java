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
import com.dna.cactusoverwatch.utils.Tender;

import java.util.ArrayList;

/**
 * Created by Alex on 14.05.2016.
 */
public class FragmentListActual extends Fragment {

    private static final String ARG_POSITION = "position";

    private ArrayList<Tender> tenders = new ArrayList<Tender>();
    private RecyclerView recyclerViewActual;
    private RecyclerView.LayoutManager mLayoutManager;
    private int position;

    private void loadTenders(){
        Tender tender = new Tender("Afjsdjkfsdjfajlsdfa","ajsdfjsjfsaj","slkdflajsfjask","asdfjnjasdf");
        Tender tender1 = new Tender("Afjsdjkfsdjfajlsdfa","ajsdfjsjfsaj","slkdflajsfjask","asdfjnjasdf");
        Tender tender2= new Tender("Afjsdjkfsdjfajlsdfa","ajsdfjsjfsaj","slkdflajsfjask","asdfjnjasdf");
        Tender tender3 = new Tender("Afjsdjkfsdjfajlsdfa","ajsdfjsjfsaj","slkdflajsfjask","asdfjnjasdf");
        Tender tender4 = new Tender("Afjsdjkfsdjfajlsdfa","ajsdfjsjfsaj","slkdflajsfjask","asdfjnjasdf");
        Tender tender5 = new Tender("Afjsdjkfsdjfajlsdfa","ajsdfjsjfsaj","slkdflajsfjask","asdfjnjasdf");
        tenders.add(tender);
        tenders.add(tender1);
        tenders.add(tender2);
        tenders.add(tender3);
        tenders.add(tender4);
        tenders.add(tender5);
    }

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
        loadTenders();
        recyclerViewActual = (RecyclerView) rootView.findViewById(R.id.recyclerViewActual);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewActual.setLayoutManager(mLayoutManager);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(tenders,getActivity());
        recyclerViewActual.setAdapter(recyclerAdapter);
        return rootView;
    }

}
