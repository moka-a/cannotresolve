package com.example.plus_minus_zero.Model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class PlusMinusViewModel extends AndroidViewModel {
    public LiveData<List<PlusMinusData>> mAllPlusMinusData;
    public PlusMinusDataRepo mPlusMinusDataRepo=new PlusMinusDataRepo(getApplication());

    public PlusMinusViewModel(Application application) {
        super(application);
        mAllPlusMinusData = mPlusMinusDataRepo.getAllData();
    }

    public LiveData<List<PlusMinusData>> getAllPlusMinusDataList(){
        return mAllPlusMinusData;
    }
    public void insert(PlusMinusData plusMInusData){
        mPlusMinusDataRepo.insert(plusMInusData);
    }
}
