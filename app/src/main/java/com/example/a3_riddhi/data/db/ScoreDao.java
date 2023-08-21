package com.example.a3_riddhi.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.a3_riddhi.ui.viewmodel.QuizViewModel;

import com.example.a3_riddhi.data.models.Score;

@Dao
public interface ScoreDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insert(Score resultToAdd);

}
