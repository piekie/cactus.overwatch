package com.dna.cactusoverwatch.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dna.cactusoverwatch.R;
import com.dna.cactusoverwatch.utils.Tender;

import java.util.ArrayList;

/**
 * Created by Alex on 22.03.2016.
 * Adapter for RecyclerView in MainActivity.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private static final String TAG = "mRecyclerAdapter";
    private ArrayList<Tender> mTenders;
    private Context mContext;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View mRootView;

        public ViewHolder(View v) {
            super(v);
            mRootView = v;
        }
    }

    public RecyclerAdapter(ArrayList<Tender> tenders, Context context) {
        mTenders = tenders;
        mContext = context;
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // Create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    /**
     * Set element from mTenders at this position of RecyclerView
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {// start Details activity after clicking on card with content of selected note
                /*Intent intent = new Intent(mContext, Details.class);
                intent.putExtra("id", mTenders.get(position).getId());
                mContext.startActivity(intent);*/
            }
        });

        /*((TextView) holder.mRootView.findViewById(R.id.text_view_date)).
                setText(DateToStringConverter.convertDateToString(mTenders.get(position).getDate()));

        ((TextView) holder.mRootView.findViewById(R.id.text_view_content)).
                setText(mTenders.get(position).getContent());

        ((TextView) holder.mRootView.findViewById(R.id.text_view_name)).
                setText(mTenders.get(position).getName());*/

    }

    /**
     * Return the counts of notes
     */
    @Override
    public int getItemCount() {
        return mTenders.size();
    }
}