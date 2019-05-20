package com.model.singlecode.base.mvp;


/**
 * 创建时间：2019/5/14
 * 创建人：singleCode
 * 功能描述：base mvp Activity  将MVP模式引入到Activity中来
 *，这里再次用到了泛型类的知识，将activity定义成一个泛型类，与某个presenter、model进行绑定。
 * 同时又是base activity 的子类，完成了必要的初始化工作
 **/

public abstract class BaseMVPCompatActivity<P extends BasePresenter, M extends IBaseModel> extends
        BaseCompatActivity implements IBaseView {

    /**
     * presenter 具体的presenter由子类确定
     */
    protected P mPresenter;

    /**
     * model 具体的model由子类确定
     */
    private M mIMode;

    /**
     * 初始化数据
     * <p>
     * 子类可以复写此方法初始化子类数据
     */
    protected void initData() {
        super.initData();
        mPresenter = (P) initPresenter();
        if (mPresenter != null) {
            mIMode = (M) mPresenter.getModel();
            if (mIMode != null) {
                mPresenter.attachMV(mIMode, this);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachMV();
        }
    }
}
