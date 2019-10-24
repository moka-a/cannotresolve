package com.example.plus_minus_zero.fragment;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.plus_minus_zero.Model.PlusMinusData;
import com.example.plus_minus_zero.Model.PlusMinusListAdapter;
import com.example.plus_minus_zero.Model.PlusMinusViewModel;
import com.example.plus_minus_zero.Model.ViewModelFactory;
import com.example.plus_minus_zero.R;

import java.util.List;

public class PlusMinusFragment extends Fragment {

    private RecyclerView recyclerView;
    private PlusMinusListAdapter adapter;
    public PlusMinusViewModel mPlusMinusViewModel;
    public Application application;

    public PlusMinusFragment(){
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_plusminus, container, false);

        recyclerView =rootView.findViewById(R.id.recyclerview);

        adapter = new PlusMinusListAdapter(getContext());
        application=getActivity().getApplication();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //mPlusMinusViewModel=new ViewModelProvider(this).get(PlusMinusViewModel .class);
        mPlusMinusViewModel = new ViewModelProvider(this, new ViewModelFactory(application)).get(PlusMinusViewModel .class);

        mPlusMinusViewModel.getAllPlusMinusDataList().observe(this, new Observer<List<PlusMinusData>>() {
            @Override
            public void onChanged(List<PlusMinusData> plusMinusData) {
                adapter.setData(plusMinusData);
            }
        });

        return rootView;
    }
}
