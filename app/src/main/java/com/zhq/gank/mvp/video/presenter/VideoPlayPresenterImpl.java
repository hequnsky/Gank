package com.zhq.gank.mvp.video.presenter;

import com.zhq.gank.base.BasePresenterImpl;
import com.zhq.gank.mvp.video.view.VideoPlayView;

/**
 * 作者：hequnsky on 2016/8/4 11:00
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public class VideoPlayPresenterImpl extends BasePresenterImpl<VideoPlayView> {

    public VideoPlayPresenterImpl(VideoPlayView mVideoPlayView) {
        attachView(mVideoPlayView);
    }

    public void PlayVideo(String playUrl) {
        View.showProgress();
        View.playVideo(playUrl);
    }

    public void getVideoSuccess() {
        View.hideProgress();
    }


    public void getVideoFailer(String msg) {
        View.hideProgress();
        View.loadFailer(msg);
    }
}
