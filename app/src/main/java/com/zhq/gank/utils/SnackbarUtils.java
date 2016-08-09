package com.zhq.gank.utils;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.zhq.gank.app.GankApplication;

/**
 * 作者：hequnsky on 2016/8/3 11:12
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public class SnackbarUtils {

    private static Context context = GankApplication.context;

    public static void showSnack(View rootView, int textId) {
        if (null != rootView) {
            Snackbar.make(rootView, textId, Snackbar.LENGTH_SHORT).show();
        }
    }

    public static void showSnackLong(View rootView, int textId) {
        if (null != rootView) {
            Snackbar.make(rootView, textId, Snackbar.LENGTH_LONG).show();
        }
    }
}
