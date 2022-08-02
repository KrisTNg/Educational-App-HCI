package com.example.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button ans0, ans1, ans2, ans3, Start;
    TextView TV_Timer, TV_Score, TV_Question, MSG;
    ProgressBar progressBar;

    Game ng = new Game();

    int secondsLeft = 30;

    CountDownTimer timer = new CountDownTimer(30000, 1000) {
        @Override
        public void onTick(long l) {
            secondsLeft--;
            TV_Timer.setText(Integer.toString(secondsLeft) + "sec");
            progressBar.setProgress(30 - secondsLeft);

        }

        @Override
        public void onFinish() {
            ans0.setEnabled(false);
            ans1.setEnabled(false);
            ans2.setEnabled(false);
            ans3.setEnabled(false);

            MSG.setText("Time is UP!!!" + ng.getNumberCorrect() + "/" + (ng.getTotalQuestions()-1));

            final Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Start.setVisibility(View.VISIBLE);
                }
            }, 4000);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Start = findViewById(R.id.Start);
        ans0 = findViewById(R.id.ans0);
        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);

        TV_Question = findViewById(R.id.TV_Question);
        TV_Score = findViewById(R.id.TV_Score);
        TV_Timer = findViewById(R.id.TV_Timer);
        MSG = findViewById(R.id.MSG);

        progressBar = findViewById(R.id.progressBar);

        TV_Timer.setText("0 Sec");
        TV_Question.setText(" ");
        MSG.setText("Press Start");
        TV_Score.setText("0 pts");

        View.OnClickListener Tool = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button S_button = (Button) view;

                S_button.setVisibility(View.INVISIBLE);
                secondsLeft = 30;
                ng = new Game();
                StartGame();
                timer.start();

            }
        };


        View.OnClickListener answerButtonCL = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button ButtonClick = (Button) view;

                int answerSelected = Integer.parseInt(ButtonClick.getText().toString());
                ng.checkAnswer(answerSelected);
                TV_Score.setText(Integer.toString(ng.getScore()));
                StartGame();
            }
        };

        Start.setOnClickListener(Tool);

        ans0.setOnClickListener(answerButtonCL);
        ans1.setOnClickListener(answerButtonCL);
        ans2.setOnClickListener(answerButtonCL);
        ans3.setOnClickListener(answerButtonCL);






    }

    private void StartGame(){
        //stuff here XD LOL

        ng.makeQuestion();
        int [] answers = ng.getCurrentQuestion().getAnswerArray();

        ans0.setText(Integer.toString(answers[0]));
        ans1.setText(Integer.toString(answers[1]));
        ans2.setText(Integer.toString(answers[2]));
        ans3.setText(Integer.toString(answers[3]));

        ans0.setEnabled(true);
        ans1.setEnabled(true);
        ans2.setEnabled(true);
        ans3.setEnabled(true);

        TV_Question.setText(ng.getCurrentQuestion().getQuestion());

        MSG.setText(ng.getNumberCorrect() + "/" + (ng.getTotalQuestions()-1));



    }
}