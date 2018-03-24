package com.example.a25090.recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by 25090 on 2018/3/24.
 */

public abstract class MenuOnScrollListener extends RecyclerView.OnScrollListener {
    private int lastVisibleItem=-1;
    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        if (newState ==RecyclerView.SCROLL_STATE_DRAGGING &&lastVisibleItem+1==recyclerView.getAdapter().getItemCount()){
            loadMore();
        }
    }



    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {//滚动偏移量分为X轴和Y轴
        super.onScrolled(recyclerView, dx, dy);
        if (dy>0){
            LinearLayoutManager linearLayoutManager= (LinearLayoutManager) recyclerView.getLayoutManager();
            lastVisibleItem=linearLayoutManager.findLastVisibleItemPosition();
        }
    }
    public abstract void loadMore();
}
