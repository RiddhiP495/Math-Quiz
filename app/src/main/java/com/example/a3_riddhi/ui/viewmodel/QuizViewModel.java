package com.example.a3_riddhi.ui.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.a3_riddhi.data.db.MyDatabase;
import com.example.a3_riddhi.data.models.Question;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class QuizViewModel extends AndroidViewModel implements Serializable {

    private final MutableLiveData<String> questionContainer = new MutableLiveData<String>();
    private int results;
    private List<Question> questionList;
    private int numCorrect;
    private int numIncorrect;
    private int totalQuestion;
    private Question currQuestion;

    public QuizViewModel(Application application) {
        super(application);
        MyDatabase db = MyDatabase.getDatabase(application);
        numCorrect = 0;
        numIncorrect = 0;
        totalQuestion =0;
        results = 0;
        currQuestion = new Question(3);
        questionList = new ArrayList<Question>();

    }
    public void makeQuestion(){
        currQuestion = new Question(totalQuestion * 2);
        totalQuestion++;
        questionList.add(currQuestion);
        questionContainer.setValue(String.valueOf(currQuestion));
    }

    public boolean checkAnswer(int subAnswer){
        boolean isCorrect;
        if(currQuestion.getCorrectAnswer() == subAnswer){
            numCorrect++;
            isCorrect = true;
        }else {
            numIncorrect++;
            isCorrect = false;
        }
        results = numCorrect;
        return isCorrect;
    }

    public MutableLiveData<String> getQuestionContainer() {
        return questionContainer;
    }


    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public int getNumCorrect() {
        return numCorrect;
    }

    public void setNumCorrect(int numCorrect) {
        this.numCorrect = numCorrect;
    }

    public int getNumIncorrect() {
        return numIncorrect;
    }

    public void setNumIncorrect(int numIncorrect) {
        this.numIncorrect = numIncorrect;
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public Question getCurrQuestion() {
        return currQuestion;
    }

    public void setCurrQuestion(Question currQuestion) {
        this.currQuestion = currQuestion;
    }



}
