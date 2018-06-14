package com.example.ckc.mvvmproject.demo;

import android.view.View;

import com.example.ckc.mvvmproject.BR;
import com.example.ckc.mvvmproject.R;
import com.example.ckc.mvvmproject.databinding.FragmentMvvmTestBinding;
import com.example.ckc.mvvmproject.mvvm.BaseFragment;

/**
 * Created by ckc on 18-6-14.
 */

public class MvvmTestFragment extends BaseFragment<MvvmTestViewModel,FragmentMvvmTestBinding>{
    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_mvvm_test;
    }

    @Override
    protected MvvmTestViewModel bindViewModel(FragmentMvvmTestBinding binding) {
        MvvmTestViewModel model = new MvvmTestViewModel();
        binding.setVariable(BR.viewModel, model);
        return model;
    }

    @Override
    protected void init() {
        super.init();
        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.message="hello world";
                viewModel.notifyPropertyChanged(BR.message);
            }
        });
    }
}
