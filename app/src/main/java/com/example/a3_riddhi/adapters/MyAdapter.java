package com.example.a3_riddhi.adapters;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3_riddhi.data.db.MyDatabase;
import com.example.a3_riddhi.data.models.Score;
import com.example.a3_riddhi.databinding.CustomRowLayoutBinding;
import com.example.a3_riddhi.ui.viewmodel.QuizViewModel;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final Context context;
    private final ArrayList<Score> dataSourceArray;
    private CustomRowLayoutBinding binding;


    public MyAdapter(Context context, ArrayList<Score> result){
        this.dataSourceArray = result;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(CustomRowLayoutBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Score results = dataSourceArray.get(position);
        holder.bind(context, results);
    }

    @Override
    public int getItemCount() {
        Log.d("MyAdapter", "getItemCount: Number of items " +this.dataSourceArray.size() );
        return this.dataSourceArray.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        CustomRowLayoutBinding layoutBinding;

        public MyViewHolder(CustomRowLayoutBinding binding){
            super(binding.getRoot());
            this.layoutBinding = binding;
        }

        public void bind(Context context, Score currResult){
            //TODO--set format for date and time
            String date = layoutBinding.tvScoreBoard.getText().toString();
            Date date1 = null;
            try{
                date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").parse(date);
            }catch (ParseException e){
                e.printStackTrace();
            }

            layoutBinding.tvScoreBoard.setText(String.valueOf("Score: " + currResult.getResults()));
            layoutBinding.tvDatePlayed.setText("Date Played: " +currResult.getDatePlayed());

        }
    }
}
