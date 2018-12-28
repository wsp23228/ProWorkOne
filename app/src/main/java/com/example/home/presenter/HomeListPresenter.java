package com.example.home.presenter;

import com.example.api.Api;
import com.example.home.model.HomeListModeInter;
import com.example.home.model.IHomeListModeInter;
import com.example.proworkone.MainActivity;

public class HomeListPresenter implements IHomeListPresenter,HomeListModeInter.ModelInterface {

    private final HomeListModeInter homeListModeInter;
    private MainActivity mainActivity;

    public HomeListPresenter(MainActivity mainActivity) {
        //初始化view
        this.mainActivity = mainActivity;
        //初始化model
        homeListModeInter = new HomeListModeInter(this);
    }

    @Override
    public void LoadSuccess(String data) {
        //model传过来的String值
        mainActivity.getViewDate(data);
    }

    @Override
    public void LoadFailed() {

        mainActivity.getViewDate("加载失败");
    }

    @Override
    public void getModelDate() {
        //回调model
        homeListModeInter.getDate(Api.SHOPLIST);
    }
}
