package com.example.plus_minus_zero.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plus_minus_zero.R;

import java.util.List;

public class PlusMinusListAdapter extends RecyclerView.Adapter<PlusMinusListAdapter.PlusMinusViewHolder>{




    class PlusMinusViewHolder extends RecyclerView.ViewHolder{
        private final TextView plusMinusItemView;

        public PlusMinusViewHolder(View itemView) {
            super(itemView);
           plusMinusItemView=itemView.findViewById(R.id.plus_minus_list);
        }
    }

    private final LayoutInflater mlnflaer;
    private List<PlusMinusData> mPlusMinusDataList;
    
    public PlusMinusListAdapter(Context context){mlnflaer=LayoutInflater.from(context);}


    @Override
    public PlusMinusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mlnflaer.inflate(R.layout.recyclerview_item,parent,false);
        return new PlusMinusViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlusMinusViewHolder holder, int position) {
        if(mPlusMinusDataList!=null){
            PlusMinusData current = mPlusMinusDataList.get(position);
            holder.plusMinusItemView.setText(current.getDate()+"/"+current.getTargetName()+"/"+current.getMoney());
        }else{
            holder.plusMinusItemView.setText("기록이 없습니다");
        }
    }

    public void setData(List<PlusMinusData> plusMinusDataList){
        mPlusMinusDataList=plusMinusDataList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mPlusMinusDataList!=null){
            return mPlusMinusDataList.size();
        }else{
            return 0;
        }
    }



}

