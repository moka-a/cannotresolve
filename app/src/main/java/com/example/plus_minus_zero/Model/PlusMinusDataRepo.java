package com.example.plus_minus_zero.Model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PlusMinusDataRepo {

    private PlusMInusDataDao plusMInusDataDao;
    private LiveData<List<PlusMinusData>> mAllData;

    PlusMinusDataRepo(Application application){
        PlusMinusDatabase db = PlusMinusDatabase.getDatabase(application.getApplicationContext());

        plusMInusDataDao = db.plusMInusDataDao();
        mAllData = plusMInusDataDao.getAllPlusMinusData();
    }
    public LiveData<List<PlusMinusData>> getAllData() {
        return mAllData;
    }

    void insert(PlusMinusData plusMinusData){
        new insertAsyncTask(plusMInusDataDao).execute(plusMinusData);
    }

    private static class insertAsyncTask extends AsyncTask<PlusMinusData, Void, Void> {

        private PlusMInusDataDao mAsyncTaskDao;

        insertAsyncTask(PlusMInusDataDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final PlusMinusData... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}
