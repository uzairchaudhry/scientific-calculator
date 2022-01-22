package com.example.calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private String defaultVal;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display=findViewById(R.id.textView);
        display.setShowSoftInputOnFocus(false);
        defaultVal="0";

        display.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if("0".equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    private void updateString(String add) {
        if("0".equals(display.getText().toString())){
            display.setText("");
        }
        String prevStr=display.getText().toString();
        int cursor=display.getSelectionStart();
        String left=prevStr.substring(0,cursor);
        String right=prevStr.substring(cursor);
        display.setText(String.format("%s%s%s",left,add,right));
        if(add.equals("e^"))
            display.setSelection(cursor+2);
        else if(add.equals("ln("))
            display.setSelection(cursor+3);
        else if(add.equals("cos(") || add.equals("sin(") || add.equals("tan(") )
            display.setSelection(cursor+4);
        else if(add.equals("^1/"))
            display.setSelection(cursor+3);
        else if(add.equals("acos(") || add.equals("asin(") || add.equals("atan("))
            display.setSelection(cursor+5);
        else if(add.equals("log10(")  )
            display.setSelection(cursor+6);
        else
            display.setSelection(cursor+1);
    }

    public void clearBt(View view) {
        display.setText("");
    }

    public void oneClearBt(View view) {
        int cursePostion=display.getSelectionStart();
        int lenTetxt=display.getText().length();
        if(cursePostion!=0&& lenTetxt!=0)
        {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursePostion-1,cursePostion,"");
            display.setText(selection);
            display.setSelection(cursePostion-1);
        }

    }

    public void zeroBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("0");
    }

    public void oneBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("1");
    }

    public void twoBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("2");
    }

    public void threeBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("3");
    }

    public void fourBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("4");
    }

    public void fiveBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("5");
    }

    public void sixBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("6");
    }

    public void sevenBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("7");
    }

    public void eightBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("8");
    }

    public void nineBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("9");
    }

    public void dotBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString(".");
    }

    public void percentageBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("%");
    }

    public void xpoweryBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("^");
    }

    public void subBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("-");
    }

    public void plusBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("+");
    }

    public void divideBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("÷");
    }

    public void multiplyBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("×");
    }

    public void equalBt(View view) {
        try {
            String result="";
            String exp = display.getText().toString();
            exp = exp.replaceAll("÷", "/");
            exp = exp.replaceAll("×", "*");
            exp = exp.replaceAll("π", "3.14");
            Expression expression = new Expression(exp);
            result = String.valueOf(expression.calculate());
            display.setText(result);
            display.setSelection(result.length());
        }catch (Exception ex){
            display.setText("NaN");
        }
    }

    public void secondBt(View view) {
    }

    public void pranBT(View view) {
        int cursor=display.getSelectionStart();
        int open=0;
        int closed=0;
        int len=display.getText().length();
        for(int i=0;i<cursor;i++){
            if(display.getText().toString().substring(i,i+1).equals("(")){
                open+=1;
            }
            if(display.getText().toString().substring(i,i+1).equals(")")) {
                closed += 1;
            }
        }
        if(open==closed || display.getText().toString().substring(len-1,len).equals("(")){
            updateString("(");
        }
        else if(closed<closed || !display.getText().toString().substring(len-1,len).equals("(")){
            updateString(")");
        }
        display.setSelection(cursor+1);
    }

    public void cubeBt(View view) {
        try {
            String exp = display.getText().toString();
            exp = exp.replaceAll("÷", "/");
            exp = exp.replaceAll("×", "*");
            exp = exp.replaceAll("π", "3.14");
            Expression expression = new Expression(exp);
            String result = String.valueOf(expression.calculate());
            double d = Double.parseDouble(result);
            double cube = d * d * d;
            String s = String.valueOf(cube);
            display.setText(s);
            display.setSelection(s.length());
        }catch(Exception ex){
            display.setText("NaN");
        }
    }

    public void tanIBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("atan(");
    }

    public void tanBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("tan(");
    }

    public void logBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("ln(");
    }

    public void xrotyBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("^1/");
    }

    public void sinIBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("asin(");
    }

    public void sinBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("sin(");
    }

    public void nFacBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("!");
    }

    public void cosIBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("acos(");
    }

    public void cosBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("cos(");
    }

    public void eexpoxBt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("e^");
    }

    public void squareRootBt(View view) {
        try {
            String exp = display.getText().toString();
            exp = exp.replaceAll("÷", "/");
            exp = exp.replaceAll("×", "*");
            exp = exp.replaceAll("π", "3.14");
            Expression expression = new Expression(exp);
            String result = String.valueOf(expression.calculate());
            double r = Math.sqrt(Double.parseDouble(result));
            String s = String.valueOf(r);
            display.setText(s);
            display.setSelection(s.length());
        }catch(Exception ex){
            display.setText("NaN");
        }
    }

    public void PiBt(View view) {
        try {
            if ((display.getText().toString()).equals("NaN")) {
                display.setText("");
            }
            if("".equals(display.getText().toString())){
                display.setText("3.14159");
            }
            else {
                if (display.getText().toString().substring(display.getText().length() - 1).equals("×") || display.getText().toString().substring(display.getText().length() - 1).equals("+") || display.getText().toString().substring(display.getText().length() - 1).equals("-") || display.getText().toString().substring(display.getText().length() - 1).equals("÷"))
                    updateString("π");
                else
                    display.setText("3.14159");
            }
        }catch(Exception ex){
            display.setText("Error");
        }
    }

    public void squareBt(View view) {
        try {
            String exp = display.getText().toString();
            exp = exp.replaceAll("÷", "/");
            exp = exp.replaceAll("×", "*");
            exp = exp.replaceAll("π", "3.14");
            Expression expression = new Expression(exp);
            String result = String.valueOf(expression.calculate());
            double d = Double.parseDouble(result);
            double square = d * d;
            String s = String.valueOf(square);
            display.setText(s);
            display.setSelection(s.length());
        }catch(Exception ex){
            display.setText("NaN");
        }
    }

    public void round0Bt(View view) {
        try {
            String exp = display.getText().toString();
            exp = exp.replaceAll("÷", "/");
            exp = exp.replaceAll("×", "*");
            exp = exp.replaceAll("π", "3.14");
            Expression expression = new Expression(exp);
            String result = String.valueOf(expression.calculate());

            int r = (int) Math.round(Double.parseDouble(result));
            String s = String.valueOf(r);
            display.setText(s);
            display.setSelection(s.length());
        }catch (Exception ex){
            display.setText("NaN");
        }
    }

    public void round2Bt(View view) {
        try {
            String exp = display.getText().toString();
            exp = exp.replaceAll("÷", "/");
            exp = exp.replaceAll("×", "*");
            exp = exp.replaceAll("π", "3.14");
            Expression expression = new Expression(exp);
            String result = String.valueOf(expression.calculate());
            double r = (Math.round(Double.parseDouble(result) * 100.0) / 100.0);
            String s = String.valueOf(r);
            display.setText(s);
            display.setSelection(s.length());
        }catch (Exception ex){
            display.setText("NaN");
        }
    }

    public void log10Bt(View view) {
        if((display.getText().toString()).equals("NaN") || (display.getText().toString()).equals("3.14159")){
            display.setText("");
        }
        updateString("log10(");
    }
}