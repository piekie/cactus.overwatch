package com.dna.cactusoverwatch.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.dna.cactusoverwatch.R;
import com.dna.cactusoverwatch.adapters.ListViewAdapter;
import com.dna.cactusoverwatch.utils.Tender;

import java.util.ArrayList;

@SuppressLint("ValidFragment")
public class FragmentDetails extends Fragment {

    private final Tender tender;
    private ListView listView;
    private ListViewAdapter listViewAdapter;
    private String[] fields = {"Назва:", "Замовник:", "Статус:", "Дата відкриття:",
            "Мінімальна ціна:", "Виконавець:", "Дата закриття:", "Кінцева ціна:"};
    private String[] fieldsContent = {"", "", "", "", "", "", "", ""};

    public static FragmentDetails newInstance(Tender tender) {
        FragmentDetails f = new FragmentDetails(tender);
        return f;
    }

    public FragmentDetails(Tender tender) {
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
        listView.setAdapter(listViewAdapter);

        return view;
    }

    private void fillArray() {
        fieldsContent = new String[]{tender.getDescription(), tender.getTitle(), tender.getStatus(),
                tender.getDateOpened(), tender.getStartingPrice(), tender.getExecutor(), tender.getDateClosed(),
                tender.getEndPrice()};
    }
}
