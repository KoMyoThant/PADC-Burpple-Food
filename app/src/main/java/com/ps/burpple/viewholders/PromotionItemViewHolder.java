package com.ps.burpple.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ps.burpple.R;
import com.ps.burpple.data.vo.PromotionVO;
import com.ps.burpple.delegates.PromotionItemDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pyaesone on 1/13/18.
 */

public class PromotionItemViewHolder extends BaseViewHolder<PromotionVO> {

    @BindView(R.id.iv_promotion_hero_image)
    ImageView ivPromotionHeroImage;

    @BindView(R.id.tv_promotion_item_name)
    TextView tvPromotionItemName;

    @BindView(R.id.tv_promotion_item_location)
    TextView tvPromotionLocation;

    private PromotionItemDelegate mDelegate;

    public PromotionItemViewHolder(View itemView, PromotionItemDelegate promotionItemDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mDelegate = promotionItemDelegate;
    }

    @Override
    public void onClick(View v) {
        mDelegate.onTapPromotion();
    }

    @Override
    public void setData(PromotionVO data) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.img_burpple_guide_placeholder)
                .centerCrop();

        Glide.with(itemView.getRootView().getContext()).load(data.getPromotionImage()).apply(requestOptions).into(ivPromotionHeroImage);
        tvPromotionItemName.setText(data.getPromotionShop().getShopName());
        tvPromotionLocation.setText(data.getPromotionShop().getShopArea());
    }
}
