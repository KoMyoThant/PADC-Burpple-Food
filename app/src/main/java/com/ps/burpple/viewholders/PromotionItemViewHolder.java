package com.ps.burpple.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ps.burpple.data.vo.PromotionVO;
import com.ps.burpple.delegates.PromotionItemDelegate;

/**
 * Created by pyaesone on 1/13/18.
 */

public class PromotionItemViewHolder extends BaseViewHolder<PromotionVO> {

    private PromotionItemDelegate mDelegate;

    public PromotionItemViewHolder(View itemView, PromotionItemDelegate promotionItemDelegate) {
        super(itemView);
        mDelegate = promotionItemDelegate;
    }

    @Override
    public void onClick(View v) {
        mDelegate.onTapPromotion();
    }

    @Override
    public void setData(PromotionVO data) {

    }
}
