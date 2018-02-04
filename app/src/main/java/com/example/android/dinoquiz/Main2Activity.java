package com.example.android.dinoquiz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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

        // get the answer text (the string inside the text field)
        EditText answerText = (EditText) findViewById(R.id.answer_field);
        String answer = answerText.getText().toString().trim();
        // decide if answer is true or false
        boolean clickAnswer2 = false;
        if(answer.equals("Argentinosaurus")){
            clickAnswer2 = true;
        }

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

        int totalScore = calculateScore(clickAnswer1, clickAnswer2, clickAnswer3, clickAnswer5, hasAnswers4one, hasAnswers4two, hasAnswers4three, hasAnswers4four);

        updateAnswerColors(clickAnswer1, clickAnswer2, clickAnswer3, clickAnswer5, hasAnswers4one, hasAnswers4two, hasAnswers4three, hasAnswers4four);
        String message = createScoreSummary(score);
        displayResult(message);
        showAnswers();



    }
    private void updateAnswerColors (boolean clickAnswer1, boolean clickAnswer2, boolean clickAnswer3, boolean clickAnswer5, boolean hasAnswers4one, boolean hasAnswers4two, boolean hasAnswers4three, boolean hasAnswers4four) {
        if (clickAnswer1){
            setFieldColor(Color.GREEN, R.id.showAnswer1);
        } else {
            setFieldColor(Color.RED, R.id.showAnswer1);
        }
        if (clickAnswer2){
            setFieldColor(Color.GREEN, R.id.showAnswer2);
        } else {
            setFieldColor(Color.RED, R.id.showAnswer2);
        }
        if (clickAnswer3){
            setFieldColor(Color.GREEN, R.id.showAnswer3);
        } else {
            setFieldColor(Color.RED, R.id.showAnswer3);
        }
        if (hasAnswers4one && hasAnswers4two && hasAnswers4three && hasAnswers4four){
            setFieldColor(Color.GREEN, R.id.showAnswer4);
        } else {
            setFieldColor(Color.RED, R.id.showAnswer4);
        }
        if (clickAnswer5){
            setFieldColor(Color.GREEN, R.id.showAnswer5);
        } else {
            setFieldColor(Color.RED, R.id.showAnswer5);
        }

    }
    //Calculate points for total score
    private int calculateScore (boolean clickAnswer1, boolean clickAnswer2, boolean clickAnswer3,boolean hasAnswers4one, boolean hasAnswers4two, boolean hasAnswers4three, boolean hasAnswers4four, boolean clickAnswer5){

        //Add 15 points each when answers for question 1, 2, 3, 5 is clicked
        //question1 answer
        if (clickAnswer1){
            score = score + 15;
        }
        //question2 answer
        if (clickAnswer2){
            score = score + 15;
        }

        //question3 answer
        if (clickAnswer3){
            score = score + 15;
        }
        //question5 answer
        if (clickAnswer5){
            score = score + 15;
        }

        //Add 10 points each for question 4, when one of 4 answers are clicked
        //question4 answers
        if (hasAnswers4one){
            score = score + 10;
        }
        if (hasAnswers4two){
            score = score + 10;
        }
        if (hasAnswers4three){
            score = score + 10;
        }
        if (hasAnswers4four){
            score = score + 10;
        }
        return score;

    }

    //Score message according to scores.
    private String createScoreSummary (int score){
        String scoreMessage = "you have total: " + score;

        if (score >80){
            scoreMessage = scoreMessage + "\n" + "You did a great job!";
        }else {
            scoreMessage = scoreMessage + "\n" + "Study more about dinosaurs!";
        }

        return scoreMessage;

    }

    private void displayResult(String message){
        TextView textResult = (TextView) findViewById(R.id.resultMsg);
        textResult.setText(message);
    }


    /**
     * This method changes visibility of textfields
     */
    private void setFieldVisibility(int visibility, int idField){
        TextView textField = (TextView) findViewById(idField);
        textField.setVisibility(visibility);
    }
    private void setFieldColor(int color, int idField){
        TextView textField = (TextView) findViewById(idField);
        textField.setTextColor(color);
    }

    private void showAnswers(){
        setFieldVisibility(View.VISIBLE, R.id.showAnswer1);
        setFieldVisibility(View.VISIBLE, R.id.showAnswer2);
        setFieldVisibility(View.VISIBLE, R.id.showAnswer3);
        setFieldVisibility(View.VISIBLE, R.id.showAnswer4);
        setFieldVisibility(View.VISIBLE, R.id.showAnswer5);
    }

}
