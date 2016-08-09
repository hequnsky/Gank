package com.zhq.gank.mvp.photo.presenter;

import com.zhq.gank.base.BasePresenterImpl;
import com.zhq.gank.callback.NetCallback;
import com.zhq.gank.callback.SubscriberCallback;
import com.zhq.gank.common.Api;
import com.zhq.gank.mvp.photo.model.PhotoModel;
import com.zhq.gank.mvp.photo.view.PhotoListView;
import com.zhq.gank.network.photo.TngouNetwork;
import com.zhq.gank.network.photo.TngouService;

/**
 * 作者：hequnsky on 2016/8/4 16:14
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public class PhotoListPresenterImpl extends BasePresenterImpl<PhotoListView> {

    public TngouService mTngouService = TngouNetwork.getRetrofit(Api.TNGOU).create(TngouService.class);

    public PhotoListPresenterImpl(PhotoListView mPhotoListView) {
        attachView(mPhotoListView);

    }

    /**
     * 默认加载第一页的数据
     */
    public void loadData(int id, int page, int rows) {
        View.showProgress();
        addSubscription(mTngouService.getPhotoList(id, page, rows), new SubscriberCallback<>(new NetCallback<PhotoModel>() {
            @Override
            public void onSuccess(PhotoModel model) {
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


//    public void loadData(int page) {
//        View.showProgress();
//        addSubscription(mTngouService.getPhotoList( page), new SubscriberCallback<>(new NetCallback<PhotoModel>() {
//            @Override
//            public void onSuccess(PhotoModel model) {
//                View.addData(model);
//            }
//
//            @Override
//            public void onFailer(int code, String msg) {
//                View.loadFailer(msg);
//            }
//
//            @Override
//            public void onCompleted() {
//                View.hideProgress();
//            }
//        }));
//
//    }
}
