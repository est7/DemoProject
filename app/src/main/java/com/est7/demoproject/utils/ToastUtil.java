package com.est7.demoproject.utils;

import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.est7.demoproject.ApplicationFromTinkerLike;

import com.est7.demoproject.R;


public class ToastUtil {

    private static ToastUtil tu;
    private static Context context;
    Toast toast;
    String msg;
    private static Handler mHandler;


    static {
        if (tu == null) {
            tu = new ToastUtil(ApplicationFromTinkerLike.getInstance());
        }
    }

    private ToastUtil(Context context) {
        this.context = context;
        mHandler = new Handler(context.getMainLooper());

    }

    public static void show(String msg) {
        tu.setText(msg);
        final Toast toast = tu.create();

        if ("main".equals(Thread.currentThread().getName())) {
            toast.show();
        } else {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    toast.show();
                }
            });
        }

    }

    public static void show(int resId) {
        show(ApplicationFromTinkerLike.getInstance().getString(resId));
    }

    public static void showShort(String msg) {
        tu.setText(msg);
        final Toast toast = tu.createShort();

        if ("main".equals(Thread.currentThread().getName())) {
            toast.show();
        } else {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    toast.show();
                }
            });
        }
    }

    public static void showShort(int resId) {
        showShort(ApplicationFromTinkerLike.getInstance().getString(resId));
    }

    private void setText(String msg) {
        this.msg = msg;
    }

    private Toast create() {
        View contentView = View.inflate(context, R.layout.dialog_toast, null);
        TextView tvMsg = (TextView) contentView.findViewById(R.id.tv_toast_msg);
        toast = new Toast(context);
        toast.setView(contentView);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        tvMsg.setText(msg);
        return toast;
    }

    private Toast createShort() {
        View contentView = View.inflate(context, R.layout.dialog_toast, null);
        TextView tvMsg = (TextView) contentView.findViewById(R.id.tv_toast_msg);
        toast = new Toast(context);
        toast.setView(contentView);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        tvMsg.setText(msg);
        return toast;
    }

}