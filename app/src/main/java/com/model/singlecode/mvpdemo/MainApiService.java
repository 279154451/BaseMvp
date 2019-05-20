package com.model.singlecode.mvpdemo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * 创建时间：2019/5/19
 * 创建人：singleCode
 * 功能描述：
 **/
public interface MainApiService {
    //首页
    @GET("index")
    Observable<List<String>> loadData();
}
