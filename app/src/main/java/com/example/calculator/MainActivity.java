package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    ImageButton one;
    ImageButton two;
    ImageButton three;
    ImageButton four;
    ImageButton five;
    ImageButton six;
    ImageButton seven;
    ImageButton eight;
    ImageButton nine;
    ImageButton plus;
    ImageButton minus;
    ImageButton multiply;
    ImageButton divide;
    ImageButton percentage;
    ImageButton clear;
    ImageButton backspace;
    ImageButton dot;
    TextView textView1;
    ImageButton zero;
    ImageButton equals;
    TextView textView2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zero=findViewById(R.id.btn_zero);
        one=findViewById(R.id.btn_one);
        two=findViewById(R.id.btn_two);
        three=findViewById(R.id.btn_three);
        four=findViewById(R.id.btn_four);
        five=findViewById(R.id.btn_five);
        six=findViewById(R.id.btn_six);
        seven=findViewById(R.id.btn_seven);
        eight=findViewById(R.id.btn_eight);
        nine=findViewById(R.id.btn_nine);
        plus=findViewById(R.id.btn_plus);
        minus=findViewById(R.id.btn_minus);
        multiply=findViewById(R.id.btn_multiply);
        divide=findViewById(R.id.btn_divide);
        percentage=findViewById(R.id.btn_percentage);
        clear=findViewById(R.id.btn_singl);
        backspace=findViewById(R.id.btn_backspace);
        dot=findViewById(R.id.btn_dot);
        textView1=findViewById(R.id.textView1);
        equals=findViewById(R.id.btn_equal);
        textView2=findViewById(R.id.textView2);



        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= (textView1.getText().toString());
                textView1.setText(data+"0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= (textView1.getText().toString());
                textView1.setText(data+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= (textView1.getText().toString());
                textView1.setText(data+"2");

            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= (textView1.getText().toString());
                textView1.setText(data+"3");
            }
        });
       four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= (textView1.getText().toString());
                textView1.setText(data+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= (textView1.getText().toString());
                textView1.setText(data+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= (textView1.getText().toString());
                textView1.setText(data+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= (textView1.getText().toString());
                textView1.setText(data+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= (textView1.getText().toString());
                textView1.setText(data+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= textView1.getText().toString();
                textView1.setText(data+"9");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= textView1.getText().toString();
                textView1.setText(data+"+");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= textView1.getText().toString();
                textView1.setText(data+"-");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= textView1.getText().toString();
                textView1.setText(data+"X");
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= textView1.getText().toString();
                textView1.setText(data+"/");
            }
        });
        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= textView1.getText().toString();
                textView1.setText(data+"%");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= textView1.getText().toString();
                textView1.setText(data+".");
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               textView1.setText("");
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data= textView1.getText().toString();
                if(data.length()<=1)
                {
                    textView2.setText("0");
                }
                else if(data.length()>1);
                {
                    data= data.substring(0, data.length() - 1);
                    textView1.setText(data);
                }
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String process=textView1.getText().toString();
                process=process.replaceAll("X","*");
                process=process.replaceAll("%","/100");
                Context rhino= Context.enter(); // Context is used because javascript runs in this area only  so we use context as a current space where the code will run
                rhino.setOptimizationLevel(-1);// it sets the optimizable level of javascript code
                String finalResult="";
                Scriptable scriptable=rhino.initStandardObjects(); // it initializes the methods nad data types in javascript like evaluateString
                finalResult= rhino.evaluateString(scriptable,process,"Javsscript",1,null).toString();// nowthe method of javascript is initialised
                textView2.setText(finalResult);

            }
        });






    }
}