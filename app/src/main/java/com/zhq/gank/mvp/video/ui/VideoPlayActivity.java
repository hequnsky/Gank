package com.zhq.gank.mvp.video.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.zhq.gank.R;
import com.zhq.gank.base.BaseActivity;
import com.zhq.gank.mvp.video.presenter.VideoPlayPresenterImpl;
import com.zhq.gank.mvp.video.view.VideoPlayView;
import com.zhq.gank.utils.ViewUtil;
import com.zhq.gank.widget.VideoPlayController;

import butterknife.Bind;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;

public class VideoPlayActivity extends BaseActivity<VideoPlayPresenterImpl> implements VideoPlayView, View.OnTouchListener {
    @Bind(R.id.video_view)
    VideoView mVideoView;
    @Bind(R.id.video_progress)
    ProgressBar mProgressBar;
    @Bind(R.id.rl_bg)
    View mBgView;
    private VideoPlayController mPlayController;

    private float mDownX;
    private float mDownY;
    String url, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        ViewUtil.setFullScreen(this);
        mBgView.setOnTouchListener(this);
        Intent i = getIntent();
        url = i.getStringExtra("Url");
        title = i.getStringExtra("Title");
        Presente.PlayVideo(url);
    }

    @Override
    protected VideoPlayPresenterImpl createPresenter() {
        return new VideoPlayPresenterImpl(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_play;
    }

    @Override
    public void playVideo(String path) {
        if (Vitamio.isInitialized(getApplicationContext())) {

            mVideoView.setVideoPath(path);

            mPlayController = new VideoPlayController(this, mVideoView, mBgView,title);

            mVideoView.requestFocus();
            mVideoView.setOnTouchListener(this);

            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.setPlaybackSpeed(1.0f);
                    Presente.getVideoSuccess();

                }
            });
            mVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    hideProgress();

                    Presente.getVideoFailer("视频播放出错了╮(╯Д╰)╭");
                    return true;
                }
            });
        } else {
            Presente.getVideoFailer("播放器还没初始化完哎，等等咯╮(╯Д╰)╭ ");
        }
    }


    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void loadFailer(String msg) {
        Toast.makeText(VideoPlayActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPlayController != null) {
            mPlayController.onDestroy();
        }

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDownX = event.getX();
                mDownY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (Math.abs(mDownX - event.getX()) > 50 || Math.abs(mDownY - event.getY()) > 50) {
                    // 移动超过一定距离，ACTION_UP取消这次事件
                    mDownX = Integer.MAX_VALUE;
                    mDownY = Integer.MAX_VALUE;
                }
                break;
            case MotionEvent.ACTION_UP:
                if (mPlayController != null && Math.abs(mDownX - event.getX()) <= 50 && Math
                        .abs(mDownY - event.getY()) <= 50) {
                    // 解决与背景点击事件的冲突
                    if (mPlayController.isShowing()) {
                        mPlayController.hide();
                    } else {
                        mPlayController.show();
                    }
                }
                break;
        }
        return true;

    }

    @Override
    public void onBackPressed() {
        mVideoView.setVisibility(View.INVISIBLE);
        finish();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // 保持屏幕比例正确
        mVideoView.setVideoLayout(VideoView.VIDEO_LAYOUT_SCALE, 0);
        mPlayController.hide();
    }

}
