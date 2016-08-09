package com.zhq.gank.mvp.video.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhq.gank.R;
import com.zhq.gank.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：hequnsky on 2016/6/29 11:59
 * 邮箱：hequnsky@gmail.com
 */
public class VideoFragment extends BaseFragment {

    public static final int VIDEO_TYPE_XU = 0;
    public static final int VIDEO_TYPE_COMMENTARY = 1;
    public static final int VIDEO_TYPE_NEWEST = 2;
    public static final int VIDEO_TYPE_SPLENDID = 3;
    public static final int VIDEO_TYPE_CHEAt = 5;

    TabLayout mTablayout;
    ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, null);
        mViewPager = (ViewPager) view.findViewById(R.id.video_viewpager);
        mTablayout = (TabLayout) view.findViewById(R.id.video_tab_layout);
        mViewPager.setOffscreenPageLimit(3);
        setupViewPager(mViewPager);
        mTablayout.addTab(mTablayout.newTab().setText(R.string.xu));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.commentary));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.newest));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.splendid));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.cheat));
        mTablayout.setupWithViewPager(mViewPager);
        return view;
    }

    private void setupViewPager(ViewPager mViewPager) {
        //Fragment中嵌套使用Fragment一定要使用getChildFragmentManager(),否则会有问题
        VideoagerAdapter adapter = new VideoagerAdapter(getChildFragmentManager());
        adapter.addFragment(VideoListFragment.newInstance(VIDEO_TYPE_XU), getString(R.string.xu));
        adapter.addFragment(VideoListFragment.newInstance(VIDEO_TYPE_COMMENTARY), getString(R.string.commentary));
        adapter.addFragment(VideoListFragment.newInstance(VIDEO_TYPE_NEWEST), getString(R.string.newest));
        adapter.addFragment(VideoListFragment.newInstance(VIDEO_TYPE_SPLENDID), getString(R.string.splendid));
        adapter.addFragment(VideoListFragment.newInstance(VIDEO_TYPE_CHEAt), getString(R.string.cheat));
        mViewPager.setAdapter(adapter);
    }

    public static class VideoagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public VideoagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initViews() {

    }
}
