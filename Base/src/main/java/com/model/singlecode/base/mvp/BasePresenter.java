package com.model.singlecode.base.mvp;


import android.support.annotation.NonNull;

import com.model.singlecode.base.mvp.helper.RxSubHelper;


/**
 * base Presenter抽象类
 * 前面在说泛型时，我们就说过泛型在设计模式中很常用，这里我们就采用了泛型类的方式来定义MVP模式中的presenter层
 * 在讲解presenter层时，我们说presenter会持有view和model的接口实例。但是每一个界面的view和model都不一样，
 * 所以采用泛型就能够很完美的帮我们实现所有界面和业务逻辑依赖于同一个底层框架库。
 * @param <M> 指向model的泛型参数
 * @param <V> 指向view的泛型参数
 */

public abstract class BasePresenter<M, V> {
    public M mIModel;
    public V mIView;
    /**
     *  这里是我们自定义的一个观察者被观察者模式的帮助类。
     *  整个框架中我们将应用到目前比较流行的OkHTTP+retrofit+订阅模式来实现数据获取
     */
    protected RxSubHelper rxSubHelper = new RxSubHelper();

    /**
     * 返回presenter想持有的Model引用
     * 由具体的model层返回一个具体的实例对象
     *
     * @return presenter持有的Model引用
     */
    public abstract M getModel();

    /**
     * 绑定IModel和IView的引用，初始化泛型变量
     * @param m model
     * @param v view
     */
    public void attachMV(@NonNull M m, @NonNull V v) {
        this.mIModel = m;
        this.mIView = v;
        this.onStart();
    }

    /**
     * 解绑IModel和IView
     */
    public void detachMV() {
        rxSubHelper.unSubscribe();
        mIView = null;
        mIModel = null;
    }

    /**
     * 解绑所有的订阅
     */
    public void clearAllSubscribe() {
        rxSubHelper.clearSubscribe();
        mIView = null;
        mIModel = null;
    }

    /**
     * IView和IModel绑定完成立即执行
     * <p>
     * 实现类实现绑定完成后的逻辑,例如数据初始化等,界面初始化, 更新等
     */
    public abstract void onStart();

    public abstract void onRefresh();

}
