package com.anil.meth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class activity_2 extends AppCompatActivity {

    TextView title,num1,num2,score;
    int num_1,num_2,score_int = 0,ans_int;
    EditText answer;
    Button submit,start;

    boolean game_start = false;
    Random r = new Random();
    public int randomGen(int max){
        return r.nextInt(max-1)+1;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        title = (TextView) findViewById(R.id.Act2_1_title);
        num1 = (TextView) findViewById(R.id.num1);
        num2 = (TextView) findViewById(R.id.num2);
        answer = (EditText) findViewById(R.id.answer);
        submit = (Button) findViewById(R.id.submit);
        start = (Button) findViewById(R.id.skip);
        score = (TextView) findViewById(R.id.score);
        answer.setText("");
        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(!game_start){
                    game_start = true;
                    title.setText("MethLab");
                    start.setText("Skip");
                    setNum();
                }else{
                    updateScore(true);
                    setNum();
                }
            }
        });
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                System.out.println(answer.getText().toString());
                if(!game_start){
                    title.setText("Start Game");
                }else{
                    num_1 = Integer.parseInt(num1.getText().toString());
                    num_2 = Integer.parseInt(num2.getText().toString());
                    ans_int = Integer.parseInt(answer.getText().toString());
                    if((num_1 * num_2) == ans_int){
                        title.setText("Bingo");
                        updateScore(false);
                        setNum();
                        answer.setText("");
                    }else{
                        title.setText("Nopes");
                        updateScore(true);
                        answer.setText("");


                    }


                }
            }
        });

    }
    public void setNum(){
        num_1 = randomGen(99);
        num_2 = randomGen(99);
        num1.setText("" + num_1);
        num2.setText("" + num_2);
    }
    public void updateScore(boolean b){
        score_int = Integer.parseInt(score.getText().toString());


        if(b)
            score_int -= 1;
        else
            score_int += 2;
        score.setText(""+score_int);
    }
}
