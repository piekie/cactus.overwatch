package com.dna.cactusoverwatch.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.dna.cactusoverwatch.DetailsActivity;
import com.dna.cactusoverwatch.R;
import com.dna.cactusoverwatch.adapters.ListViewAdapter;
import com.dna.cactusoverwatch.cashe.TendersCache;
import com.dna.cactusoverwatch.utils.Tender;
import com.firebase.client.Firebase;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class FragmentDetails extends Fragment {

    private final Tender tender;
    private ListView listView;
    private ListViewAdapter listViewAdapter;
    private String[] fields = {"Назва:", "Замовник:", "Статус:", "Дата відкриття:",
            "Мінімальна ціна:", "Виконавець:", "Дата закриття:", "Кінцева ціна:"};
    private String[] fieldsContent = {"", "", "", "", "", "", "", ""};
    private int number;

    private void fillArray() {
        fieldsContent = new String[]{tender.getDescription(), tender.getTitle(), tender.getStatus(),
                tender.getDateOpened(), tender.getStartingPrice(), tender.getExecutor(), tender.getDateClosed(),
                tender.getEndPrice()};
    }

    public static FragmentDetails newInstance(Tender tender, int number) {
        FragmentDetails f = new FragmentDetails(tender, number);
        return f;
    }

    public FragmentDetails(Tender tender, int number) {
        this.number = number;
        this.tender = tender;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        listView = (ListView) view.findViewById(R.id.listView);
        fillArray();
        listViewAdapter = new ListViewAdapter(getActivity(), fields, fieldsContent);
        View footer = getActivity().getLayoutInflater().inflate(R.layout.futter_buttons, null);
        ((Button) footer.findViewById(R.id.button_good)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Firebase okay
            }
        });
        ((Button) footer.findViewById(R.id.button_bad)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ((Button) footer.findViewById(R.id.button_skip)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TendersCache.tenders.size() > number) {
                    ((DetailsActivity) getActivity()).getmPagerDetail().setCurrentItem(number + 1);
                }

            }
        });
        listView.addFooterView(footer);
        listView.setAdapter(listViewAdapter);

        return view;
    }


}
