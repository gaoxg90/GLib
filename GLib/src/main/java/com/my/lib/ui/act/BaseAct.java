package com.my.lib.ui.act;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import org.jetbrains.annotations.Nullable;

/**
 * Created by xiaoganggao on 17/11/1.
 * base activity
 */
public abstract class BaseAct extends Activity implements View.OnClickListener {
    /**
     * Log Tag
     */
    protected final String TAG = this.getClass().getSimpleName();

    public LinearLayout baseLayout;
    public View mContextView;

    /**
     * [绑定布局]
     */
    public abstract int bindLayout();

    /**
     * [绑定视图]
     */
    public View bindView() {
        return null;
    }

    /**
     * [初始化参数]
     */
    public abstract void initPrams(Bundle prams);

    /**
     * [初始化控件]
     */
    public abstract void initView(final View view);

    /**
     * [绑定控件]
     */
    @SuppressWarnings("unchecked")
    protected <T extends View> T $(int resId) {
        return (T) super.findViewById(resId);
    }

    /**
     * [设置监听]
     */
    public abstract void setListener();

    /**
     * [数据初始化]
     */
    public abstract void initData();


    /**
     * [业务操作]
     */
    public abstract void doBusiness(Context mContext, Bundle savedInstanceState);

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

    /**
     * 页面结构
     */
    private void initBaseView() {
        baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);

        baseLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));

        mContextView.setLayoutParams(new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

        baseLayout.addView(mContextView);
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

        initBaseView();
        setContentView(baseLayout);

        initView(baseLayout);
        setListener();
        initData();
        doBusiness(this, savedInstanceState);
    }


}
