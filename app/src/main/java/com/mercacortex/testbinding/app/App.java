package com.mercacortex.testbinding.app;

import android.app.Application;

import com.mercacortex.testbinding.mvvm.model.MyObjectBox;
import com.mercacortex.testbinding.mvvm.model.repository.ModelRepository;

import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;
import io.objectbox.android.BuildConfig;


public class App extends Application {

    private static App sApp;
    private BoxStore mBoxStore;

    public static App getApp() {
        return sApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        mBoxStore = MyObjectBox.builder().androidContext(this).build();

        //Create mock database
        ModelRepository.initDatabase();
        if (BuildConfig.DEBUG) {
            new AndroidObjectBrowser(mBoxStore).start(this);
        }
    }

    public BoxStore getBoxStore() {
        return mBoxStore;
    }

}