package com.mercacortex.testbinding.mvvm.model.db;

import com.mercacortex.testbinding.app.App;
import com.mercacortex.testbinding.mvvm.model.Model;
import com.mercacortex.testbinding.mvvm.model.Model_;

import java.util.Collection;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.android.AndroidScheduler;
import io.objectbox.android.ObjectBoxLiveData;
import io.objectbox.reactive.DataObserver;
import io.objectbox.reactive.DataSubscription;
import io.objectbox.reactive.SubscriptionBuilder;

public class ModelDao {

    public static Box<Model> getModelBox() {
        return App.getApp().getBoxStore().boxFor(Model.class);
    }

    public static DataSubscription subscribeToModelList(DataObserver<List<Model>> observer) {
        return getModelBox().query().build().subscribe().on(AndroidScheduler.mainThread()).observer(observer);
    }

    public static DataSubscription subscribeToModel(DataObserver<Model> observer, long id, boolean singleUpdate) {
        SubscriptionBuilder<Model> builder = getModelBox().query().equal(Model_.id, id).build().subscribe().transform(list -> {
            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }).on(AndroidScheduler.mainThread());

        if (singleUpdate) {
            builder.single();
        }

        return builder.observer(observer);
    }

    public static ObjectBoxLiveData<Model> getAllModelsById() {
        // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
        return new ObjectBoxLiveData<>(getModelBox().query().order(Model_.id).build());
    }

    public static void insertModel(Model model) {
        getModelBox().put(model);
    }

    public static void insertModels(Collection<Model> models) {
        getModelBox().put(models);
    }

}
