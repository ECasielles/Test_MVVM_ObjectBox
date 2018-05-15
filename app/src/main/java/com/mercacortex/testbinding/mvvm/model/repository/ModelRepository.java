package com.mercacortex.testbinding.mvvm.model.repository;

import com.mercacortex.testbinding.R;
import com.mercacortex.testbinding.mvvm.model.Model;
import com.mercacortex.testbinding.mvvm.model.db.ModelDao;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.android.ObjectBoxLiveData;
import io.objectbox.reactive.DataObserver;
import io.objectbox.reactive.DataSubscription;

public class ModelRepository {

    public static DataSubscription subscribeToModelList(DataObserver<List<Model>> observer) {
        return ModelDao.subscribeToModelList(observer);
    }

    public static DataSubscription subscribeToModel(DataObserver<Model> observer, long id, boolean singleUpdate) {
        return ModelDao.subscribeToModel(observer, id, singleUpdate);
    }

    public static ObjectBoxLiveData<Model> getModelsLiveData() {
        return ModelDao.getAllModelsById();
    }

    //Mock data for testing
    public static void initDatabase() {
        int mTotalCount = 7;
        int valueIcon = R.drawable.ic_test;

        ArrayList<Model> modelList = new ArrayList<>();

        if(ModelDao.getModelBox().count() != mTotalCount) {
            ModelDao.getModelBox().removeAll();
        }

        if(ModelDao.getModelBox().count() == 0) {
            for (int i = 0; i < mTotalCount; i++) {
                modelList.add(new Model("texto" + i, valueIcon));
            }
            ModelDao.getModelBox().put(modelList);
        }

    }

}
