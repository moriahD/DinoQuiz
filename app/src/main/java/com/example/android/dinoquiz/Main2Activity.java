package com.example.android.dinoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


    }
    int score =0;

    //when submit button is clicked
    public void submit(View view) {
        //Question 1 :answer
        RadioButton answer1Button= (RadioButton) findViewById(R.id.around700);
        boolean clickAnswer1 = answer1Button.isChecked();

        //Question 2:answer
        //** I don't know how to write code for this one. answer will be 'Argentinosaurs' I guess I should use if else statement ...but how do i start?


        //Question 3:answer
        RadioButton answer3Button = (RadioButton) findViewById(R.id.yes);
        boolean clickAnswer3 = answer3Button.isChecked();

        //Question 4 has 4 answers
        //answer 4_1
        CheckBox answers4_1 = (CheckBox) findViewById(R.id.answer4_1);
        boolean hasAnswers4one = answers4_1.isChecked();
        //answer 4_2
        CheckBox answers4_2 = (CheckBox) findViewById(R.id.answer4_2);
        boolean hasAnswers4two = answers4_2.isChecked();
        //answer 4_3
        CheckBox answers4_3 = (CheckBox) findViewById(R.id.answer4_3);
        boolean hasAnswers4three = answers4_3.isChecked();
        //answer 4_4
        CheckBox answers4_4 = (CheckBox) findViewById(R.id.answer4_4);
        boolean hasAnswers4four = answers4_4.isChecked();

        //Question 5:answer
        RadioButton answer5Button = (RadioButton) findViewById(R.id.baryonyx);
        boolean clickAnswer5 = answer5Button.isChecked();

        int totalScore = calculateScore(clickAnswer1, clickAnswer3, clickAnswer5, hasAnswers4one, hasAnswers4two, hasAnswers4three, hasAnswers4four);

        String scoreMessage= "Total score: " + score + "/100";


    }

    //Calculate points for total score
    private int calculateScore (boolean clickAnswer1, boolean clickAnswer3,boolean hasAnswers4one, boolean hasAnswers4two, boolean hasAnswers4three, boolean hasAnswers4four, boolean clickAnswer5){

       //Add 15 points each when answers for question 1, 2, 3, 5 is clicked
        //question1 answer
        if (clickAnswer1){
            score = score + 15;
        }
        //question2 answer


        //question3 answer
        if (clickAnswer3){
            score = score + 15;
        }
        //question5 answer
        if (clickAnswer5){
            score = score + 15;
        }

        //Add 10 points each for question 4, when one of 4 answers are clicked
        //question4 answer1
        if (hasAnswers4one || hasAnswers4two || hasAnswers4three || hasAnswers4four){
            score = score + 15;
        }

        return score;

    }
    // here is a test comment

    //Score message according to scores.
    private String createScoreSummary (int score){
        System.out.println("Your total score:" + score);
        if (score >80){
            System.out.println ("\nYou did a great job!");
        }else {
            System.out.println ("\nStudy more about dinosaurs!");
        }
    }

    /**
     * This method displays the given quantity value on the screen. how?
     */




}
