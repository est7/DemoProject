package com.est7.demoproject.diyview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import com.est7.demoproject.R;

/**
 * Created by Administrator on 2017/1/10.
 */


public class diyView extends View {
    private static final int DEFAULT_LINE_WIDTH = 14;

    private static final int DEFAULT_LINE_COLOR = Color.WHITE;

    public diyView(Context context) {
        super(context);
        //一般我们View view = new View(context);会被调用
    }

    public diyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        //当我们在xml布局文件中使用View时，会在inflate布局时被调用
    }

    public diyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //跟第二种类似,但是增加style属性设置，这时inflater布局时会调用第三个构造方法。


        //第二个参数就是我们在styles.xml文件中的<declare-styleable>标签
        //即属性集合的标签，在R文件中名称为R.styleable+name
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.refresh);

        //第一个参数为属性集合里面的属性，R文件名称：R.styleable+属性集合名称+下划线+属性名称
        //第二个参数为，如果没有设置这个属性，则设置的默认的值

        int color = ta.getColor(R.styleable.refresh_refresh_line_color, DEFAULT_LINE_COLOR);
        int width = ta.getInteger(R.styleable.refresh_refresh_line_width, DEFAULT_LINE_WIDTH);
        //最后记得将TypedArray对象回收,为什么回收不知道。。。
        ta.recycle();

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //widthMeasureSpec和heightMeasureSpec包含宽和高的信息。
        // 我们在设置宽高时有3个选择：wrap_content、match_parent以及指定固定尺寸，而测量模式也有3种：AT_MOST，EXACTLY，UNSPECIFIED

        //match_parent--->EXACTLY。
        // match_parent就是要利用父View给我们提供的所有剩余空间，而父View剩余空间是确定的，也就是这个测量模式的整数里面存放的尺寸。


        //wrap_content--->AT_MOST
        // 就是我们想要将大小设置为包裹我们的view内容，那么尺寸大小就是父View给我们作为参考的尺寸，只要不超过这个尺寸就可以啦，具体尺寸就根据我们的需求去设定。

        //固定尺寸（如100dp）--->EXACTLY。
        // 用户自己指定了尺寸大小，我们就不用再去干涉了，当然是以指定的大小为主啦。


        //还有一点以前已经知道了，如果使用二进制，我们只需要使用2个bit就可以做到，因为2个bit取值范围是[0,3]里面可以存放4个数足够我们用了
        // int型数据占用32个bit，将int数据的前面2个bit用于区分不同的布局模式，后面30个bit存放的是尺寸的数据。
        //提取测量模式和尺寸
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);


        //这个方法用来设置测想要的view宽高
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);

        //虾米那这个方法用来返回View的最小Width，Height也有对应的方法。
        getSuggestedMinimumWidth();


    }

    //因为我们这个view不是viewGroup,所以我们没有子View需要排列
    //对ViewGroup类，onLayout方法中，我们需要将所有子View的大小宽高设置好
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        //null

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //这里就是画了，要记住3个比较重要的方法
        //requestLayout();
        //View重新调用一次layout过程。

        //invalidate();
        // View重新调用一次draw过程

        //forceLayout();
        //标识View在下一次重绘，需要重新调用layout过程。

    }
}
