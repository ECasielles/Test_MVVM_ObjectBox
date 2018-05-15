package com.mercacortex.testbinding.mvvm.view.adapter;

import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;

import com.mercacortex.testbinding.BR;
import com.mercacortex.testbinding.base.BaseBindAdapter;
import com.mercacortex.testbinding.base.BaseBindHolder;
import com.mercacortex.testbinding.mvvm.model.Model;

import java.util.List;

public class RecyclerViewModelAdapter extends BaseBindAdapter<Model> {

    public RecyclerViewModelAdapter(int layoutResId, @Nullable List<Model> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseBindHolder helper, Model item) {
        ViewDataBinding binding = helper.getBinding();

        //Set model to item_model layout
        binding.setVariable(BR.model, item);
        binding.setVariable(BR.receiver, binding.getRoot().getContext());

        //Force binding update
        binding.executePendingBindings();
    }

}
