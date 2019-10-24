package com.example.plus_minus_zero.fragment;

import androidx.fragment.app.Fragment;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.plus_minus_zero.Model.PhoneNumberList;
import com.example.plus_minus_zero.R;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class InputDataFragment extends Fragment {
    private Context context;
    private Button button;
    public InputDataFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        View view = inflater.inflate( R.layout.fragment_input_data, container, false );
       button = (Button)view.findViewById(R.id.selectPhoneBook);
      context= getActivity().getApplicationContext();
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ArrayList<PhoneNumberList> List= getPhoneNumberList();
               if(!List.isEmpty()){
                   Log.d("아무값이나",List.get(0).getUserPhoneNumber());
               }else{
                   Log.d("작동","되었니?");
               }
           }
       });

        return view;
    }


    public ArrayList<PhoneNumberList> getPhoneNumberList(){
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] projection = new String[]{
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.Contacts.PHOTO_ID,
                ContactsContract.Contacts._ID
        };
        String[] selectionArgs= null;
        String sortOrder = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                +" COLLATE LOCALIZED ASC";
        Application application = new Application();

        Cursor cursor =context.getContentResolver().query(uri,projection,null,selectionArgs,sortOrder);
        LinkedHashSet<PhoneNumberList> hashlist = new LinkedHashSet<>();
        if(cursor.moveToFirst()){
            do{
                long person_id = cursor.getLong(3);
                PhoneNumberList phoneNumberList= new PhoneNumberList();
                phoneNumberList.setUserPhoneNumber(cursor.getString(0));
                phoneNumberList.setPersonId(person_id);
                phoneNumberList.setUserName(cursor.getString(1));

                hashlist.add(phoneNumberList);
            }while(cursor.moveToNext());
        }

        ArrayList<PhoneNumberList> phoneNumberList = new ArrayList<>(hashlist);
        for(int i =0;i<phoneNumberList.size();i++){
            phoneNumberList.get(i).setId(i);
        }
        return phoneNumberList;
    };
}
