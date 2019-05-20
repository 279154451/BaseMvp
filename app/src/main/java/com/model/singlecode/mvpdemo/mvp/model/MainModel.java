package com.model.singlecode.mvpdemo.mvp.model;

import com.model.singlecode.base.mvp.helper.RetrofitCreateHelper;
import com.model.singlecode.base.mvp.helper.RxHelper;
import com.model.singlecode.mvpdemo.MainApiService;
import com.model.singlecode.mvpdemo.mvp.contract.MainContract;

import java.util.List;

import io.reactivex.Observable;

/**
 * 创建时间：2019/5/19
 * 创建人：singleCode
 * 功能描述：
 **/
public class MainModel implements MainContract.MainModel {
    @Override
    public Observable<List<String>> loadData() {
        return RetrofitCreateHelper.createApi(MainApiService.class,"http://www.base.com/").loadData()
                .compose(RxHelper.<List<String>>rxSchedulerHelper());
    }
}
