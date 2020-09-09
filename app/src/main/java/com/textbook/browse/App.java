package com.textbook.browse;

/**
 * Created by jishuaipeng on 2017/8/2.
 */

import android.app.Application;
import android.content.Context;

import com.textbook.browse.util.ExceptionHandler;

/**
 * Created by jishuaipeng
 * on 2016/12/22.
 */
public class App extends Application {
    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        ExceptionHandler.getInstance().initConfig(this);
    }

    public static Context getAppContext() {
        return appContext;
    }


}
