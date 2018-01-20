package com.ps.burpple.networks.responses;

import com.google.gson.annotations.SerializedName;
import com.ps.burpple.data.vo.PromotionVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pyaesone on 1/20/18.
 */

public class GetPromotionResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private int pageNo;

    @SerializedName("promotions")
    private List<PromotionVO> promotionList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPageNo() {
        return pageNo;
    }

    public List<PromotionVO> getPromotionList() {
        if(promotionList == null){
            promotionList = new ArrayList<>();
        }
        return promotionList;
    }
}
