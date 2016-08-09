package com.zhq.gank.widget;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;

import com.zhq.gank.R;
import com.zhq.gank.utils.ViewUtil;

import java.lang.ref.WeakReference;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.utils.StringUtils;
import io.vov.vitamio.widget.VideoView;

/**
 * 作者：hequnsky on 2016/8/3 18:03
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public class VideoPlayController  {
    private String mTitle;
    // 默认停留的时间
    private static final int DEFAULT_TIMEOUT = 5000;
    // 退出
    private static final int FADE_OUT = 1;
    // 显示
    private static final int SHOW_PROGRESS = 2;

    private final AudioManager mAudioManager;
    private PopupWindow mPopupWindow;
    private Activity mContext;
    private View mAnchorView;
    private VideoView mVideoView;
    private View mContentView;

    private  TextView video_title;
    // 关闭按钮
    private ImageView mCloseButton;
    // 播放暂停按钮
    private ImageView mPlayButton;
    // 播放到时间
    private TextView mCurrentTimeTv;
    // 总的时间
    private TextView mTotalTimeTv;
    // 播放进度条
    private SeekBar mSeekBar;
    // 横竖屏切换
    private ImageView mFullScreenButton;
    // 总的播放时间
    private long mTotalTime;
    // 当前的播放时间
    private long mCurrentTime;

    // 进度条是否正在被拖拽
    private boolean mIsDraging;
    // 当前布局是否正在显示
    private boolean mShowing;

    private VideoHandler mHandler;

    private static class VideoHandler extends Handler {

        WeakReference<VideoPlayController> mReference;

        VideoHandler(VideoPlayController controller1) {
            mReference = new WeakReference<>(controller1);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case FADE_OUT:
                    // 隐藏布局
                    mReference.get().hide();
                    break;
                case SHOW_PROGRESS:
                    // 获取进度
                    long pos = mReference.get().setProgress();
                    if (!mReference.get().mIsDraging && mReference.get().mShowing) {
                        // 如果没被拖拽并且正在显示的话设置进度
                        //                        KLog.e("如果没被拖拽并且正在显示的话设置进度");
                        msg = obtainMessage(SHOW_PROGRESS);
                        sendMessageDelayed(msg, 1000 - (pos % 1000));
                    }
                    break;
            }
        }
    }


    public VideoPlayController(Activity context, VideoView videoView, View anchorView,String title) {
        mContext = context;
        mAnchorView = anchorView;
        mVideoView = videoView;
        mTitle=title;
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (mPlayButton != null) {
                    mPlayButton.setSelected(true);
                }
                show();
            }
        });

        mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);

        mHandler = new VideoHandler(this);
    }

    public void onDestroy() {
        mHandler.removeCallbacksAndMessages(null);
        mPopupWindow = null;
        mContext = null;
        mAnchorView = null;
        mVideoView = null;
        mContentView = null;
        mHandler = null;
    }

    /**
     * 设置进度条和时间
     *
     * @return
     */
    private long setProgress() {
        if (mVideoView == null || mIsDraging) return 0;

        long position = mVideoView.getCurrentPosition();
        long duration = mVideoView.getDuration();
        if (mSeekBar != null) {
            if (duration > 0) {
                long pos = 1000L * position / duration;
                mSeekBar.setProgress((int) pos);
            }
            int percent = mVideoView.getBufferPercentage();
            mSeekBar.setSecondaryProgress(percent * 10);
        }

        mTotalTime = duration;

        if (mTotalTimeTv != null) mTotalTimeTv.setText(StringUtils.generateTime(mTotalTime));
        if (mCurrentTimeTv != null) mCurrentTimeTv.setText(StringUtils.generateTime(position));

        return position;
    }

    public void hide() {
        if (mPopupWindow != null && isShowing()) {
            mHandler.removeMessages(SHOW_PROGRESS);
            mHandler.removeMessages(FADE_OUT);
            mPopupWindow.dismiss();
            mShowing = false;
        }
    }

    public void show() {

        if (mPopupWindow != null && !isShowing()) {
            showLayout();
            return;
        } else if (mPopupWindow != null && isShowing() && mContentView != null) {
            return;
        }

        mContentView = LayoutInflater.from(mContext)
                .inflate(R.layout.include_video_ctrol, null, false);

        final View bottomView = mContentView.findViewById(R.id.rl_bottom);

        mContentView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getY() >= mContentView.getMeasuredHeight() - bottomView
                        .getMeasuredHeight()) {
                    return false;
                } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    hide();
                    return true;
                }
                return false;
            }
        });
        mContentView.setFocusableInTouchMode(true);
        // 监听返回键并且关闭弹窗
        mContentView.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event
                        .getRepeatCount() == 0 && isShowing()) {
                    hide();
                }
                return true;
            }
        });

        mCurrentTimeTv = (TextView) mContentView.findViewById(R.id.tv_time_current);
        mTotalTimeTv = (TextView) mContentView.findViewById(R.id.tv_time_total);

        mSeekBar = (SeekBar) mContentView.findViewById(R.id.iv_seek_bar);
        mSeekBar.setOnSeekBarChangeListener(mOnSeekBarChangeListener);

        mPlayButton = (ImageView) mContentView.findViewById(R.id.iv_play);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!v.isSelected()) {
                    // 正在paly，点击暂停的情况
                    mVideoView.pause();
                } else {
                    if (mVideoView.getCurrentPosition() == mVideoView.getDuration()) {
                        // 播放完了，重播
                        mVideoView.seekTo(0);
                    } else {
                        mVideoView.start();
                    }
                }
                v.setSelected(!v.isSelected());
            }
        });

        video_title= (TextView) mContentView.findViewById(R.id.video_title);
        mCloseButton = (ImageView) mContentView.findViewById(R.id.iv_close);
        mCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.finish();
            }
        });

        mFullScreenButton = (ImageView) mContentView.findViewById(R.id.iv_full);
        mFullScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewUtil.rotateScreen(mContext);
            }
        });
        video_title.setText(mTitle);
        mPopupWindow = new PopupWindow(mContentView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, true);

        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(null);
        mPopupWindow.setTouchable(true);

        // 设置好参数之后再show
        showLayout();

    }

    private void showLayout() {

        mFullScreenButton
                .setSelected(mAnchorView.getMeasuredWidth() > mAnchorView.getMeasuredHeight());

        mPopupWindow.showAsDropDown(mAnchorView,
                (mAnchorView.getMeasuredWidth() - mContentView.getMeasuredWidth()) / 2,
                -mAnchorView.getMeasuredHeight());
        mShowing = true;

        // 开启弹窗的时候，根据视频是否正在播放设置播放按钮的状态
        mPlayButton.setSelected(!mVideoView.isPlaying());

        // 设置进度条
        mHandler.sendEmptyMessage(SHOW_PROGRESS);
        // 三秒后关闭布局
        mHandler.removeMessages(FADE_OUT);
        mHandler.sendMessageDelayed(mHandler.obtainMessage(FADE_OUT), DEFAULT_TIMEOUT);

    }

    private SeekBar.OnSeekBarChangeListener mOnSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // 若不是用户拖动的话，即视频播放控制进度的时候，直接返回不处理
            if (!fromUser) {
                // KLog.e("若不是用户拖动的话，即视频播放控制进度的时候，直接返回不处理");
                return;
            }

            // 计算新的位置
            long newPosition = (mTotalTime * progress) / 1000;
            String time = StringUtils.generateTime(newPosition);



            mPlayButton.setSelected(false);

            mVideoView.seekTo(newPosition);
            if (mCurrentTimeTv != null) {
                mCurrentTimeTv.setText(time);
            }

            mHandler.removeMessages(FADE_OUT);

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // 开始触碰到seekbar
            mIsDraging = true;
            show();
            mHandler.removeMessages(SHOW_PROGRESS);
            mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER,
                    AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // 停止拖动
            mVideoView.seekTo((mTotalTime * mSeekBar.getProgress()) / 1000);
            show();
            mHandler.removeMessages(SHOW_PROGRESS);
            mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE,
                    AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
            mIsDraging = false;
            mHandler.sendEmptyMessageDelayed(SHOW_PROGRESS, 1000);

            mHandler.sendMessageDelayed(mHandler.obtainMessage(FADE_OUT), DEFAULT_TIMEOUT);

        }
    };

    public boolean isShowing() {
        return mShowing;
    }

}
