package com.example.a25090.recyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by 25090 on 2018/3/18.
 */

public class MyAdapter extends RecyclerView.Adapter{
    private Context mContext;
    private List<Map<String,Object>> mDataList;
    private static final int ITEM_VIEW=0;
    private static final int FOOT_VIEW=1;
    public MyAdapter(Context context,List<Map<String,Object>> dataList){
        mContext=context;
        mDataList=dataList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(mContext).inflate(R.layout.item,null);
        View footView=LayoutInflater.from(mContext).inflate(R.layout.foot,null);
        if (viewType==ITEM_VIEW)
            return new ViewHolder(itemView,viewType);
        return new ViewHolder(footView,viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder=(ViewHolder)holder;
        if (getItemViewType(position)==ITEM_VIEW){
            viewHolder.imageThumb.setImageResource((int)mDataList.get(position).get("menu_thumb"));
            viewHolder.tvTitle.setText((String)mDataList.get(position).get("menu_title"));
            viewHolder.tvInfo.setText((String)mDataList.get(position).get("menu_info"));
        }else {
            viewHolder.tvFootView.setText("加载中...");
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==mDataList.size()){
            return FOOT_VIEW;
        }else {
            return ITEM_VIEW;
        }
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageThumb;
        private TextView tvTitle;
        private TextView tvInfo;
        private TextView tvFootView;
        public ViewHolder(View itemView, int viewType) {
            super(itemView);
            if (viewType==ITEM_VIEW){
                imageThumb=(ImageView) itemView.findViewById(R.id.menu_thumb);
                tvTitle=(TextView)itemView.findViewById(R.id.menu_title);
                tvInfo=(TextView)itemView.findViewById(R.id.menu_info);
            }else {
                tvFootView=(TextView)itemView.findViewById(R.id.tv_foot_view);
            }
        }
    }
}
