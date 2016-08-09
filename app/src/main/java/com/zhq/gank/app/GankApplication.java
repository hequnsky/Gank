package com.zhq.gank.app;

import android.app.Application;
import android.content.Context;

/**
 * 作者：hequnsky on 2016/8/3 11:14
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public class GankApplication extends Application {


    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

    }




}
