package com.ps.burpple.networks;

import com.ps.burpple.networks.responses.GetPromotionResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by pyaesone on 1/20/18.
 */

public interface BurppleAPI {

    @FormUrlEncoded
    @POST("v1/getPromotions.php")
    Call<GetPromotionResponse> loadBurpplePromotions(
            @Field("access_token") String accessToken, @Field("page") int pageIndex);
}
