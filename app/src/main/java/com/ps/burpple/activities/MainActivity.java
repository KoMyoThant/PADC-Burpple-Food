package com.ps.burpple.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.ps.burpple.R;
import com.ps.burpple.adapters.BurppleGuideRecyclerAdapter;
import com.ps.burpple.adapters.FoodImagesPagerAdapter;
import com.ps.burpple.adapters.PromotionsRecyclerAdapter;
import com.ps.burpple.components.EmptyViewPod;
import com.ps.burpple.components.SmartRecyclerView;
import com.ps.burpple.components.SmartScrollListener;
import com.ps.burpple.delegates.PromotionItemDelegate;
import com.ps.burpple.events.RestAPIEvents;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements PromotionItemDelegate {

    @BindView(R.id.vp_food_images)
    ViewPager vpFoodImages;

    @BindView(R.id.rv_promotions_foods)
    SmartRecyclerView rvPromotionFoods;

    @BindView(R.id.rv_burpple_guides_foods)
    SmartRecyclerView rvBurppleGuideFoods;

    @BindView(R.id.vp_empty_promotion)
    EmptyViewPod vpEmptyPromotion;

    @BindView(R.id.vp_empty_guide)
    EmptyViewPod vpEmptyGuide;

    private TextView mTextMessage;

    private SmartScrollListener smartScrollListener;

    private PromotionsRecyclerAdapter promotionsRecyclerAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        FoodImagesPagerAdapter foodImagesPagerAdapter = new FoodImagesPagerAdapter(getApplicationContext());
        vpFoodImages.setAdapter(foodImagesPagerAdapter);

        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        vpEmptyPromotion.setEmptyData("Ha Ha No data");
        rvPromotionFoods.setEmptyView(vpEmptyPromotion);
        rvPromotionFoods.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        promotionsRecyclerAdapter = new PromotionsRecyclerAdapter(getApplicationContext(), this);
        rvPromotionFoods.setAdapter(promotionsRecyclerAdapter);

        smartScrollListener = new SmartScrollListener(new SmartScrollListener.OnSmartScrollListener() {
            @Override
            public void onListEndReach() {
                Snackbar.make(rvPromotionFoods, "This is all the data for NOW.", Snackbar.LENGTH_LONG).show();

            }
        });

        rvBurppleGuideFoods.addOnScrollListener(smartScrollListener);

        vpEmptyGuide.setEmptyData("Ha Ha No data");
        rvBurppleGuideFoods.setEmptyView(vpEmptyGuide);
        rvBurppleGuideFoods.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        BurppleGuideRecyclerAdapter burppleGuideRecyclerAdapter = new BurppleGuideRecyclerAdapter(getApplicationContext());
        rvBurppleGuideFoods.setAdapter(burppleGuideRecyclerAdapter);
    }

    @Override
    public void onTapPromotion() {
        Toast.makeText(getApplicationContext(), "Promotion Tap", Toast.LENGTH_SHORT).show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPromotionDataLoaded(RestAPIEvents.PromotionDataLoadedEvent event) {
        promotionsRecyclerAdapter.appendNewData(event.getLoadedPromotions());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onErrorInvokingAPI(RestAPIEvents.ErrorInvokingAPIEvent errorEvent) {
        Snackbar.make(rvPromotionFoods, errorEvent.getErrorMsg(), Snackbar.LENGTH_INDEFINITE).show();
    }
}
