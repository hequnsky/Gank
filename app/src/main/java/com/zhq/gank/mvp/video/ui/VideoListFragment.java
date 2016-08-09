package com.zhq.gank.mvp.video.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhq.gank.R;
import com.zhq.gank.base.extend.MvpFragment;
import com.zhq.gank.mvp.video.model.VideoModel;
import com.zhq.gank.mvp.video.presenter.VideoListPresenterImpl;
import com.zhq.gank.mvp.video.ui.adapter.VideoAdapter;
import com.zhq.gank.mvp.video.view.VideoListView;
import com.zhq.gank.utils.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：hequnsky on 2016/8/3 18:33
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public class VideoListFragment extends MvpFragment<VideoListPresenterImpl> implements VideoListView, SwipeRefreshLayout.OnRefreshListener {

    private int mType = VideoFragment.VIDEO_TYPE_XU;


    SwipeRefreshLayout mSwipeRefreshWidget;
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private VideoAdapter mAdapter;
    private List<VideoModel> mData;
    int catid, catwordid, page, p_;
    String t_;


    public static VideoListFragment newInstance(int type) {
        Bundle args = new Bundle();
        VideoListFragment fragment = new VideoListFragment();
        args.putInt("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mType = getArguments().getInt("type");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, null);
        mSwipeRefreshWidget = (SwipeRefreshLayout) view.findViewById(R.id.refresh);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new VideoAdapter(getActivity().getApplicationContext());
        mAdapter.setOnItemClickListener(mOnItemClickListener);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(mOnScrollListener);
        mSwipeRefreshWidget.setOnRefreshListener(this);
        return view;
    }

    @Override
    protected void initData() {

        switch (mType) {
            case VideoFragment.VIDEO_TYPE_XU:
                catid = 10172;
                catwordid = 146;
                page = 1;
                t_ = "1467794913084";
                p_ = 11597;
                break;
            case VideoFragment.VIDEO_TYPE_COMMENTARY:
                catid = 10172;
                catwordid = 113;
                page = 1;
                t_ = "1467794446790";

                p_ = 22715;
                break;
            case VideoFragment.VIDEO_TYPE_NEWEST:
                catid = 10173;
                catwordid = 114;
                page = 1;
                t_ = "1467794563851";
                p_ = 13898;
                break;
            case VideoFragment.VIDEO_TYPE_SPLENDID:
                catid = 10174;
                catwordid = 48;
                page = 1;
                t_ = "1467794689385";
                p_ = 30500;
                break;
            case VideoFragment.VIDEO_TYPE_CHEAt:
                catid = 10174;
                catwordid = 91;
                page = 1;
                t_ = "1470366703179";
                p_ = 11882;
                break;
            default:
                catid = 10172;
                catwordid = 27;
                page = 1;
                t_ = "1470365360836";
                p_ = 4853;
                break;
        }

        mvpPresenter.loadData(catid, catwordid, page, t_, p_);
    }

    @Override
    protected void initViews() {
    }

    @Override
    protected VideoListPresenterImpl createPresenter() {
        return new VideoListPresenterImpl(this);
    }

    @Override
    public void showProgress() {
        mSwipeRefreshWidget.setRefreshing(true);

    }

    @Override
    public void hideProgress() {
        mSwipeRefreshWidget.setRefreshing(false);
        mAdapter.isShowFooter(false);
    }

    @Override
    public void addData(VideoModel model) {

        if (mData == null) {
            mData = new ArrayList<>();
        }
        mData.add(model);
        if (page == 1) {
            mAdapter.setmDate(mData);
        } else {
            mAdapter.addDate(model);
            //如果没有更多数据了,则隐藏footer布局
            if (mData == null || mData.size() == 0) {
                mAdapter.isShowFooter(false);
            }
            mAdapter.notifyDataSetChanged();
        }
        page++;
        hideProgress();
    }

    @Override
    public void loadFailer(String msg) {

    }


    private VideoAdapter.OnItemClickListener mOnItemClickListener = new VideoAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            VideoModel.DataBean item = mAdapter.getItem(position);
            Intent intent = new Intent(getActivity(),VideoPlayActivity.class);
            intent.putExtra("Url", item.getVideo_url());
            intent.putExtra("Title", item.getTitle());
            startActivity(intent);
        }
    };

    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {

        private int lastVisibleItem;

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE
                    && lastVisibleItem + 1 == mAdapter.getItemCount()
                    ) {
                //加载更多
                mvpPresenter.loadData(catid, catwordid, page, t_, p_);
            }

        }
    };


    @Override
    public void onRefresh() {
        page = 1;
//        t_ = getTime() + "";
        if (mData != null) {
            mData.clear();
            mvpPresenter.loadData(catid, catwordid, page, t_, p_);
        }
    }

    /**
     * 获取当前时间戳
     *
     * @return
     */
    public long getTime() {
        String CURRENTTIME = DateUtil.getCurrentDate();
        long CHUO = DateUtil.getStringToDate(CURRENTTIME);
        return CHUO;
    }
}