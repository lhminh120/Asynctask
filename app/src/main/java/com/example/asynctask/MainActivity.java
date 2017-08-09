package com.example.asynctask;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    Button btnStart;
    //khai báo MyAsyncTask
    MyAsyncTask mytt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart=(Button) findViewById(R.id.button1);
        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                doStart();
            }
        });

    }
    private void doStart()
    {
        //truyền this (chính là MainActivity hiện tại) qua Child Thread
        mytt =new MyAsyncTask(this);
        //Kích hoạt Tiến trình
        //khi gọi hàm này thì onPreExecute của mytt sẽ thực thi trước
        mytt.execute();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}
