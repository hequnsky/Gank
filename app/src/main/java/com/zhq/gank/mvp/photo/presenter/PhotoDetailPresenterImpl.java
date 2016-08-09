package com.zhq.gank.mvp.photo.presenter;

import com.zhq.gank.base.BasePresenterImpl;
import com.zhq.gank.mvp.photo.view.PhotoDetailView;

/**
 * 作者：hequnsky on 2016/8/6 11:40
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public class PhotoDetailPresenterImpl extends BasePresenterImpl<PhotoDetailView> {


    public PhotoDetailPresenterImpl(PhotoDetailView mPhotoDetailView) {
        attachView(mPhotoDetailView);
    }

    public void LoadImg(String url) {
        View.showImg(url);

    }

    public void Failer(String msg, Exception e) {
        View.Failer(msg);
    }
}
