package com.ps.burpple.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ps.burpple.R;
import com.ps.burpple.delegates.PromotionItemDelegate;
import com.ps.burpple.viewholders.PromotionItemViewHolder;

/**
 * Created by pyaesone on 1/6/18.
 */

public class PromotionsRecyclerAdapter extends BaseRecyclerAdapter {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private PromotionItemDelegate mPromotionItemDelegate;

    public PromotionsRecyclerAdapter(Context context, PromotionItemDelegate promotionItemDelegate) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
        mPromotionItemDelegate = promotionItemDelegate;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.view_item_promotion, parent, false);

        return new PromotionItemViewHolder(itemView, mPromotionItemDelegate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
