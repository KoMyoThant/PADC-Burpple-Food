package com.ps.burpple.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pyaesone on 1/20/18.
 */

public class ShopVO {

    @SerializedName("burpple-shop-id")
    private String shopId;

    @SerializedName("burpple-shop-name")
    private String shopName;

    @SerializedName("burpple-shop-area")
    private String shopArea;

    public String getShopId() {
        return shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public String getShopArea() {
        return shopArea;
    }
}
