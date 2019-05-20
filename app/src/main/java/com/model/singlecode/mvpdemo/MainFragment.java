package com.model.singlecode.mvpdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.model.singlecode.base.mvp.BaseMVPCompatFragment;
import com.model.singlecode.base.mvp.BasePresenter;
import com.model.singlecode.basemvp.R;
import com.model.singlecode.mvpdemo.mvp.contract.MainContract;
import com.model.singlecode.mvpdemo.mvp.presenter.MainPresenter;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * 创建时间：2019/5/20
 * 创建人：singleCode
 * 功能描述：
 **/
public class MainFragment extends BaseMVPCompatFragment<MainContract.MainPresenter,MainContract.MainModel>
implements MainContract.MainView {
    @Override
    protected void lazyLoad() {
        //可以再这里实现懒加载
        mPresenter.LoadData();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        // 初始化UI

    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    public void onLoadData(List<String> list) {
        //获取到加载的数据结果
    }

    @Override
    protected void onLoadingView() {
        super.onLoadingView();
        //重写，并实现加载动画等
    }
}
