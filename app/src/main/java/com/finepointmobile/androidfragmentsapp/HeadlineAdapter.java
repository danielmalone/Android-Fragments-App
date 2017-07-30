package com.finepointmobile.androidfragmentsapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by danielmalone on 7/29/17.
 */

class HeadlineAdapter extends RecyclerView.Adapter<HeadlineAdapter.ViewHolder> {

    ArrayList<String> mHeadlines;

    public HeadlineAdapter(ArrayList<String> names) {
        mHeadlines = names;
    }

    @Override
    public HeadlineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HeadlineAdapter.ViewHolder holder, int position) {
        holder.mHeadline.setText(mHeadlines.get(position));
    }

    @Override
    public int getItemCount() {
        return mHeadlines.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mHeadline;

        public ViewHolder(View itemView) {
            super(itemView);

            mHeadline = (TextView) itemView.findViewById(R.id.headline);
        }
    }
}
