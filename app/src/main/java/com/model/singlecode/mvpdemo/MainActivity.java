package com.model.singlecode.mvpdemo;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.model.singlecode.base.mvp.BaseMVPCompatActivity;
import com.model.singlecode.base.mvp.BasePresenter;
import com.model.singlecode.basemvp.R;
import com.model.singlecode.mvpdemo.mvp.contract.MainContract;
import com.model.singlecode.mvpdemo.mvp.presenter.MainPresenter;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseMVPCompatActivity<MainContract.MainPresenter, MainContract.MainModel>
        implements MainContract.MainView {
    @BindView(R.id.tx_main)//通过butterknife绑定布局文件中的控件，省去繁琐的findViewById
    TextView tx_main;

    @Override
    protected int getLayoutId() {//绑定布局文件
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        tx_main.setText("mvp demo");
        tx_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mPresenter.LoadData();//activity只需要调用presenter方法获取数据即可
    }

    @NonNull
    @Override
    public BasePresenter initPresenter() {//返回绑定的具体presenter 实例
        return new MainPresenter();
    }

    @Override
    public void onLoadData(List<String> list) {
        //调用presenter方法获取的结果返回数据
    }
}
