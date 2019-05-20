package com.model.singlecode.base.mvp;


import android.support.annotation.NonNull;

/**
 * 创建时间：2019/5/14
 * 创建人：singleCode
 * 功能描述：base view
 **/

public interface IBaseView {
    /**
     * 初始化presenter
     * <p>
     * 此方法返回的presenter对象不可为空,由具体界面实现该方法
     */
    @NonNull
    BasePresenter initPresenter();

}
