package com.mercacortex.testbinding.base;

import android.arch.lifecycle.LifecycleObserver;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mercacortex.testbinding.mvvm.view.activity.IMessageReceiver;

public abstract class BaseActivity<DB extends ViewDataBinding, VM extends BaseViewModel>
        extends AppCompatActivity implements IMessageReceiver {

    protected DB mBinding;

    protected VM mViewModel;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mBinding = null;

        //LifecycleObserver
        if (mViewModel != null)
            getLifecycle().removeObserver((LifecycleObserver) mViewModel);

        mViewModel = null;
    }

}