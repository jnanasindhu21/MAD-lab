package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnzero, btnone, btntwo, btnthree, btnfour, btnfive, btnsix, btnseven, btneight, btnnine;
    Button btnclr, btndot, btnequals;
    Button btnadd, btnsub, btnmul, btndiv;
    EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnzero = (Button) findViewById(R.id.buttonzero);
        btnzero.setOnClickListener(this);
        btnone = (Button) findViewById(R.id.buttonone);
        btnone.setOnClickListener(this);
        btntwo = (Button) findViewById(R.id.buttontwo);
        btntwo.setOnClickListener(this);
        btnthree = (Button) findViewById(R.id.buttonthree);
        btnthree.setOnClickListener(this);
        btnfour = (Button) findViewById(R.id.buttonfour);
        btnfour.setOnClickListener(this);
        btnfive = (Button) findViewById(R.id.buttonfive);
        btnfive.setOnClickListener(this);
        btnsix = (Button) findViewById(R.id.buttonsix);
        btnsix.setOnClickListener(this);
        btnseven = (Button) findViewById(R.id.buttonseven);
        btnseven.setOnClickListener(this);
        btneight = (Button) findViewById(R.id.buttoneight);
        btneight.setOnClickListener(this);
        btnnine = (Button) findViewById(R.id.buttonnine);
        btnnine.setOnClickListener(this);
        btndot = (Button) findViewById(R.id.buttondot);
        btndot.setOnClickListener(this);
        btnadd = (Button) findViewById(R.id.buttonplus);
        btnadd.setOnClickListener(this);
        btnsub = (Button) findViewById(R.id.buttonsub);
        btnsub.setOnClickListener(this);
        btnmul = (Button) findViewById(R.id.buttonmul);
        btnmul.setOnClickListener(this);
        btndiv = (Button) findViewById(R.id.buttondiv);
        btndiv.setOnClickListener(this);
        btnequals = (Button) findViewById(R.id.buttonequals);
        btnequals.setOnClickListener(this);

        result = (EditText) findViewById(R.id.textValue);
        result.setText("");

    }

    @Override
    public void onClick(View view) {

        if(view.equals(btnzero))
            result.append("0");
        if(view.equals(btnone))
            result.append("1");
        if(view.equals(btntwo))
            result.append("2");
        if(view.equals(btnthree))
            result.append("3");
        if(view.equals(btnfour))
            result.append("4");
        if(view.equals(btnfive))
            result.append("5");
        if(view.equals(btnsix))
            result.append("6");
        if(view.equals(btnseven))
            result.append("7");
        if(view.equals(btneight))
            result.append("8");
        if(view.equals(btnnine))
            result.append("9");
        if(view.equals(btndot))
            result.append(".");
        if(view.equals(btnadd))
            result.append("+");
        if(view.equals(btnsub))
            result.append("-");
        if(view.equals(btnmul))
            result.append("*");
        if(view.equals(btndiv))
            result.append("/");
        if(view.equals(btnclr))
            result.setText("");
        if(view.equals(btnequals))
        {
            try
            {

                String data = result.getText().toString();
                if(data.contains("+"))
                    addition(data);
                else if(data.contains("-"))
                    subtract(data);
                else if(data.contains("*"))
                    multiply(data);
                else if(data.contains("/"))
                    division(data);
            }
            catch (Exception e)
            {
                displayInvalid("Invalid input");
            }
        }
    }

    private void displayInvalid(String mes) {
        Toast.makeText(getBaseContext(), mes, Toast.LENGTH_LONG).show();
    }

    private void division(String data) {
        String[] operands = data.split("/");
        if(operands.length == 2)
        {
            double op1 = Double.parseDouble(operands[0]);
            double op2 = Double.parseDouble(operands[1]);
            double res = op1 / op2;
            result.setText((String.valueOf(res)));
        }
        else
            displayInvalid("Invalid input");
    }

    private void multiply(String data) {
        String[] operands = data.split("*");
        if(operands.length == 2)
        {
            double op1 = Double.parseDouble(operands[0]);
            double op2 = Double.parseDouble(operands[1]);
            double res = op1 * op2;
            result.setText((String.valueOf(res)));
        }
        else
            displayInvalid("Invalid input");
    }

    private void subtract(String data) {
        String[] operands = data.split("-");
        if(operands.length == 2)
        {
            double op1 = Double.parseDouble(operands[0]);
            double op2 = Double.parseDouble(operands[1]);
            double res = op1 - op2;
            result.setText((String.valueOf(res)));
        }
        else
            displayInvalid("Invalid input");
    }

    private void addition(String data) {
        String[] operands = data.split("+");
        if(operands.length == 2)
        {
            double op1 = Double.parseDouble(operands[0]);
            double op2 = Double.parseDouble(operands[1]);
            double res = op1 + op2;
            result.setText((String.valueOf(res)));
        }
        else
            displayInvalid("Invalid input");
    }
}
