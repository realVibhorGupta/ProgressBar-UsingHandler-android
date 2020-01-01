package com.example.vibhor.progressbarusinghandler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Thread thread;
    Handler handler;
    ProgressBar mProgressBar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mProgressBar= (ProgressBar) findViewById(R.id.progressBar);



        thread =new Thread(new MyThread());
        thread.start();

        handler =new Handler(){

            @Override
            public void handleMessage(Message msg) {
                mProgressBar.setProgress(msg.arg1);
            }
        };

    }


    class MyThread implements Runnable{

        /**
         * Starts executing the active part of the class' code. This method is
         * called when a thread is started that has been created with a class which
         * implements {@code Runnable}.
         */
        @Override
        public void run() {

            for (int i = 0;i<100;i++)
            {
                Message message = Message.obtain();
                message.arg1 = i;
                handler.sendMessage(message);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
