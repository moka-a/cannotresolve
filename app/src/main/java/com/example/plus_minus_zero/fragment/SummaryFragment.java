package com.example.plus_minus_zero.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.plus_minus_zero.R;

public class SummaryFragment extends Fragment {

    public SummaryFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        View view = inflater.inflate( R.layout.fragment_summary, container, false );
        return view;
    }
}
