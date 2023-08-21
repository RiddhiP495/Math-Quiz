package com.example.a3_riddhi.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.a3_riddhi.R;
import com.example.a3_riddhi.data.db.MyDatabase;
import com.example.a3_riddhi.data.db.ScoreDao;
import com.example.a3_riddhi.databinding.FragmentQuizFragmentBinding;
import com.example.a3_riddhi.ui.viewmodel.QuizViewModel;


public class QuizFragment extends Fragment {

    private FragmentQuizFragmentBinding binding;
    private QuizViewModel vm;
    private ScoreDao dao;

    //constructor to call QuizStart
    public QuizFragment(){
        super(R.layout.fragment_quiz_fragment);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.dao = MyDatabase.getDatabase(getContext()).scoreDAO();
    }

    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        binding = FragmentQuizFragmentBinding.inflate(inflater, container, false);
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


        vm = new ViewModelProvider(requireActivity()).get(QuizViewModel.class);

            final Observer<String> questionObserver = new Observer<String>() {
                @Override
                public void onChanged(String s) {
                   // onFinish();
                   //  dao.insert(vm.getResults());
                }

                public void onFinish(){
                    binding.btnPlayAgain.setVisibility(View.VISIBLE);
                    binding.btnOptA.setEnabled(false);
                    binding.btnOptB.setEnabled(false);
                }
            };
            vm.getQuestionContainer().observe(getViewLifecycleOwner(),questionObserver);

            View.OnClickListener ansButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button buttonClick = (Button) view;
                int ansSelected = Integer.parseInt(buttonClick.getText().toString());
                vm.checkAnswer(ansSelected);
                binding.tvScore.setText("Score: " + vm.getNumCorrect() + " out of " + (vm.getTotalQuestion()));
                nextTurn();
            }
        };

        View.OnClickListener startButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button start = (Button) v;
                start.setVisibility(View.INVISIBLE);
                nextTurn();

            }
        };

        binding.btnOptA.setOnClickListener(ansButtonClickListener);
        binding.btnOptB.setOnClickListener(ansButtonClickListener);
        binding.btnStart.setOnClickListener(startButtonListener);
        binding.btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button btn = (Button) view;
                btn.setVisibility(View.VISIBLE);
                nextTurn();
                binding.tvScore.setText("");

            }
        });
    }

    public void nextTurn(){
            vm.makeQuestion();
            int [] answer = vm.getCurrQuestion().getCorrectAnswerArray();
            binding.btnOptA.setText(Integer.toString(answer[0]));
            binding.btnOptB.setText(Integer.toString(answer[1]));
            binding.tvQuestion.setText(vm.getCurrQuestion().getQuestionText());
    }
}