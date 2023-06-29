package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView result, solution;
    MaterialButton allclr, clear, lparan, rparan;
    MaterialButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
    MaterialButton add, sub, mul, div, equal, dot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.solution);
        solution = findViewById(R.id.textScr);
        putid(lparan, R.id.leftParan);
        putid(rparan, R.id.rightParan);
        putid(allclr, R.id.allclear);
        putid(clear, R.id.clear);
        putid(b1, R.id.btn1);
        putid(b2, R.id.btn2);
        putid(b3, R.id.btn3);
        putid(b4, R.id.btn4);
        putid(b5, R.id.btn5);
        putid(b6, R.id.btn6);
        putid(b7, R.id.btn7);
        putid(b8, R.id.btn8);
        putid(b9, R.id.btn9);
        putid(b0, R.id.btn0);
        putid(add, R.id.add);
        putid(sub, R.id.subtract);
        putid(mul, R.id.multiply);
        putid(div, R.id.divide);
        putid(equal, R.id.equals);
        putid(dot, R.id.dot);

    }

    void putid(MaterialButton btn, int id)
    {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MaterialButton btn = (MaterialButton) v;
        String btntxt = btn.getText().toString();
        String calculations = solution.getText().toString();

        if(btntxt.equals("AC"))
        {
            solution.setText("0");
            result.setText("");
            return;
        }
        if(btntxt.equals("="))
        {
            solution.setText(result.getText());
            return;
        }

        if(btntxt.equals("C"))
        {
            calculations=calculations.substring(0,calculations.length()-1);
        }else {
            calculations = calculations+btntxt;
        }

        solution.setText(calculations);

        String printrst = printresult(calculations);

        if(!printrst.equals("Error"))
        {
            result.setText(printrst);
        }
    }

    String printresult(String data){
        try {
            Context con = Context.enter();
            con.setOptimizationLevel(-1);
            Scriptable scr = con.initSafeStandardObjects();
            String printrslt= con.evaluateString(scr,data,"Javascript",1,null).toString();
            if(printrslt.endsWith(".0")){
                printrslt = printrslt.replace(".0","");
            }
            return printrslt;
        }catch (Exception e)
        {
            return "Error";
        }
    }
}