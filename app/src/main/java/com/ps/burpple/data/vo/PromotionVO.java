package com.ps.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by pyaesone on 1/20/18.
 */

public class PromotionVO {

    @SerializedName("burpple-promotion-id")
    private String promotionId;

    @SerializedName("burpple-promotion-image")
    private String promotionImage;

    @SerializedName("burpple-promotion-title")
    private String promotionTitle;

    @SerializedName("burpple-promotion-until")
    private String promotionUntil;

    @SerializedName("burpple-promotion-shop")
    private ShopVO promotionShop;

    @SerializedName("is-burpple-exclusive")
    private boolean isExclusive;

    @SerializedName("burpple-promotion-terms")
    private List<String> promotionTerms;

    public String getPromotionId() {
        return promotionId;
    }

    public String getPromotionImage() {
        return promotionImage;
    }

    public String getPromotionTitle() {
        return promotionTitle;
    }

    public String getPromotionUntil() {
        return promotionUntil;
    }

    public ShopVO getPromotionShop() {
        return promotionShop;
    }

    public boolean isExclusive() {
        return isExclusive;
    }

    public List<String> getPromotionTerms() {
        return promotionTerms;
    }
}
