package com.example.home.model;

import android.util.Log;

import com.example.network.MyTask;

public class HomeListModeInter implements IHomeListModeInter{
    //声明接口变量
    ModelInterface modelInterface;
    public HomeListModeInter(ModelInterface modelInterface){
        this.modelInterface = modelInterface;
    }
    @Override
    public void getDate(final String url) {
        new Runnable(){
            @Override
            public void run() {
                new MyTask<String>(url,"GET").setTaskListener(new MyTask.TaskListeners() {
                    @Override
                    public void result(String t) {
                        Log.i("", "result:=== "+t);
                        if(t!=null){
                            //实现接口方法
                            modelInterface.LoadSuccess(t);
                        }else {
                            modelInterface.LoadFailed();
                        }
                    }
                }).execute();
            }
        }.run();
    }

    //定义接口
    public interface ModelInterface{
        void LoadSuccess(String data);
        void LoadFailed();
    }
}
