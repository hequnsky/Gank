package com.zhq.gank.mvp.news.ui;

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
 * 作者：hequnsky on 2016/8/4 11:58
 * 邮箱：hequnsky@gmail.com
 */
public class NewsFragment extends BaseFragment{

    public static final int NEWS_TYPE_FUNY = 0;
    public static final int NEWS_TYPE_GIRL = 1;
    public static final int NEWS_TYPE_MOVIE = 2;
    public static final int NEWS_TYPE_GAME = 3;

    TabLayout  mTablayout;
    ViewPager mViewPager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_news,null);
        mViewPager= (ViewPager) view.findViewById(R.id.viewpager);
        mTablayout= (TabLayout) view.findViewById(R.id.tab_layout);
        mViewPager.setOffscreenPageLimit(3);
        setupViewPager(mViewPager);
        mTablayout.addTab(mTablayout.newTab().setText(R.string.funy));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.girl));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.movie));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.game));
        mTablayout.setupWithViewPager(mViewPager);
        return  view;
    }



    private void setupViewPager(ViewPager mViewPager) {
        //Fragment中嵌套使用Fragment一定要使用getChildFragmentManager(),否则会有问题
        NewsPagerAdapter adapter = new NewsPagerAdapter(getChildFragmentManager());
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_FUNY), getString(R.string.funy));
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_GIRL), getString(R.string.girl));
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_MOVIE), getString(R.string.movie));
        adapter.addFragment(NewsListFragment.newInstance(NEWS_TYPE_GAME), getString(R.string.game));
        mViewPager.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initViews() {

    }


    public static class NewsPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public NewsPagerAdapter(FragmentManager fm) {
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


}
