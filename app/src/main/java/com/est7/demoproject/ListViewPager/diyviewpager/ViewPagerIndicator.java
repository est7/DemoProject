package com.est7.demoproject.ListViewPager.diyviewpager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by est7 on 2017/1/16.
 * <p>
 * 画个圆的linelayout
 */

public class ViewPagerIndicator extends LinearLayout {

    private Context mContext;
    private Paint mPaint;
    private View mMoveView;
    private int mCurrentPosition = 0;
    private float mPositionOffset;
    private int mItemCount = DRFAULT_ITEMCOUNT;
    private int mPadding = DEFAULT_PADDING;
    private int mRadius = DEFAULT_RADIUS;
    //the distance from the left side of the previous item to the left side of the next item.
    private int mDistanceBtwItem = mRadius * 2 + mPadding;

    private static final int DRFAULT_ITEMCOUNT = 5;
    private static final int DEFAULT_RADIUS = 10;
    private static final int DEFAULT_PADDING = 10;

    public ViewPagerIndicator(Context context) {
        this(context, null);
    }

    public ViewPagerIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewPagerIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        setOrientation(LinearLayout.HORIZONTAL);
        setWillNotDraw(false);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GRAY);

        mMoveView = new CircleView(mContext);
        addView(mMoveView);
    }

    public void setItemCount(int count) {
        this.mItemCount = count;
        requestLayout();
    }

    public void setRadius(int radius) {
        this.mRadius = radius;
        this.mDistanceBtwItem = mRadius * 2 + mPadding;
        requestLayout();
    }

    public void setPadding(int padding) {
        this.mPadding = padding;
        this.mDistanceBtwItem = mRadius * 2 + mPadding;
        requestLayout();
    }

    public void setPositionAndOffset(int position, float offset) {
        this.mCurrentPosition = position;
        this.mPositionOffset = offset;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(mPadding + (mRadius * 2 + mPadding) * mItemCount, 2 * mRadius + 2 * mPadding);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mMoveView.layout(
                (int) (mPadding + mDistanceBtwItem * (mCurrentPosition + mPositionOffset)),
                mPadding,
                (int) (mDistanceBtwItem * (1 + mCurrentPosition + mPositionOffset)),
                mPadding + mRadius * 2);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mItemCount; i++) {
            canvas.drawCircle(mRadius + mPadding + mRadius * i * 2 + mPadding * i,
                    mRadius + mPadding, mRadius, mPaint);
        }

    }

    private class CircleView extends View {
        private Paint mPaint;

        public CircleView(Context context) {
            super(context);
            mPaint = new Paint();
            mPaint.setAntiAlias(true);
            //随便一个颜色，这个以后可以set
            mPaint.setColor(Color.argb(255, 255, 176, 93));
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            setMeasuredDimension(mRadius * 2, mRadius * 2);
        }


        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawCircle(mRadius, mRadius, mRadius, mPaint);
        }
    }
}
