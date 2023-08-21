package com.example.a3_riddhi.data.models;

import java.util.Random;

public class Question {

    private int firstNumber;
    private int secondNumber;
    private int correctAnswer;

    //there are two possible answer to choose within
    private int [] correctAnswerArray;

    //provide the position of answer from 0,1
    private int correctAnswerPosition;

    //the maximum value of first and second number
    private int maxNumberLimit;

    //string output to the display
    private String questionText;

    //generate new random question
    public Question(int maxNumberLimit){

        this.maxNumberLimit = maxNumberLimit;
        this.getIncorrectAnswer();
    }

    private int getIncorrectAnswer(){
        Random randomNumber = new Random();
        //TODO--- Generate fuc with this logic getIncorrectAnswer() which is correct ans -1
        this.firstNumber = randomNumber.nextInt(maxNumberLimit+1);
        this.secondNumber = randomNumber.nextInt(maxNumberLimit+1);
        this.correctAnswer = this.firstNumber + this.secondNumber;

        this.correctAnswerPosition = randomNumber.nextInt(2);
        this.correctAnswerArray = new int[] {0,1};

        this.correctAnswerArray[0] = correctAnswer + 1;
        this.correctAnswerArray[1] = correctAnswer - 1;
        this.correctAnswerArray = shuffle(this.correctAnswerArray);
        this.questionText = "What is " + firstNumber + "+" + secondNumber + "?";

        correctAnswerArray[correctAnswerPosition] = correctAnswer;
        return 0;
    }

    //to shuffle correct and incorrect answer position
    private int[] shuffle(int[] array){
        int index, temp;
        Random randomValue = new Random();
        for(int i = array.length -1; i>0; i--){
            index = randomValue.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    //getters and setter of the variable created
    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int[] getCorrectAnswerArray() {
        return correctAnswerArray;
    }

    public void setCorrectAnswerArray(int[] correctAnswerArray) {
        this.correctAnswerArray = correctAnswerArray;
    }

    public int getCorrectAnswerPosition() {
        return correctAnswerPosition;
    }

    public void setCorrectAnswerPosition(int correctAnswerPosition) {
        this.correctAnswerPosition = correctAnswerPosition;
    }

    public int getMaxNumberLimit() {
        return maxNumberLimit;
    }

    public void setMaxNumberLimit(int maxNumberLimit) {
        this.maxNumberLimit = maxNumberLimit;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
}

