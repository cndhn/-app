package com.example.a16213.news;

public class MainPresenter {

    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public void getImage(String pram){
        new MainModel(new MainCallBack() {
            @Override
            public void onSuccess(String imgurl) {
                mainView.loadImage(imgurl);
            }

            @Override
            public void onFalied(Exception imgurl) {
                mainView.showToast(imgurl);
            }

            @Override
            public void onComplete() {
                mainView.loadComplete();
            }
        }).getImage(pram);
    }
}
