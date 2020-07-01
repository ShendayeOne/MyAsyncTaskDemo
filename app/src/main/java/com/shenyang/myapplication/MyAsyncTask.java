package com.shenyang.myapplication;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyAsyncTask extends AsyncTask<Integer, Integer, String> {
    private TextView txt;
    private ProgressBar pgBar;

    public MyAsyncTask(TextView txt, ProgressBar pgbar) {
        super();
        this.txt = txt;
        this.pgBar = pgbar;
    }


    //该方法不运行在UI线程中,主要用于异步操作,通过调用publishProgress()方法
    //触发onProgressUpdate对UI进行操作
    @Override
    protected String doInBackground(Integer... params) {
        DelayOperator dop = new DelayOperator();
        int i = 0;
        for (i = 2; i <= 100; i += 2) {
            dop.delay(200);
            publishProgress(i);
        }
        return i + params[0].intValue() + "";
    }

    //该方法运行在UI线程中,可对UI控件进行设置
    @Override
    protected void onPreExecute() {
        txt.setText("开始执行异步线程~~~");
    }


    //在doBackground方法中,每次调用publishProgress方法都会触发该方法
    //运行在UI线程中,可对UI控件进行操作
    @Override
    protected void onProgressUpdate(Integer... values) {
        int value = values[0];
        pgBar.setProgress(value);
    }
}
