package com.example.plus_minus_zero.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "plus_minus_table")
public class PlusMinusData {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="ind")
    private int index;

    @NonNull
    @ColumnInfo(name="money")
    private int money;

    @NonNull
    @ColumnInfo(name="phone")
    private String phone;

    @NonNull
    @ColumnInfo(name="date")
    private String date;

    @NonNull
    @ColumnInfo(name="targetName")
    private String targetName;

    
    public PlusMinusData() {
        super();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @NonNull
    public String getPhone() {
        return phone;
    }

    public void setPhone(@NonNull String phone) {
        this.phone = phone;
    }

    @NonNull
    public String getDate() {
        return date;
    }

    public void setDate(@NonNull String date) {
        this.date = date;
    }

    @NonNull
    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(@NonNull String targetName) {
        this.targetName = targetName;
    }
}
