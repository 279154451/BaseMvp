package com.model.singlecode.mvpdemo.mvp.contract;

import com.model.singlecode.base.mvp.BasePresenter;
import com.model.singlecode.base.mvp.IBaseModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * 创建时间：2019/5/19
 * 创建人：singleCode
 * 功能描述：
 **/
public interface MainContract {
    interface MainModel extends IBaseModel {
        Observable<List<String>> loadData();
    }

    interface MainView {
        void onLoadData(List<String> list);
    }

    public abstract class MainPresenter extends BasePresenter<MainModel,MainView> {
       public abstract void  LoadData();
    }
}
