package com.example.plus_minus_zero.fragment;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.plus_minus_zero.R;

public class MinusFragment extends Fragment {

    public MinusFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        View view = inflater.inflate( R.layout.fragment_minus, container, false );
        return view;
    }
}
