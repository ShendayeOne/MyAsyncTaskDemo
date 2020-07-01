package com.shenyang.myapplication;

public class DelayOperator {

    /**
     * 延时操作,用来模拟下载
     * @param sleepTime 延时多久
     */
    public void delay(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

