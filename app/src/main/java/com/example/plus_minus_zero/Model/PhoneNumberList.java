package com.example.plus_minus_zero.Model;

import java.io.Serializable;

public class PhoneNumberList implements Serializable {
    private String userPhoneNumber;
    private String userName;
    private long personId=0;
    private int id;

    public PhoneNumberList() {
    }

    public PhoneNumberList(String userPhoneNumber, String userName, long personId, int id) {
        this.userPhoneNumber = userPhoneNumber;
        this.userName = userName;
        this.personId = personId;
        this.id = id;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.userPhoneNumber;
    }
    @Override
    public int hashCode(){
        return getPhoneNubmerChanged().hashCode();
    }
    public String getPhoneNubmerChanged(){
        return userPhoneNumber.replace("-","");
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof PhoneNumberList){
            return getPhoneNubmerChanged().equals(((PhoneNumberList)o).getPhoneNubmerChanged());
        }
        return false;
    }
}

