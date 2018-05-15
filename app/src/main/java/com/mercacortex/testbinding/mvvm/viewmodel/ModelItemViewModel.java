package com.mercacortex.testbinding.mvvm.viewmodel;

import android.arch.lifecycle.LiveData;

import com.mercacortex.testbinding.base.BaseViewModel;
import com.mercacortex.testbinding.mvvm.model.Model;
import com.mercacortex.testbinding.mvvm.model.repository.ModelRepository;

import java.util.List;

import io.objectbox.android.ObjectBoxLiveData;

public class ModelItemViewModel extends BaseViewModel {

    //private MutableLiveData<List<Model>> listMutableLiveData;
    private ObjectBoxLiveData<Model> modelLiveData;

    public ModelItemViewModel() {
        //listMutableLiveData = new MutableLiveData<>();
        //listMutableLiveData.setValue(ModelRepository.getModelsLiveData().getValue());
        //modelLiveData = ModelRepository.getModelsLiveData();
        //addSubscription(ModelRepository.subscribeToModelList(this::refreshList));
    }

    private void refreshList(List<Model> models) {
        //listMutableLiveData.postValue(models);
    }

    public LiveData<List<Model>> getModels() {
        //return listMutableLiveData;
        //return modelLiveData;
        return ModelRepository.getModelsLiveData();
    }

    private void refreshList() {
        //ModelRepository.refreshModels();
    }

    /*public ObjectBoxLiveData<Model> getModelLiveData() {
        if (modelLiveData == null) {
            modelLiveData = ModelRepository.getModelsLiveData();
        }
        return modelLiveData;
    }*/

}
