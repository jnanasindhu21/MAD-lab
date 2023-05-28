package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStart, btnStop;
    TextView counterValue;

    public int count = 0;
    public boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button)findViewById(R.id.buttonStart);
        btnStart.setOnClickListener(this);
        btnStop = (Button) findViewById(R.id.buttonStop);
        btnStop.setOnClickListener(this);
        counterValue = (TextView)findViewById(R.id.textValue);

    }

    @Override
    public void onClick(View view) {
        if(view.equals(btnStart))
            counterStart();
        else if(view.equals(btnStop))
            counterStop();
    }

    private void counterStart() {
        count = 0;
        running = true;
        System.out.println("Start -> " + Thread.currentThread().getName());

        new MyCounter().start();
    }

    private void counterStop() {
        this.running = false;
    }

    Handler handler = new Handler(Looper.getMainLooper()) {

        public void handleMessage(Message msg) {
            counterValue.setText(String.valueOf(msg.what));
        }
    };


    private class MyCounter extends Thread{
        public void run(){
            System.out.println("MyCounter -> " + Thread.currentThread().getName());

            while(running)
            {
                count++;
                handler.sendEmptyMessage(count);
                try{
                    Thread.sleep(1000);
                }
                catch (Exception e)
                {}
            }
        }
    }
}
