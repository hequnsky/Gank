package com.zhq.gank.network.photo;

import com.zhq.gank.mvp.photo.model.PhotoModel;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者：hequnsky on 2016/8/4 16:19
 * <p>
 * 邮箱：heuqnsky@gmail.com
 */
public interface TngouService {

    @GET("/tnfs/api/list")
    Observable<PhotoModel> getPhotoList(@Query("id") int id, @Query("page") int page, @Query("rows") int rows);


//    @GET("api/data/福利/10/{page}")
//    Observable<PhotoModel> getPhotoList(@Path("page") int page);

}
