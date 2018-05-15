package com.mercacortex.testbinding.mvvm.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.mercacortex.testbinding.R;
import com.mercacortex.testbinding.base.BaseActivity;
import com.mercacortex.testbinding.databinding.ActivityMainBinding;
import com.mercacortex.testbinding.mvvm.view.adapter.RecyclerViewModelAdapter;
import com.mercacortex.testbinding.mvvm.viewmodel.ModelItemViewModel;

import java.util.Objects;


public class MainActivity extends BaseActivity<ActivityMainBinding, ModelItemViewModel> {

    RecyclerViewModelAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Binding initialisation
        mViewModel  = ViewModelProviders.of(this).get(ModelItemViewModel.class);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setViewModel(mViewModel);

        //Generate adapter
        mAdapter = new RecyclerViewModelAdapter(R.layout.item_model, null);
        mAdapter.setOnItemClickListener((adapter, view, position) -> show(mAdapter.getData().get(position).description));

        //Populate adapter
        ModelItemViewModel model = ViewModelProviders.of(this).get(ModelItemViewModel.class);
        model.getModels().observe(this, modelList -> mAdapter.replaceData(Objects.requireNonNull(modelList)));

        //Bind to recyclerView
        mBinding.rcvModelList.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rcvModelList.setAdapter(mAdapter);

        //Force binding update
        mBinding.executePendingBindings();
    }

    @Override
    public void show(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}
