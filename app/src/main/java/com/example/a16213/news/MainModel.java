package com.example.a16213.news;

import android.os.Handler;
import android.os.Message;

import java.util.concurrent.Executors;

public class MainModel {

    private MainCallBack callBack;

    public MainModel(MainCallBack callBack) {
        this.callBack = callBack;
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    callBack.onSuccess((String) msg.obj);
                    callBack.onComplete();
                    break;
                case 2:
                    callBack.onFalied((Exception) msg.obj);
                    callBack.onComplete();
                    break;
            }
        }
    };

    public void getImage(final String url){
        Executors.newCachedThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    if (callBack!=null){
                        Message message = Message.obtain();
                        message.what =1;
                        message.obj = url;
                        handler.sendMessage(message);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    if (callBack!=null){
                        Message message = Message.obtain();
                        message.what =2;
                        message.obj = url;
                        handler.sendMessage(message);
                    }
                }

            }
        });
    }

}
