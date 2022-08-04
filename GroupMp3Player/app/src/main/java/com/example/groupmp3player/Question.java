package com.example.groupmp3player;

import java.util.Random;

public class Question {

    private int num1;
    private int num2;
    private int ans;

    private int[] answerArray;

    private int answerPosition;

    private int Max;

    private String question;

    public Question(int Max){
        this.Max = Max;
        Random randomNumber = new Random();

        this.num1 = randomNumber.nextInt(Max);
        this.num2 = randomNumber.nextInt(Max);
        char[] ops = {'+' , '-'};

        char op = ops[randomNumber.nextInt(2)];
        switch(op){
            case '+' : this.ans = this.num1 + this.num2;
                break;
            case '-' : this.ans = this.num1 - this.num2;
                break;
        }


        //this.ans = this.num1 + this.num2;

        this.question = Integer.toString(num1) + " " + op +  " " + Integer.toString(num2) + " = ";

        this.answerPosition = randomNumber.nextInt(4);
        this.answerArray = new int[] {0,1,2,3};

        this.answerArray[0] = ans + 1;
        this.answerArray[1] = ans + 5;
        this.answerArray[2] = ans - 1;
        this.answerArray[2] = ans - 2;

        this.answerArray = shuffle(this.answerArray);

        answerArray[answerPosition] = ans;


    }

    private int[] shuffle(int[] array){
        int index, temp;
        Random randomnumbergen = new Random();

        for (int i = array.length - 1; i>0; i--){
            index = randomnumbergen.nextInt(i+1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public double getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getAnswerPosition() {
        return answerPosition;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public int getMax() {
        return Max;
    }

    public void setMax(int max) {
        Max = max;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
