package com.ps.burpple.events;

import android.content.Context;

import com.ps.burpple.data.vo.PromotionVO;

import java.util.List;

/**
 * Created by pyaesone on 1/20/18.
 */

public class RestAPIEvents {

    public static class EmptyResponseEvent {

    }

    public static class ErrorInvokingAPIEvent {
        private String errorMsg;

        public ErrorInvokingAPIEvent(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }

    public static class PromotionDataLoadedEvent {
        private int loadedPageIndex;
        private List<PromotionVO> loadedPromotion;
        private Context context;

        public PromotionDataLoadedEvent(int loadedPageIndex, List<PromotionVO> loadedPromotion) {
            this.loadedPageIndex = loadedPageIndex;
            this.loadedPromotion = loadedPromotion;
//            this.context = context;
        }

        public int getLoadedPageIndex() {
            return loadedPageIndex;
        }

        public List<PromotionVO> getLoadedPromotions() {
            return loadedPromotion;
        }

        public Context getContext() {
            return context;
        }
    }
}
