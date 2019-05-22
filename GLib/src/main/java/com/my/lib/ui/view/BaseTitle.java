package com.my.lib.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.my.lib.R;


/**
 * Created by xiaoganggao on 15/8/6.
 * 公共title
 */
public class BaseTitle extends RelativeLayout {

    private Context context;
    private LinearLayout leftLayout, rightLayout02;
    private TextView rightText, leftText, titleText, rightText02;
    private ImageView rightImage;
    private ImageView leftImage;
    private ImageView rightImage02;
    private ImageView rightRedImg;
    private RelativeLayout rightLayout;
    private TextView bgTv;

    public BaseTitle(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public BaseTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public BaseTitle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.view_title, this);
        titleText = findViewById(R.id.title_content);
        rightLayout = findViewById(R.id.title_right_layout);
        rightText = findViewById(R.id.title_right_text);
        rightImage = findViewById(R.id.title_right_image);
        leftLayout = findViewById(R.id.title_left_layout);
        leftText = findViewById(R.id.title_left_text);
        leftImage = findViewById(R.id.title_left_image);
        rightRedImg = findViewById(R.id.title_right_red);
        bgTv = findViewById(R.id.title_bg_layout);

        rightLayout02 = findViewById(R.id.title_right_layout_02);
        rightText02 = findViewById(R.id.title_right_text_02);
        rightImage02 = findViewById(R.id.title_right_image_02);
    }

    public void reset() {
        leftText.setText("");
        rightText.setText("");
        leftImage.setImageBitmap(null);
        rightImage.setImageBitmap(null);
    }

    /**
     * 设置标题栏颜色
     *
     * @param color 颜色
     */
    public void setTitleBgResource(int color) {
        bgTv.setBackgroundResource(color);
    }

    /**
     * 设置标题栏颜色
     *
     * @param color 颜色
     */
    public void setTitleBgColor(int color) {
        bgTv.setBackgroundColor(color);
    }

    /**
     * 设置头部左侧图片
     *
     * @param name          名称
     * @param imgId         图片
     * @param imgColor      图片颜色
     * @param clickListener 点击监听
     */
    public void registerTitleLift(String name, int imgId, int imgColor, OnClickListener clickListener) {
        if (imgId != 0) {
            this.getLeftImage().setImageResource(imgId);
        } else {
            this.getLeftImage().setImageBitmap(null);
        }
        if (imgColor != 0) {
            this.getLeftImage().setColorFilter(imgColor);
        }
        if (name != null && name.length() > 0) {
            this.getLeftText().setText(name);
        } else {
            this.getLeftText().setText("");
        }
        if (clickListener != null) {
            this.getLeftLayout().setOnClickListener(clickListener);
        }
    }

    /**
     * 注册右侧图片监听
     */
    protected void registerTitleRight(String name, int imgId, OnClickListener clickListener) {
        if (imgId != 0) {
            this.getRightImage().setImageResource(imgId);
        } else {
            this.getRightImage().setImageBitmap(null);
        }
        if (name != null && name.length() > 0) {
            this.getRightText().setText(name);
        } else {
            this.getRightText().setText("");
        }
        if (clickListener != null) {
            this.getRightLayout().setOnClickListener(clickListener);
        }
    }

    protected void registerTitleRight02(String name, int imgId, OnClickListener clickListener) {
        if (imgId != 0) {
            this.getRightImage02().setImageResource(imgId);
        } else {
            this.getRightImage02().setImageBitmap(null);
        }
        if (name != null && name.length() > 0) {
            this.getRightText02().setText(name);
        } else {
            this.getRightText02().setText("");
        }
        if (clickListener != null) {
            this.getRightLayout02().setOnClickListener(clickListener);
        }
    }

    /**
     * 设置title内容
     */
    public void setTitleContent(String string) {
        titleText.setText(string);
    }

    public void setBg(int color) {
        setBackgroundColor(color);
    }

    public RelativeLayout getRightLayout() {
        return rightLayout;
    }

    public LinearLayout getLeftLayout() {
        return leftLayout;
    }

    public TextView getRightText() {
        return rightText;
    }

    public TextView getLeftText() {
        return leftText;
    }

    public TextView getTitleText() {
        return titleText;
    }

    public ImageView getRightImage() {
        return rightImage;
    }

    public ImageView getLeftImage() {
        return leftImage;
    }

    public ImageView getRightRedImg() {
        return rightRedImg;
    }

    public ImageView getRightImage02() {
        return rightImage02;
    }

    public TextView getRightText02() {
        return rightText02;
    }

    public LinearLayout getRightLayout02() {
        return rightLayout02;
    }
}
