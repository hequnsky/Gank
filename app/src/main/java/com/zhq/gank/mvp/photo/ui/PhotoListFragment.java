package com.zhq.gank.mvp.photo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhq.gank.R;
import com.zhq.gank.base.BaseActivity;
import com.zhq.gank.base.extend.MvpFragment;
import com.zhq.gank.mvp.photo.model.PhotoModel;
import com.zhq.gank.mvp.photo.presenter.PhotoListPresenterImpl;
import com.zhq.gank.mvp.photo.ui.adapter.PhotoAdapter;
import com.zhq.gank.mvp.photo.view.PhotoListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：hequnsky on 2016/8/1 15:39
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public class PhotoListFragment extends MvpFragment<PhotoListPresenterImpl> implements PhotoListView, SwipeRefreshLayout.OnRefreshListener {

    private int mType = PhotoFragment.PHOTO_TYPE_SEXY;
    SwipeRefreshLayout mSwipeRefreshWidget;
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mLayoutManager;
    private static final int REQUEST_VIEW = 1;
    List<PhotoModel> mData;
    private PhotoAdapter mAdapter;
    int id;
    int page = 1;
    int rows = 10;

    private BaseActivity context;


    public static PhotoListFragment newInstance(int type) {
        Bundle args = new Bundle();
        PhotoListFragment fragment = new PhotoListFragment();
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
        mLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new PhotoAdapter(getActivity().getApplicationContext());
        mAdapter.setOnItemClickListener(mOnItemClickListener);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(mOnScrollListener);
        mSwipeRefreshWidget.setOnRefreshListener(this);
        return view;
    }


    @Override
    protected void initData() {
        switch (mType) {
            case PhotoFragment.PHOTO_TYPE_SEXY:
                id = 1;
                break;
            case PhotoFragment.PHOTO_TYPE_JAPAN:
                id = 2;
                break;
            case PhotoFragment.PHOTO_TYPE_LEGS:
                id = 3;
                break;
            case PhotoFragment.PHOTO_TYPE_GIRL_PHOTO:
                id = 4;
                break;
            case PhotoFragment.PHOTO_TYPE_PORTAIT:
                id = 5;
                break;
            case PhotoFragment.PHOTO_TYPE_PURE_GIRL:
                id = 6;
                break;
            case PhotoFragment.PHOTO_TYPE_CAR_GRIL:
                id = 7;
                break;
            default:
                id = 1;
                break;
        }

        mvpPresenter.loadData(id, page, rows);

    }

    @Override
    protected void initViews() {

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
    public void addData(PhotoModel model) {

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
    }

    @Override
    public void loadFailer(String msg) {

    }

    @Override
    protected PhotoListPresenterImpl createPresenter() {
        return new PhotoListPresenterImpl(this);
    }

    @Override
    public void onRefresh() {
        page = 1;
        if (mData != null) {
            mData.clear();
            mvpPresenter.loadData(id, page, rows);

        }
    }

    private PhotoAdapter.OnItemClickListener mOnItemClickListener = new PhotoAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View view, int position) {
            PhotoModel.TngouBean item = mAdapter.getItem(position);
            Intent intent = new Intent(getActivity(), PhotoDatailActivity.class);
            intent.putExtra("url", item.getImg());
            ActivityOptionsCompat options = ActivityOptionsCompat

//            View transition = view.findViewById(R.id.ivNews);
                    .makeSceneTransitionAnimation(getActivity(), view, "Img");
            ActivityCompat.startActivity(getActivity(), intent, options.toBundle());

        }
    };

    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {

        private int[] lastPositions;
        private int lastVisibleItemPosition;
        private int currentScrollState = 0;

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) mLayoutManager;
            if (lastPositions == null) {
                lastPositions = new int[staggeredGridLayoutManager.getSpanCount()];
            }
            staggeredGridLayoutManager.findLastVisibleItemPositions(lastPositions);
            lastVisibleItemPosition = findMax(lastPositions);
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            currentScrollState = newState;

            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            int visibleItemCount = layoutManager.getChildCount();
            int totalItemCount = layoutManager.getItemCount();
            if (visibleItemCount > 0 && currentScrollState == RecyclerView.SCROLL_STATE_IDLE
                    && lastVisibleItemPosition >= totalItemCount - 1) {
                mvpPresenter.loadData(id, page, rows);

            }
        }
    };

    private int findMax(int[] lastPositions) {

        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}