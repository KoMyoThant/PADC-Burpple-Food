package com.ps.burpple.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ps.burpple.delegates.PromotionItemDelegate;

/**
 * Created by pyaesone on 1/13/18.
 */

public class PromotionItemViewHolder extends RecyclerView.ViewHolder {

    private PromotionItemDelegate mDelegate;

    public PromotionItemViewHolder(View itemView, PromotionItemDelegate promotionItemDelegate) {
        super(itemView);
        mDelegate = promotionItemDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDelegate.onTapPromotion();
            }
        });
    }
}
