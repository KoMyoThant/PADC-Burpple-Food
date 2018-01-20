package com.ps.burpple.data.model;

import com.ps.burpple.data.vo.PromotionVO;
import com.ps.burpple.events.RestAPIEvents;
import com.ps.burpple.networks.BurppleDataAgentImpl;
import com.ps.burpple.utils.AppConstants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.internal.Utils;

/**
 * Created by pyaesone on 1/20/18.
 */

public class BurppleModel {

    private static BurppleModel objInstance;

    private List<PromotionVO> mPromotions;

    private int promotionPageIndex = 1;

    private BurppleModel() {
        EventBus.getDefault().register(this);
        mPromotions = new ArrayList<>();
    }

    public static BurppleModel getInstance() {
        if (objInstance == null) {
            objInstance = new BurppleModel();
        }

        return objInstance;
    }

    public void startLoadingPromotion() {
        BurppleDataAgentImpl.getInstance().loadBurpples(AppConstants.ACCESS_TOKEN, promotionPageIndex);
    }

    @Subscribe()
    public void onPromotionDataLoaded(RestAPIEvents.PromotionDataLoadedEvent event) {
        mPromotions.addAll(event.getLoadedPromotions());
        promotionPageIndex = event.getLoadedPageIndex() + 1;
    }
}
