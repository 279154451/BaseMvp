package com.model.singlecode.base.mvp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;


import org.greenrobot.eventbus.EventBus;

import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 创建时间：2019/5/14
 * 创建人：singleCode
 * 功能描述：Base CompatActivity对Activity进行上层分装，将一些公共的初始化操作放到一起。
 * 如：状态栏设置、布局xml文件引入、以及EventBus、ButterKnife等的注册与解注册等
 **/
public abstract class BaseCompatActivity extends AppCompatActivity {

    protected Context mContext;
    private Unbinder mUnBinder;
    static {
        //5.0以下兼容vector
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //1、设置状态栏主题颜色
//        StatusBarUtils.setStatusBar(this);

        //2、引入布局，设置布局Id
        setContentView(getLayoutId());

        //3、ButterKnife.bind 绑定并初始化布局控件
        mUnBinder = ButterKnife.bind(this);


        //4、设置状态栏透明色
//        StatusBarUtils.setTransparent(this);

        //5、设置屏幕显示的方向，此处为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //6、初始化数据
        initData();

        if(!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

        //7、子类初始化数据
        initView(savedInstanceState);

        //8、将当前Acitivity加入栈
//        AppManager.getAppManager().addActivity(this);

        onLoadingView();

    }

    /**
     * 首次加载布局
     */
    protected void onLoadingView(){}

    /**
     * 获取当前layouty的布局ID,用于设置当前布局
     * 交由子类实现
     *
     * @return layout Id
     */
    protected abstract int getLayoutId();

    /**
     * 初始化view
     * <p>
     * 子类实现 控件绑定、视图初始化等内容
     *
     * @param savedInstanceState savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 初始化数据
     * <p>
     * 子类可以复写此方法初始化子类数据
     */
    protected void initData() {
        mContext = this;
    }


    protected void openStartActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }


    @Override
    protected void onDestroy() {
        mUnBinder.unbind();
        if(EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
