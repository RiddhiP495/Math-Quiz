package com.example.a3_riddhi.ui.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.a3_riddhi.R;
import com.example.a3_riddhi.adapters.MyAdapter;
import com.example.a3_riddhi.data.models.Score;
import com.example.a3_riddhi.databinding.FragmentHistoryBinding;
import com.example.a3_riddhi.ui.viewmodel.QuizViewModel;
import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    private FragmentHistoryBinding binding;
    //constructor to call HistoryFragment
    public HistoryFragment(){
        super(R.layout.fragment_history);
    }

    //  dataSource and Adapter
    private ArrayList<Score> scoreList = new ArrayList<Score>();
    private MyAdapter adapter;

    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //define datasource
        //TODO---change static datasource to dynamic
        this.scoreList.add(new Score(QuizViewModel.class));


        //create an instance of adapter
        this.adapter = new MyAdapter(view.getContext(),this.scoreList);
        //configure recyclerview
        binding.rvHistory.setLayoutManager(new LinearLayoutManager(view.getContext()));
        binding.rvHistory.addItemDecoration(new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL));
        binding.rvHistory.setAdapter(this.adapter);
    }
}