package com.example.ckc.mvvmproject.mvvm;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ckc on 18-6-13.
 * 与mvp的比较：VM替代presenter DB替代View
 */

public abstract class BaseFragment<VM extends BaseViewModel, DB extends ViewDataBinding> extends Fragment{
    protected VM viewModel;
    protected DB binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(binding==null){
            binding= DataBindingUtil.inflate(inflater,getLayoutRes(),container,false);
            viewModel=bindViewModel(binding);
            init();
        }
        return binding.getRoot();
    }

    /**
     * Return the layout resource like R.layout.my_layout
     *
     * @return the layout resource or zero ("0"), if you don't want to have an UI
     */
    protected abstract int getLayoutRes();

    protected abstract VM bindViewModel(DB binding);


    protected void init(){

    }
}
