package com.dna.cactusoverwatch.adapters;
import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.dna.cactusoverwatch.R;

/**
 * Created by Alex on 15.05.2016.
 */
public class ListViewAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    String[] fields;
    String[] fieldsContent;

    public ListViewAdapter(Context context, String[] mFields, String[] mFieldsContent) {
        ctx = context;
        fields = mFields;
        fieldsContent = mFieldsContent;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return fields.length;
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return fields[position];
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.detail_list_item, parent, false);
        }

        ((TextView) view.findViewById(R.id.tv_field)).setText(fields[position]);
        ((TextView) view.findViewById(R.id.tv_field_content)).setText(fieldsContent[position]);

        return view;
    }
}