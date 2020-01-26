package com.anil.meth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button act_1;
    Button act_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        act_1 = (Button) findViewById(R.id.Act2_1);
        act_2 = (Button) findViewById(R.id.Act2_2);

        act_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                openAct1();
            }
        });
        act_2.setOnClickListener(new View.OnClickListener(){
         @Override
         public void onClick(View v){
             openAct2();
         }
        });

    }
    public void openAct1(){
        Intent intent = new Intent(this,activity_1.class);
        startActivity(intent);
    }
    public void openAct2(){
        Intent intent = new Intent(this,activity_2.class);
        startActivity(intent);
    }
}
