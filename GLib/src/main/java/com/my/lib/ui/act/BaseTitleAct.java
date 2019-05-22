package com.my.lib.ui.act;

import android.view.View;

import com.my.lib.ui.view.BaseTitle;
import com.my.lib.utils.GLog;

/**
 * Created by xiaoganggao on 17/11/1.
 * base title activity
 */
public abstract class BaseTitleAct extends BaseAct {

    private BaseTitle baseTitle;

    /**
     * [标题栏数据]
     */
    public abstract void initTitleData();

    public void initTitle() {
        try {
            baseTitle = new BaseTitle(this);
            baseLayout.addView(baseTitle, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setContentView(View view) {
        initTitle();
        super.setContentView(view);
        initTitleData();
    }

    /**
     * 设置title内容
     */
    public void setTitleContent(String titleRes) {
        if (baseTitle != null) {
            baseTitle.setTitleContent(titleRes);
        } else {
            GLog.e("null baseTitle");
        }
    }

    /**
     * 设置title color
     */
    public void setTitleBgColor(int color) {
        if (baseTitle != null) {
            baseTitle.getTitleText().setTextColor(color);
        } else {
            GLog.e("null baseTitle");
        }
    }
}
