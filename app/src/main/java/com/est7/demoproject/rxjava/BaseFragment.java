package com.est7.demoproject.rxjava;

import android.app.AlertDialog;
import android.app.Fragment;

import com.est7.demoproject.R;

import butterknife.OnClick;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2016/12/13.
 */

public abstract class BaseFragment extends Fragment {
    protected Disposable mDisposable;

    @OnClick(R.id.tipBtn)
    void tip() {
        new AlertDialog.Builder(getActivity())
                .setTitle(getTitleRes())
                .setView(getActivity().getLayoutInflater().inflate(getDialogRes(), null))
                .show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unsubscribe();
    }

    protected void unsubscribe() {
        //rxjava2
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }

        //rxjava1
        /*
         Subscription subscription;
         if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
         */
    }

    protected abstract int getDialogRes();

    protected abstract int getTitleRes();

}
