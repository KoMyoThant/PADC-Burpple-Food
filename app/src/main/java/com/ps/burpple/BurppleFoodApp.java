package com.ps.burpple;

import android.app.Application;

import com.ps.burpple.data.model.BurppleModel;

/**
 * Created by pyaesone on 1/4/18.
 */

public class BurppleFoodApp extends Application {
    public static final String LOG_TAG = "BurppleFoodApp";

    @Override
    public void onCreate() {
        super.onCreate();
        BurppleModel.getInstance().startLoadingPromotion();
    }
}
