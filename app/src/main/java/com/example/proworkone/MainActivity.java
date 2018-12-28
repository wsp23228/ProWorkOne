package com.example.proworkone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.home.presenter.HomeListPresenter;
import com.example.home.view.IHomeListView;

public class MainActivity extends AppCompatActivity implements IHomeListView {

    private HomeListPresenter homeListPresenter;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_name);
        //初始化presenter
        homeListPresenter = new HomeListPresenter(this);
        homeListPresenter.getModelDate();
    }

    @Override
    public void getViewDate(String mViewDate) {
        textView.setText(mViewDate);
    }
}
