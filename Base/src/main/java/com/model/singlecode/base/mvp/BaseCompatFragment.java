package com.model.singlecode.base.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import org.greenrobot.eventbus.EventBus;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Horrarndoo on 2017/9/26.
 * <p>
 */

public abstract class BaseCompatFragment extends Fragment {

    protected String TAG;
    protected Context mContext;
    protected Activity mActivity;
    private Unbinder binder;


    private View mRootView = null;

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(mContext);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {

        if(mRootView == null) {
            mRootView = inflater.inflate(getLayoutId(), container, false);
        }

        if(mRootView != null) {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if(parent != null) {
                parent.removeView(mRootView);
            }
        }

        if(!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

        return mRootView;
    }

    /******************懒加载*****************/

    protected boolean isViewInitiated;
    protected boolean isVisibleToUser;
    protected boolean isDataInitiated;
    protected boolean isFragmentHidden;
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        prepareFetchData();

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        isFragmentHidden= hidden;

    }

    public boolean prepareFetchData() {
        return prepareFetchData(false);
    }

    public boolean prepareFetchData(boolean forceUpdate) {
        if (isVisibleToUser && isViewInitiated && (!isDataInitiated || forceUpdate)) {
            lazyLoad();
            isDataInitiated = true;
            return true;
        }
        return false;
    }

    /**
     * 加载要显示的数据
     */
    protected abstract void lazyLoad();

    /*************************************/


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        TAG = getClass().getSimpleName();
        //绑定butterKnife
        binder = ButterKnife.bind(this, view);
        getBundle(getArguments());
        isViewInitiated = true;
        prepareFetchData();
        initData();
        initUI(view, savedInstanceState);

        onLoadingView();

    }

    public void initData(){

    }

    public void openStartActivity(Class clazz) {
        Intent intent = new Intent(this.getActivity(), clazz);
        startActivity(intent);
    }

    /**
     * 首次加载布局
     */
    protected abstract void onLoadingView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (binder != null)
            binder.unbind();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        if(EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        super.onDestroy();
    }

    @LayoutRes
    public abstract int getLayoutId();

    /**
     * 得到Activity传进来的值
     */
    public void getBundle(Bundle bundle) {
    }

    /**
     * 初始化UI
     */
    public abstract void initUI(View view, @Nullable Bundle savedInstanceState);

}
