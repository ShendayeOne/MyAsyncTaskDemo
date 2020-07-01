package com.shenyang.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtTitle;
    private ProgressBar pgBar;
    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitle = (TextView)findViewById(R.id.txttitle);
        pgBar = (ProgressBar)findViewById(R.id.pgbar);
        btnUpdate = (Button)findViewById(R.id.btnupdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsyncTask myTask = new MyAsyncTask(txtTitle, pgBar);
                myTask.execute(1000);
            }
        });
    }
}