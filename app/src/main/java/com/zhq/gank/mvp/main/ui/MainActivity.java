package com.zhq.gank.mvp.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.zhq.gank.R;
import com.zhq.gank.base.BaseActivity;
import com.zhq.gank.mvp.main.presenter.MainParsenterImpl;
import com.zhq.gank.mvp.main.view.MainView;
import com.zhq.gank.mvp.news.ui.NewsFragment;
import com.zhq.gank.mvp.photo.ui.PhotoFragment;
import com.zhq.gank.mvp.video.ui.VideoFragment;
import com.zhq.gank.utils.ShareUtils;

import butterknife.Bind;

public class MainActivity extends BaseActivity<MainParsenterImpl> implements MainView {
    @Bind(R.id.nav_view)
    NavigationView navigationView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawe;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SwitchItem(R.id.nav_news);
        init();


    }

    private void init() {
        setSupportActionBar(toolbar);
        mDrawerToggle = new ActionBarDrawerToggle(this, drawe, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        mDrawerToggle.syncState();
        drawe.setDrawerListener(mDrawerToggle);
        navigationView.setCheckedItem(R.id.nav_news);
        setupDrawerContent(navigationView);


    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Presente.switchNavigation(item.getItemId());
                if (item.getItemId() == R.id.nav_setting || item.getItemId() == R.id.nav_share) {

                } else {
                    item.setChecked(true);
                }
                drawe.closeDrawers();
                return true;
            }


        });

    }

    @Override
    protected MainParsenterImpl createPresenter() {
        return new MainParsenterImpl(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }
    }


    @Override
    public void SwitchItem(int itemId) {

        switch (itemId) {
            case R.id.nav_news:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new NewsFragment()).commit();
                toolbar.setTitle(R.string.navigation_news);
                break;
            case R.id.nav_gallery:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new PhotoFragment()).commit();
                toolbar.setTitle(R.string.navigation_photo);
                break;
            case R.id.nav_video:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new VideoFragment()).commit();
                toolbar.setTitle(R.string.navigation_video);
                break;
            case R.id.nav_ball:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new BallFragment()).commit();
                toolbar.setTitle(R.string.navigation_game);
                break;
            case R.id.nav_share:
                ShareUtils.shareText(this, getString(R.string.share_app_description));
                break;
            case R.id.nav_setting:
                startActivity(new Intent(this, SettingsActivity.class));
                break;
            default:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, new NewsFragment()).commit();
                toolbar.setTitle(R.string.navigation_news);
                break;
        }
    }

    @Override
    protected boolean isSupportSwipeBack() {
        return false;
    }
}
