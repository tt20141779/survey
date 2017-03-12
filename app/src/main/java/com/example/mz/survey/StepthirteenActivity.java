package com.example.mz.survey;

import android.content.Intent;
import android.media.MediaCodec;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepthirteenActivity extends AppCompatActivity {

    private Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepthirteen);
        but=(Button) findViewById(R.id.button14);
        final EditText editText=(EditText) findViewById(R.id.editText);
        but.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=editText.getText().toString();
                 if(isEmail(text)==true)
                 {
                     Intent intent=new Intent(StepthirteenActivity.this,StepfourteenActivity.class);
                     startActivity(intent);
                 }
                 else {
                     Toast.makeText(getBaseContext(),"You need to provide a correct email address!",Toast.LENGTH_SHORT).show();
                 }
            }
        });
    }
    public static boolean isEmail(String email){
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    }

