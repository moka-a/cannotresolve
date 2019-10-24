package com.example.plus_minus_zero.Model;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private Application mApplication;

    public ViewModelFactory(Application application) {
        mApplication = application;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new PlusMinusViewModel(mApplication);
    }

}
