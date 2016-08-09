package com.zhq.gank.utils;

import android.content.Intent;
import android.content.pm.PackageManager;

import com.zhq.gank.app.GankApplication;

import java.util.List;

/**
 * 作者：hequnsky on 2016/8/5 16:52
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public class IntentUtil {


    public static boolean isIntentSafe(Intent intent) {
        PackageManager packageManager = GankApplication.context.getPackageManager();
        List activities = packageManager.queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        return activities.size() > 0;
    }
}
