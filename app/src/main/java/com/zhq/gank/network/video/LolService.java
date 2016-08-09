package com.zhq.gank.network.video;

import com.zhq.gank.mvp.video.model.VideoModel;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者：hequnsky on 2016/8/3 19:08
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public interface LolService {
    @GET("apis/rest/ItemsService/videos")
    Observable<VideoModel> getVideo(
            @Query("catid") int catid,
            @Query("catwordid") int catwordid,
            @Query("page") int page,
            @Query("t_") String t_,
            @Query("p_") int p_);
}
