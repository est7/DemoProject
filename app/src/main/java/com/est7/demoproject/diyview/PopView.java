package com.est7.demoproject.diyview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/1/20.
 */

public class PopView extends View {

    private Paint mPaint;

    public PopView(Context context) {
        this(context, null);
    }

    public PopView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PopView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initPaint();
    }

    private void initPaint() {

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        //用圆形笔画

        mPaint.setStrokeCap(Paint.Cap.ROUND);

        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(60.0f);
       //mPaint.setStrokeWidth(2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.translate(0,0);

        /**
         * cx：圆心的x坐标。
         * cy：圆心的y坐标。
         * radius：圆的半径。
         * paint：绘制时所使用的画笔。
         */
        canvas.drawCircle(100,100,50,mPaint);

        int w = (int) (50 * Math.sin(15) + 50);
        int l = (int) (50 - Math.cos(15) * 50);
        canvas.translate(w,l);

        //RectF rectF = new RectF(0,0,200,200);
        mPaint.setStrokeWidth(30.0f);
        canvas.drawLine(0,0,200,200,mPaint);


    }
}
