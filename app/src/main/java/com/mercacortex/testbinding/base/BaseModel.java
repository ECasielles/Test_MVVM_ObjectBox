package com.mercacortex.testbinding.base;

import android.databinding.BaseObservable;
import android.support.annotation.NonNull;


public abstract class BaseModel extends BaseObservable {

    public BaseModel() {
        super();
    }

    @Override
    public void addOnPropertyChangedCallback(@NonNull OnPropertyChangedCallback callback) {
        super.addOnPropertyChangedCallback(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(@NonNull OnPropertyChangedCallback callback) {
        super.removeOnPropertyChangedCallback(callback);
    }

    @Override
    public void notifyChange() {
        super.notifyChange();
    }

    @Override
    public void notifyPropertyChanged(int fieldId) {
        super.notifyPropertyChanged(fieldId);
    }

}
