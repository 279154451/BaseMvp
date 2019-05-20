package com.model.singlecode.base.mvp.helper;


import io.reactivex.functions.Consumer;

/**
 * 创建时间：2019/5/14
 * 创建人：singleCode
 * 功能描述：
 **/
public abstract class BaseThrowable implements Consumer<Throwable> {

    @Override
    public void accept(Throwable throwable) throws Exception {
        onError(throwable);
    }

    public void onError(Throwable throwable) {
        //可以在这里处理网络异常、json解析异常等exception
    }

}
