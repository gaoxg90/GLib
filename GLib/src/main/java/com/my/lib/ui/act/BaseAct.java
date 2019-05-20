package com.my.lib.ui.act;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import org.jetbrains.annotations.Nullable;

/**
 * Created by xiaoganggao on 17/11/1.
 * base activity
 */
public abstract class BaseAct extends Activity implements View.OnClickListener {

    //log tag
    protected final String TAG = this.getClass().getSimpleName();
    /**
     * 当前Activity渲染的视图View
     **/
    private View mContextView = null;

    /**
     * [初始化参数]
     */
    public abstract void initPrams(Bundle prams);

    /**
     * [绑定布局]
     */
    public abstract int bindLayout();

    /**
     * [绑定视图]
     */
    public abstract View bindView();

    /**
     * [初始化控件]
     */
    public abstract void initView(final View view);

    /**
     * [绑定控件]
     */
    protected <T extends View> T $(int resId) {
        return (T) super.findViewById(resId);
    }

    /**
     * [设置监听]
     */
    public abstract void setListener();

    /**
     * [业务操作]
     */
    public abstract void doBusiness(Context mContext);

    /**
     * 数据初始化
     * 界面默认显示数据
     */
    public abstract void initData();

    /**
     * [VIEW点击]
     */
    public abstract void widgetClick(View v);

    @Override
    public void onClick(View v) {
        widgetClick(v);
    }

    /**
     * [页面跳转]
     */
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(BaseAct.this, clz));
    }

    /**
     * [携带数据的页面跳转]
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * [含有Bundle通过Class打开编辑界面]
     */
    public void startActivityForResult(Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取参数
        Bundle bundle = getIntent().getExtras();
        initPrams(bundle);
        //
        View mView = bindView();
        if (null == mView) {
            mContextView = LayoutInflater.from(this).inflate(bindLayout(), null);
        } else {
            mContextView = mView;
        }
        setContentView(mContextView);

        initView(mContextView);
        setListener();
        initData();
        doBusiness(this);
    }
}
