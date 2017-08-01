package com.example.touki.calculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String showStr="";
    private int state=0;
    private int oparator=0;
    private float result=0;
    private float x=0;
    private String history="";
    private int last;
    private int now;
    TextView myText;
    MyDBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText=(TextView) findViewById(R.id.myText);
        dbHandler =new MyDBHandler(this,null,null,1);
        getLast();
    }
    private void setLast()
    {
        SharedPreferences share=getSharedPreferences("Last", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = share.edit();
        int mem=share.getInt("last",0);
        mem=mem+1;
        editor.putInt("last",mem);
        editor.apply();
    }
    private void getLast()
    {
        SharedPreferences share=getSharedPreferences("Last", Context.MODE_PRIVATE);
        int mem=share.getInt("last",0);
        last=mem;
        now=last;
    }
    public void printDatabase()
    {
        String dbSting= dbHandler.databasetostring(now);
        myText.setText(dbSting);
        state=1;
    }
    public void addDatabase()
    {
        History histo = new History(history);
        dbHandler.addHistory(histo);
        setLast();
    }
    private void setInIt()
    {
        history="";
        showStr="";
        state=0;
        oparator=0;
        result=0;
        getLast();
        setStr();
    }
    private void changeState()
    {
        if(state==0)
        {
            state=1;
        }
        else
        {

            state=0;
        }
    }

    private void setStr()
    {
        if(showStr=="")
        {
            myText.setText("0");
        }
        else
        {
            myText.setText(showStr);
        }
    }
    private void convertFloat()
    {
        x= Float.parseFloat(showStr);
        showStr="";
    }

    private float calculate()
    {
        if(oparator==0)
        {
            result=result+x;
        }
        else if(oparator==1)
        {
            result=result-x;
        }
        else if(oparator==2)
        {
            result=result*x;
        }
        else if(oparator==3)
        {
            result=result/x;
        }
        else if(oparator==4)
        {
            result=(x/result)*100;
        }
        return result;
    }
    public void pressZero(View view)
    {
        if(state==0)
        {
            showStr=showStr+"0";
            setStr();
        }
        else
        {
            showStr="0";
            setStr();
            changeState();
        }
    }
    public void pressDecimal(View view)
    {
        if(state==0)
        {
            showStr=showStr+".";
            setStr();
        }
        else
        {
            showStr="0.";
            setStr();
            changeState();
        }
    }
    public void pressOne(View view)
    {
        if(state==0)
        {
            showStr=showStr+"1";
            setStr();
        }
        else
        {
            showStr="1";
            setStr();
            changeState();
        }
    }
    public void pressTwo(View view)
    {
        if(state==0)
        {
            showStr=showStr+"2";
            setStr();
        }
        else
        {
            showStr="2";
            setStr();
            changeState();
        }
    }

    public void pressThree(View view)
    {
        if(state==0)
        {
            showStr=showStr+"3";
            setStr();
        }
        else
        {
            showStr="3";
            setStr();
            changeState();
        }
    }
    public void pressFour(View view)
    {
        if(state==0)
        {
            showStr=showStr+"4";
            setStr();
        }
        else
        {
            showStr="4";
            setStr();
            changeState();
        }
    }

    public void pressFive(View view)
    {
        if(state==0)
        {
            showStr=showStr+"5";
            setStr();
        }
        else
        {
            showStr="5";
            setStr();
            changeState();
        }
    }

    public void pressSix(View view)
    {
        if(state==0)
        {
            showStr=showStr+"6";
            setStr();
        }
        else
        {
            showStr="6";
            setStr();
            changeState();
        }
    }
    public void pressSeven(View view)
    {
        if(state==0)
        {
            showStr=showStr+"7";
            setStr();
        }
        else
        {
            showStr="7";
            setStr();
            changeState();
        }
    }

    public void pressEight(View view)
    {
        if(state==0)
        {
            showStr=showStr+"8";
            setStr();
        }
        else
        {
            showStr="8";
            setStr();
            changeState();
        }
    }

    public void pressNine(View view)
    {
        if(state==0)
        {
            showStr=showStr+"9";
            setStr();
        }
        else
        {
            showStr="9";
            setStr();
            changeState();
        }
    }
    public void pressClear(View view)
    {
        setInIt();
    }
    public void pressPlus(View view)
    {
        convertFloat();
        calculate();
        history=history+showStr+"+";
        oparator=0;
        setStr();
    }
    public void pressMinus(View view)
    {
        convertFloat();
        calculate();
        history=history+showStr+"-";
        oparator=1;
        setStr();
    }
    public void pressMulti(View view)
    {
        convertFloat();
        calculate();
        history=history+showStr+"*";
        oparator=2;
        setStr();
    }
    public void pressDivision(View view)
    {
        convertFloat();
        calculate();
        history=history+showStr+"/";
        oparator=3;
        setStr();
    }
    public void pressPercent(View view)
    {
        convertFloat();
        calculate();
        history=history+showStr+"%";
        oparator=4;
        setStr();
    }
    public void pressEqual(View view)
    {
        convertFloat();
        calculate();
        history=history+showStr+"=";
        showStr=Float.toString(result);
        history=history+showStr;
        addDatabase();
        history="";
        oparator=0;
        result=0;
        state=1;
        setStr();
    }
    public void pressMPlus(View view)
    {
        SharedPreferences share=getSharedPreferences("memory", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = share.edit();
        float input= Float.parseFloat(myText.getText().toString());
        float mem=share.getFloat("memoryval",0);
        mem=mem+input;
        editor.putFloat("memoryval",mem);
        editor.apply();
        showStr=Float.toString(mem);
        setStr();
        changeState();
    }
    public void pressMMinus(View view)
    {
        SharedPreferences share=getSharedPreferences("memory", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = share.edit();
        float input= Float.parseFloat(myText.getText().toString());
        float mem=share.getFloat("memoryval",0);
        mem=mem-input;
        editor.putFloat("memoryval",mem);
        editor.apply();
        showStr=Float.toString(mem);
        setStr();
        changeState();
    }
    public void pressHMinus(View view)
    {
        if(now<last)
        {
            now=now+1;
            printDatabase();
        }
        else
        {
            now=last;
            printDatabase();
        }
    }
    public void pressHPlus(View view).
    {
        if(now<last)
        {
            now=now-1;
            printDatabase();
        }
        else
        {
            now=last;
            printDatabase();
        }
    }
}
