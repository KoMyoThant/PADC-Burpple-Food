package com.ps.burpple.components;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by pyaesone on 1/19/18.
 */

public class SmartScrollListener extends RecyclerView.OnScrollListener {


    public interface OnSmartScrollListener {
        void onListEndReach();
    }

    private int visibleItemCount, pastVisibleItems, totalItemCount;
    private boolean isListEndReached = false;
    private int previousDy, currentDy;  // Dy = delta y

    private OnSmartScrollListener mSmartScrollListener;

    public SmartScrollListener(OnSmartScrollListener smartScrollListener) {
        this.mSmartScrollListener = smartScrollListener;
    }

    @Override
    public void onScrolled(RecyclerView rv, int dx, int dy) {
        super.onScrolled(rv, dx, dy);

        currentDy = dy;
        if (currentDy > previousDy) {
            // from top to bottom \/
        } else if (currentDy < previousDy) {
            // from bottom to top /\
            isListEndReached = false;
        }

        visibleItemCount = rv.getLayoutManager().getChildCount();
        totalItemCount = rv.getLayoutManager().getItemCount();
        pastVisibleItems = ((LinearLayoutManager) rv.getLayoutManager()).findFirstCompletelyVisibleItemPosition();

        previousDy = currentDy;

    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {
        super.onScrollStateChanged(recyclerView, scrollState);
//        if (scrollState == RecyclerView.SCROLL_STATE_IDLE) {
        if ((visibleItemCount + pastVisibleItems) >= totalItemCount
                && !isListEndReached) {
            isListEndReached = true;
            mSmartScrollListener.onListEndReach();
        }
//        }
    }
}
