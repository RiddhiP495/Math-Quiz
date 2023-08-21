package com.example.a3_riddhi.data.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.a3_riddhi.ui.viewmodel.QuizViewModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "result_table")
public class Score implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id;

    private int results;
    private String datePlayed;

    public Score(int results, String datePlayed) {
        this.results = results;
        this.datePlayed = datePlayed;
    }

    public Score(Class<QuizViewModel> quizViewModelClass) {
        this.results = getResults();
    }

    @Override
    public String toString() {
        return "Score{" +
                "results=" + results +
                ", datePlayed='" + datePlayed + '\'' +
                '}';
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public String getDatePlayed() {
        return datePlayed;
    }

    public void setDatePlayed(String datePlayed) {
        this.datePlayed = datePlayed;
    }

}
