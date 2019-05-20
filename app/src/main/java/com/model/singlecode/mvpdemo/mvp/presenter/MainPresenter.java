package com.model.singlecode.mvpdemo.mvp.presenter;

import com.model.singlecode.base.mvp.helper.BaseThrowable;
import com.model.singlecode.mvpdemo.mvp.contract.MainContract;
import com.model.singlecode.mvpdemo.mvp.model.MainModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * 创建时间：2019/5/19
 * 创建人：singleCode
 * 功能描述：
 **/
public class MainPresenter extends MainContract.MainPresenter {
    @Override
    public MainContract.MainModel getModel() {
        return new MainModel();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void LoadData() {
        rxSubHelper.register(mIModel.loadData().subscribe(new Consumer<List<String>>() {
            @Override
            public void accept(List<String> list) throws Exception {
                mIView.onLoadData(list);
            }
        }, new BaseThrowable() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                super.accept(throwable);
            }
        }));
    }
}
