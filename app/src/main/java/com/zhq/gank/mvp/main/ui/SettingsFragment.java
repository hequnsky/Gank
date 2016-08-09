package com.zhq.gank.mvp.main.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhq.gank.R;
import com.zhq.gank.utils.CacheUtil;

/**
 * 作者：hequnsky on 2016/8/5 16:25
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public class SettingsFragment extends PreferenceFragment {
    private Preference mPreference;
    private View rootView;

    public SettingsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        mPreference = findPreference("clear_cache");
        mPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                CacheUtil.deleteDir(SettingsFragment.this.getActivity().getCacheDir());
                showCacheSize(mPreference);
                return true;
            }
        });
        findPreference("feedback").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                sendEmailFeedback();
                return true;
            }
        });

        //
        findPreference("version").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {


                return true;
            }
        });

    }


    private void showCacheSize(Preference preference) {
        preference.setSummary(getActivity().getString(R.string.cache_size) + CacheUtil.getCacheSize(getActivity().getCacheDir()));
    }

    private void sendEmailFeedback() {

        try {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", "heuqnsky@gmail.com", null));
            startActivity(Intent.createChooser(intent, "选择邮件客户端:"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (null == rootView) {
            rootView = super.onCreateView(inflater, container, savedInstanceState);
        }
        return rootView;

    }

}
