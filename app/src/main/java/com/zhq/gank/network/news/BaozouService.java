package com.zhq.gank.network.news;

import com.zhq.gank.mvp.news.model.NewsModel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者：hequnsky on 2016/8/4  13:58
 * 邮箱：hequnsky@gmail.com
 */
public interface BaozouService {

    @GET("api/v31/channels/{channels_id}")
    Observable<NewsModel> getNews(@Path("channels_id") int channels_id);

    /**
     * 获取下一页
     *
     * @param timestamp
     * @return
     */
    @GET("api/v31/channels/{channels_id}")
    Observable<NewsModel> getNextNews(@Path("channels_id") int channels_id, @Query("timestamp") int timestamp);


}