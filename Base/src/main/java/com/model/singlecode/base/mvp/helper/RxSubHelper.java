package com.model.singlecode.base.mvp.helper;



import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 创建时间：2019/5/14
 * 创建人：singleCode
 * 功能描述：用于管理Rxjava 注册订阅和取消订阅
 **/
public class RxSubHelper<T> {

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();// 管理订阅者者

    public void register(Disposable d) {
        mCompositeDisposable.add(d);

    }

    public void unSubscribe() {
        mCompositeDisposable.dispose();// 取消订阅
    }

    public void clearSubscribe() {
        mCompositeDisposable.clear();// 取消订阅
    }

}