package com.example.groupmp3player;


import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Question> questions;
    private int numberCorrect;
    private int numberIncorrect;


    private int totalQuestions;
    private int Score;
    private Question currentQuestion;

    public Game(){
        numberCorrect = 0;
        numberIncorrect = 0;
        totalQuestions = 0;
        Score = 0;
        currentQuestion = new Question(10);
        questions = new ArrayList<Question>();
    }

    public void makeQuestion() {

        currentQuestion = new Question(totalQuestions*2+5);
        totalQuestions++;
        questions.add(currentQuestion);
    }

    public boolean checkAnswer(int submittedAnswer){
        boolean isCorrect;
        if (currentQuestion.getAns() == submittedAnswer){
            numberCorrect++;
            isCorrect = true;
        }
        else{
            numberIncorrect++;
            isCorrect = false;
        }
        Score = (numberCorrect * 10) - (numberIncorrect * 10);
        return isCorrect;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public int getNumberIncorrect() {
        return numberIncorrect;
    }

    public void setNumberIncorrect(int numberIncorrect) {
        this.numberIncorrect = numberIncorrect;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

}
