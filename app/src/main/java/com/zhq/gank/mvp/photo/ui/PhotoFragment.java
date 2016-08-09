package com.zhq.gank.mvp.photo.ui;

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
 * 作者：hequnsky on 2016/8/1 15:41
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public class PhotoFragment extends BaseFragment {

    public static final int PHOTO_TYPE_SEXY = 0;
    public static final int PHOTO_TYPE_JAPAN = 1;
    public static final int PHOTO_TYPE_LEGS = 2;
    public static final int PHOTO_TYPE_GIRL_PHOTO = 3;
    public static final int PHOTO_TYPE_PORTAIT = 4;
    public static final int PHOTO_TYPE_PURE_GIRL = 5;
    public static final int PHOTO_TYPE_CAR_GRIL = 6;

    TabLayout mTablayout;
    ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo, null);
        mViewPager = (ViewPager) view.findViewById(R.id.photo_viewpager);
        mTablayout = (TabLayout) view.findViewById(R.id.phototab_layout);
        mViewPager.setOffscreenPageLimit(3);
        setupViewPager(mViewPager);
        mTablayout.addTab(mTablayout.newTab().setText(R.string.sexy));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.japan));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.legs));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.girl_photo));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.portait));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.pure_gril));
        mTablayout.addTab(mTablayout.newTab().setText(R.string.car_gril));
        mTablayout.setupWithViewPager(mViewPager);
        return view;
    }

    private void setupViewPager(ViewPager mViewPager) {
        //Fragment中嵌套使用Fragment一定要使用getChildFragmentManager(),否则会有问题
        PhotoPagerAdapter adapter = new PhotoPagerAdapter(getChildFragmentManager());
        adapter.addFragment(PhotoListFragment.newInstance(PHOTO_TYPE_SEXY), getString(R.string.sexy));
        adapter.addFragment(PhotoListFragment.newInstance(PHOTO_TYPE_JAPAN), getString(R.string.japan));
        adapter.addFragment(PhotoListFragment.newInstance(PHOTO_TYPE_LEGS), getString(R.string.legs));
        adapter.addFragment(PhotoListFragment.newInstance(PHOTO_TYPE_GIRL_PHOTO), getString(R.string.girl_photo));
        adapter.addFragment(PhotoListFragment.newInstance(PHOTO_TYPE_PORTAIT), getString(R.string.portait));
        adapter.addFragment(PhotoListFragment.newInstance(PHOTO_TYPE_PURE_GIRL), getString(R.string.pure_gril));
        adapter.addFragment(PhotoListFragment.newInstance(PHOTO_TYPE_CAR_GRIL), getString(R.string.car_gril));
        mViewPager.setAdapter(adapter);
    }

    public static class PhotoPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public PhotoPagerAdapter(FragmentManager fm) {
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
