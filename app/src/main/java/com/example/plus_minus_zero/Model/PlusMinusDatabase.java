package com.example.plus_minus_zero.Model;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {PlusMinusData.class}, version = 1)
public abstract class PlusMinusDatabase extends RoomDatabase {

    public abstract PlusMInusDataDao plusMInusDataDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile PlusMinusDatabase  INSTANCE;

    static PlusMinusDatabase  getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PlusMinusDatabase .class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PlusMinusDatabase .class, "plus_minus_table")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Override the onOpen method to populate the database.
     * For this sample, we clear the database every time it is created or opened.
     *
     * If you want to populate the database only when the database is created for the 1st time,
     * override RoomDatabase.Callback()#onCreate
     */
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            // If you want to keep the data through app restarts,
            // comment out the following line.
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    /**
     * Populate the database in the background.
     * If you want to start with more words, just add them.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final PlusMInusDataDao plusMInusDataDao;

        PopulateDbAsync(PlusMinusDatabase  db) {
            plusMInusDataDao = db.plusMInusDataDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            plusMInusDataDao.deleteAll();

            PlusMinusData plusMinusData = new PlusMinusData();
            plusMinusData.setDate("2019/10/14");
            plusMinusData.setIndex(1);
            plusMinusData.setMoney(10000);
            plusMinusData.setPhone("010-6470-9685");
            plusMinusData.setTargetName("친구1");

            plusMInusDataDao.insert(plusMinusData);

            plusMinusData.setDate("2019/10/14");
            plusMinusData.setIndex(2);
            plusMinusData.setMoney(20000);
            plusMinusData.setPhone("010-6470-9685");
            plusMinusData.setTargetName("친구2");

            plusMInusDataDao.insert(plusMinusData);


            Log.d("TEST","데이터넣음");

            return null;
        }
    }


}
