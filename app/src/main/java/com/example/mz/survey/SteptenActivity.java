package com.example.mz.survey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SteptenActivity extends AppCompatActivity {

    private RadioGroup rg;
    private Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepten);

        rg=(RadioGroup) findViewById(R.id.radioGroup10);
        but=(Button)  findViewById(R.id.button11);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<rg.getChildCount();i++){
                    RadioButton radioButton=(RadioButton)rg.getChildAt(i);
                    if(radioButton.isChecked()){
                        WriteFiles(radioButton.getText().toString());
                    }
                    Intent intent=new Intent(SteptenActivity.this,StepelevenActivity.class);
                    startActivity(intent);
                }

            }
        });
    }


    public void WriteFiles(String content) {
        try {
            FileOutputStream fos=openFileOutput("a.txt",MODE_PRIVATE);
            fos.write(content.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }

