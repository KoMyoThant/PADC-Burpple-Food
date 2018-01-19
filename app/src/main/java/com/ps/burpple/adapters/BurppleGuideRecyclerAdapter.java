package com.ps.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ps.burpple.R;
import com.ps.burpple.viewholders.BurppleGuideViewHolder;

/**
 * Created by pyaesone on 1/12/18.
 */

public class BurppleGuideRecyclerAdapter extends BaseRecyclerAdapter {

    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public BurppleGuideRecyclerAdapter(Context context){
        super(context);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.view_item_burpple_guide,parent,false);

        return new BurppleGuideViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
}
