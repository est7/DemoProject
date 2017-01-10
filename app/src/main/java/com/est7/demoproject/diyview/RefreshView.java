package com.est7.demoproject.diyview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.est7.demoproject.R;

import static android.R.attr.path;

/**
 * Created by Administrator on 2017/1/10.
 */

public class RefreshView extends View {

    private static final int DEFAULT_LINE_COLOR = Color.WHITE;

    private static final int DEFAULT_LINE_WIDTH = 14;

    private static final int DEFAULT_DURATION = 2000;

    private Paint mPaint;

    private int mWidth, mHeight;

    private int mCircleRadius;//

    private float mArrowLength;//箭头的长度

    private float mArrowVarLength;

    private float mArcVarLength;

    private int mCenterX, mCenterY;

    private float mArrowX, mArrowY;

    private float mFraction;//这个是指的当前动画的进度，我们就是根据这个进度进行不断的判断和修正的

    private int mDuration;

    public RefreshView(Context context) {
        super(context);
    }

    public RefreshView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.refresh);
        int color = ta.getColor(R.styleable.refresh_refresh_line_color, DEFAULT_LINE_COLOR);
        int width = ta.getInteger(R.styleable.refresh_refresh_line_width, DEFAULT_LINE_WIDTH);
        ta.recycle();
        mDuration = DEFAULT_DURATION;
        //这里就是初始化画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setColor(color);
        mPaint.setStrokeWidth(width);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //初始化各种长度
        mWidth = w;
        mHeight = h;
        mCenterX = mWidth / 2;
        mCenterY = mHeight / 2;
        mCircleRadius = mCenterX / 3 * 2;
        mArrowLength = mWidth / 6;

        mArrowX = (float) (- mCircleRadius * Math.sin(30 * Math.PI / 180));
        mArrowY = (float) (- mCircleRadius * Math.cos(30 * Math.PI / 180));
    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (mFraction <= 0.2) {                     //转上半圈
            mArrowVarLength = (mArrowLength / 0.4f * (0.4f - mFraction));
            mArcVarLength = 119.99f / 0.2f * mFraction;
        } else if (mFraction <= 0.4) {              //转下半圈
            mArrowVarLength = (mArrowLength / 0.4f * (0.4f - mFraction));
            mArcVarLength = 119.99f / 0.2f * (0.4f - mFraction);
        } else if (mFraction <= 0.55) {             //再弹
            mArrowVarLength = (mArrowLength * 1.4f / 0.15f * (mFraction - 0.4f));
            mArcVarLength = - 28 / 0.15f * (mFraction - 0.4f);
        } else if (mFraction <= 0.7) {              //再弹
            mArrowVarLength = mArrowLength * 1.4f - mArrowLength * 0.7f / 0.15f * (mFraction - 0.55f);
            mArcVarLength = - 28 + 36 / 0.15f * (mFraction - 0.55f);
        } else if (mFraction <= 0.85) {             //再弹
            mArrowVarLength = mArrowLength * 0.7f + mArrowLength * 0.5f / 0.15f * (mFraction - 0.7f);
            mArcVarLength = 14 - 20 / 0.15f * (mFraction - 0.7f);
        } else {                                    //再弹
            mArrowVarLength = mArrowLength * 1.2f - mArrowLength * 0.2f / 0.15f * (mFraction - 0.85f);
            mArcVarLength = - 6 + 6 / 0.15f * (mFraction - 0.85f);
        }
        //先保存目前画纸的位置(save)，然后然后移动至正中间，画完后调用restore方法返回到刚才保存的位置。
        canvas.save();
        canvas.translate(mCenterX, mCenterY);
        if (mFraction <= 0.4) {
            //旋转
            canvas.rotate((float) (-10 + 360 / 0.4 * mFraction));
        } else {
            canvas.rotate(-10);
        }

        //在canvas中我们可以绘制的基本类型如下：
        //弧线(arcs)、填充颜色(argb和color)、Bitmap、圆(circle和oval)、点(point)、线(line)、矩形(Rect)、图片(Picture)、圆角矩形 (RoundRect)、文本(text)、顶点(Vertices)、路径(path)

        //参数分别是：左上右下，开始角度，扫过的角度，是否包含，画笔

        canvas.drawArc( - mCircleRadius, - mCircleRadius, mCircleRadius, mCircleRadius, 0 - mArcVarLength, 240 + mArcVarLength, false, mPaint);//这个是划圆弧，没什么好说的

        canvas.drawLine(mArrowX, mArrowY,mArrowX - mArrowVarLength, mArrowY, mPaint);//这个是作箭头的左边翅膀

        canvas.drawLine(mArrowX, mArrowY, mArrowX, mArrowY + mArrowVarLength, mPaint);//这个是作箭头的右边边翅膀
        // 调用restore方法返回到刚才保存的位置。
        canvas.restore();
    }

    public void startRefresh() {

        mArrowLength = mWidth / 6;
        //这个很简单没什么说的
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1.f, 100.f);
        valueAnimator.setDuration(mDuration);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mFraction = valueAnimator.getAnimatedFraction();
                //调用invalidate方法让View重新刷新,再去执行ondraw
                invalidate();
            }
        });
        if (!valueAnimator.isRunning()) {
            valueAnimator.start();
        }
    }

    public void setDuration(int duration) {
        this.mDuration = duration;
    }
}