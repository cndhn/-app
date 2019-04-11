package com.example.a16213.news;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mainPresenter;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mainPresenter = new MainPresenter(this);
        mainPresenter.getImage("https://b-ssl.duitang.com/uploads/item/201509/10/20150910104715_cLTnU.jpeg");

    }

    @Override
    public void loadImage(String imageUrl) {
        Toast.makeText(this, imageUrl, Toast.LENGTH_SHORT).show();
        Glide.with(this).load(imageUrl).into(img);
    }

    @Override
    public void showToast(Exception e) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loadComplete() {
        Toast.makeText(this, "加载完成", Toast.LENGTH_SHORT).show();

    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
    }
}
