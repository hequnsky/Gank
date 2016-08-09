package com.zhq.gank.mvp.photo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.bm.library.PhotoView;
import com.zhq.gank.R;
import com.zhq.gank.base.BaseActivity;
import com.zhq.gank.common.Api;
import com.zhq.gank.mvp.photo.presenter.PhotoDetailPresenterImpl;
import com.zhq.gank.mvp.photo.view.PhotoDetailView;
import com.zhq.gank.utils.ImageUitls;
import com.zhq.gank.utils.ViewUtil;

import butterknife.Bind;

/**
 * 作者：hequnsky on 2016/8/6 11:20
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public class PhotoDatailActivity extends BaseActivity<PhotoDetailPresenterImpl> implements PhotoDetailView {

    @Bind(R.id.photo_img)
    PhotoView mPhotoView;
    String url;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtil.setFullScreen(this);
        Intent intent=getIntent();
        url=intent.getStringExtra("url");
        Presente.LoadImg(url);

    }

    @Override
    protected PhotoDetailPresenterImpl createPresenter() {
        return new PhotoDetailPresenterImpl(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_photo_detail;
    }

    @Override
    public void showImg(String url) {
        ImageUitls.loadLocal(PhotoDatailActivity.this, Api.IMAGER_URL+url,mPhotoView);
    }

    @Override
    public void Failer(String msg) {
        Toast.makeText(PhotoDatailActivity.this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}
