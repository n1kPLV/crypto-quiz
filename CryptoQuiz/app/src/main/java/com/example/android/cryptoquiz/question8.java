package com.example.android.cryptoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class question8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slidein, R.anim.slideout);
        setContentView(R.layout.activity_question8);
        Boolean practiseMode = getIntent().getBooleanExtra("practise", false);
        if (practiseMode) {
            EditText answer = findViewById(R.id.answerInput);
            answer.setText("Blockchain");
            answer.setEnabled(false);
            answer.setFocusable(false);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            answer.setTextColor(getResources().getColor(R.color.correctAnswer));
            Button nextButton = findViewById(R.id.nextButton);
            nextButton.setText(R.string.back);
        }
    }

    public void nextQuestion(View v){
        Boolean practiseMode = getIntent().getBooleanExtra("practise", false);
        if (!practiseMode){
            Intent intent = new Intent(getApplicationContext(), question9.class);
            int score = scoreCalc();
            intent.putExtra("score", score);
            startActivity(intent);}
        else {
            Intent intent = new Intent(getApplicationContext(), PractiseActivity.class);
            startActivity(intent);
        }
    }

    public int scoreCalc(){
        int score = getIntent().getIntExtra("score", 0);
        EditText answer = findViewById(R.id.answerInput);
        String answerString = answer.getText().toString().toLowerCase();
        if (answerString.contains("blockchain")) {
            score = score + 2;
        }
        else if(answerString.contains("block chain")){
            score = score + 2;
        }
        return score;
    }

}