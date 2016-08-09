package com.zhq.gank.mvp.video.presenter;

import com.zhq.gank.base.BasePresenterImpl;
import com.zhq.gank.callback.NetCallback;
import com.zhq.gank.callback.SubscriberCallback;
import com.zhq.gank.common.Api;
import com.zhq.gank.mvp.video.model.VideoModel;
import com.zhq.gank.mvp.video.view.VideoListView;
import com.zhq.gank.network.video.LolService;
import com.zhq.gank.network.video.VideoNetwork;

/**
 * 作者：hequnsky on 2016/8/3 18:27
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public class VideoListPresenterImpl extends BasePresenterImpl<VideoListView> {
    public LolService mLolService = VideoNetwork.getRetrofit(Api.LOL).create(LolService.class);

    public VideoListPresenterImpl(VideoListView mVideoListView) {
        attachView(mVideoListView);
    }

    public void loadData(int catid, int catwordid, int page, String t_, int p_) {
        View.showProgress();
        addSubscription(mLolService.getVideo(catid, catwordid, page, t_, p_), new SubscriberCallback<>(new NetCallback<VideoModel>() {


            @Override
            public void onSuccess(VideoModel model) {
                View.addData(model);
            }

            @Override
            public void onFailer(int code, String msg) {
                View.loadFailer(msg);
            }

            @Override
            public void onCompleted() {
                View.hideProgress();

            }
        }));

    }

}
