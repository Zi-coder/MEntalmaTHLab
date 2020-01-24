package com.anil.meth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int result,n1 ,n2;
    TextView num1,num2,title;
    Button next,submit,act2;
    EditText ans;

    Random r = new Random();
    public int randomGen(){
        return r.nextInt(99-1)+1;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next = (Button) findViewById(R.id.state);
        num1 = (TextView) findViewById(R.id.num1);
        num2 = (TextView) findViewById(R.id.num2);
        title = (TextView) findViewById(R.id.title);
        ans = (EditText) findViewById(R.id.ans);
        submit = (Button) findViewById(R.id.submit);


        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                num1.setText("" + randomGen());
                num2.setText("" + randomGen());
            }
        });
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                result = Integer.parseInt(ans.getText().toString());
                n1 = Integer.parseInt(num1.getText().toString());
                n2 = Integer.parseInt(num2.getText().toString());

                if( result == (n1 * n2)){
                    title.setText("Bingo..");
                    ans.setText("");
                    next.callOnClick();
                }
                else{
                    title.setText("Noppes");
                    ans.setText("");
                }

            }
        });

    }
}
