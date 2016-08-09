package com.zhq.gank.mvp.video.view;

/**
 * 作者：hequnsky on 2016/8/4 11:00
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public interface VideoPlayView {
    void playVideo(String path);
    void showProgress();
    void hideProgress();
    void loadFailer(String msg);
}
