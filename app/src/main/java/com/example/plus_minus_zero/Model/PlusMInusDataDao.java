package com.example.plus_minus_zero.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PlusMInusDataDao {

    // LiveData is a data holder class that can be observed within a given lifecycle.
    // Always holds/caches latest version of data. Notifies its active observers when the
    // data has changed. Since we are getting all the contents of the database,
    // we are notified whenever any of the database contents have changed.
    @Query("SELECT * FROM plus_minus_table")
    LiveData<List<PlusMinusData>> getAllPlusMinusData();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(PlusMinusData plusMinusData);
    @Query("DELETE FROM plus_minus_table")
    void deleteAll();
    @Query("SELECT*FROM plus_minus_table WHERE phone=:phone")
    LiveData<List<PlusMinusData>> getSearchPhonePlusMinusData(String phone);


}
