package com.example.a25090.recyclerview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by 25090 on 2018/3/23.
 */

public class MenuItemDecoration extends RecyclerView.ItemDecoration {
    private static final int mDivividerHeight=50;
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        Paint paint=new Paint();
        paint.setColor(Color.RED);

        int childCount=parent.getChildCount();//获取屏幕显示出来的列表项
        for (int i=0;i<childCount;i++){
            View itemView=parent.getChildAt(i);//找出当前显示在屏幕区域的列表项
            int index=parent.getChildAdapterPosition(itemView);//找出找到的view对象在所有列表项中的序号
            if (index==0){
                continue;//编号为0时不画线（因为在上面划线）
            }

            float dividerLeft=parent.getPaddingLeft();
            float dividerRight=parent.getWidth()-parent.getPaddingRight();
            float dividerTop=itemView.getTop()-mDivividerHeight;
            float dividerBottom=itemView.getTop();
            c.drawRect(dividerLeft,dividerTop,dividerRight,dividerBottom,paint);

        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State
            state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildAdapterPosition(view)!=0){
            outRect.top=mDivividerHeight;//偏移
        }

    }
}
