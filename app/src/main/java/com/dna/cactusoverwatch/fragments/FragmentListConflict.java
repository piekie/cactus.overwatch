package com.dna.cactusoverwatch.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dna.cactusoverwatch.R;

/**
 * Created by Alex on 14.05.2016.
 */
public class FragmentListConflict extends Fragment {

    private static final String ARG_POSITION = "position";

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

        return rootView;
    }

}
