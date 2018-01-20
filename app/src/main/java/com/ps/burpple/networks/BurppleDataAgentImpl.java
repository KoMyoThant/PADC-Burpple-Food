package com.ps.burpple.networks;

import com.google.gson.Gson;
import com.ps.burpple.events.RestAPIEvents;
import com.ps.burpple.networks.responses.GetPromotionResponse;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pyaesone on 1/20/18.
 */

public class BurppleDataAgentImpl implements BurppleDataAgent {

    private BurppleAPI theAPI;
    private static BurppleDataAgentImpl objInstance;

    public BurppleDataAgentImpl() {
        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/burpple-food-places/apis/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        theAPI = retrofit.create(BurppleAPI.class);
    }

    public static BurppleDataAgentImpl getInstance() {
        if (objInstance == null) {
            objInstance = new BurppleDataAgentImpl();
        }

        return objInstance;
    }

    @Override
    public void loadBurpples(String accessToken, int pageNo) {
        Call<GetPromotionResponse> loadPromotionCall = theAPI.loadBurpplePromotions(accessToken, pageNo);
        loadPromotionCall.enqueue(new Callback<GetPromotionResponse>() {
            @Override
            public void onResponse(Call<GetPromotionResponse> call, Response<GetPromotionResponse> response) {
                GetPromotionResponse getPromotionResponse = response.body();
                if (getPromotionResponse != null && getPromotionResponse.getPromotionList().size() > 0) {
                    RestAPIEvents.PromotionDataLoadedEvent promotionDataLoadedEvent = new RestAPIEvents.PromotionDataLoadedEvent(
                            getPromotionResponse.getPageNo(), getPromotionResponse.getPromotionList());
                    EventBus.getDefault().post(promotionDataLoadedEvent);
                } else {
                    RestAPIEvents.ErrorInvokingAPIEvent errorEvent = new RestAPIEvents.ErrorInvokingAPIEvent("No data can not be fetched.");
                    EventBus.getDefault().post(errorEvent);
                }
            }

            @Override
            public void onFailure(Call<GetPromotionResponse> call, Throwable t) {
                RestAPIEvents.ErrorInvokingAPIEvent errorEvent = new RestAPIEvents.ErrorInvokingAPIEvent(t.getMessage());
                EventBus.getDefault().post(errorEvent);
            }
        });
    }
}
