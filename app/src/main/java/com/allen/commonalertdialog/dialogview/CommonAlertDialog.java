package com.allen.commonalertdialog.dialogview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.allen.commonalertdialog.R;

/**
 * Created by Allen on 2016/7/11.
 */
public class CommonAlertDialog extends Dialog implements View.OnClickListener {

    private View mDialogView;


    private TextView mTitleTextView;
    private TextView mContentTextView;
    private String mTitleText;
    private String mContentText;
    private boolean mShowCancel;
    private boolean mShowContent;
    private String mCancelText;
    private String mConfirmText;
    private int mAlertType;


    private Drawable mCustomImgDrawable;
    private ImageView mCustomImage;

    private FrameLayout mProgressFrame;

    private Button mConfirmButton;
    private Button mCancelButton;


    private OnCommonClickListener mCancelClickListener;
    private OnCommonClickListener mConfirmClickListener;



    public  interface OnCommonClickListener {
         void onClick (CommonAlertDialog commonAlertDialog);
    }




    public CommonAlertDialog(Context context) {
        super(context, R.style.common_alert_dialog_style);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_alert_dialog_layout);

        mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);

        mCustomImage = (ImageView)findViewById(R.id.common_alert_dialog_custom_image);

        mProgressFrame = (FrameLayout)findViewById(R.id.common_alert_dialog_progress_frame_layout);

        mTitleTextView = (TextView)findViewById(R.id.common_alert_dialog_title_text);
        mContentTextView = (TextView)findViewById(R.id.common_alert_dialog_content_text);

        mConfirmButton = (Button)findViewById(R.id.common_alert_dialog_confirm_button);
        mCancelButton = (Button)findViewById(R.id.common_alert_dialog_cancel_button);

        mConfirmButton.setOnClickListener(this);
        mCancelButton.setOnClickListener(this);


        setTitleText(mTitleText);
        setContentText(mContentText);
        setCancelText(mCancelText);
        setConfirmText(mConfirmText);
    }

    /**
     * 设置显示loading
     * @return
     */
    public CommonAlertDialog showProgress()  {
            mProgressFrame.setVisibility(View.VISIBLE);
            mConfirmButton.setVisibility(View.GONE);
        return this;
    }

    /**
     * 设置title
     * @param text
     * @return
     */
    public CommonAlertDialog setTitleText (String text) {
        mTitleText = text;
        if (mTitleTextView != null && mTitleText != null) {
            mTitleTextView.setText(mTitleText);
        }
        return this;
    }

    /**
     * 设置内容文字
     * @param text
     * @return
     */
    public CommonAlertDialog setContentText (String text) {
        mContentText = text;
        if (mContentTextView != null && mContentText != null) {
            showContentText(true);
            mContentTextView.setText(mContentText);
        }
        return this;
    }

    /**
     * 设置显示内容区域
     * @param isShow
     * @return
     */
    public CommonAlertDialog showContentText (boolean isShow) {
        mShowContent = isShow;
        if (mContentTextView != null) {
            mContentTextView.setVisibility(mShowContent ? View.VISIBLE : View.GONE);
        }
        return this;
    }

    /**
     * 设置取消按钮的文字显示
     * @param text
     * @return
     */
    public CommonAlertDialog setCancelText (String text) {
        mCancelText = text;
        if (mCancelButton != null && mCancelText != null) {
            showCancelButton(true);
            mCancelButton.setText(mCancelText);
        }
        return this;
    }

    /**
     * 设置是否显示取消按钮
     * @param isShow
     * @return
     */
    public CommonAlertDialog showCancelButton (boolean isShow) {
        mShowCancel = isShow;
        if (mCancelButton != null) {
            mCancelButton.setVisibility(mShowCancel ? View.VISIBLE : View.GONE);
        }
        return this;
    }


    /**
     * 设置确定按钮的文字
     * @param text
     * @return
     */
    public CommonAlertDialog setConfirmText (String text) {
        mConfirmText = text;
        if (mConfirmButton != null && mConfirmText != null) {
            mConfirmButton.setText(mConfirmText);
        }
        return this;
    }

    /**
     * 设置自定义图片drawable
     * @param drawable
     * @return
     */
    public CommonAlertDialog setCustomImage (Drawable drawable) {
        mCustomImgDrawable = drawable;
        if (mCustomImage != null && mCustomImgDrawable != null) {
            mCustomImage.setVisibility(View.VISIBLE);
            mCustomImage.setImageDrawable(mCustomImgDrawable);
        }
        return this;
    }

    /**
     * 设置自定义图片 resourceId
     * @param resourceId
     * @return
     */
    public CommonAlertDialog setCustomImage (int resourceId) {
        return setCustomImage(getContext().getResources().getDrawable(resourceId));
    }


    /**
     * 设置取消按钮的点击事件
     * @param listener
     * @return
     */
    public CommonAlertDialog setCancelClickListener (OnCommonClickListener listener) {
        mCancelClickListener = listener;
        return this;
    }

    /**
     * 设置确定按钮的点击事件
     * @param listener
     * @return
     */
    public CommonAlertDialog setConfirmClickListener (OnCommonClickListener listener) {
        mConfirmClickListener = listener;
        return this;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.common_alert_dialog_cancel_button) {
            if (mCancelClickListener != null) {
                mCancelClickListener.onClick(CommonAlertDialog.this);
            } else {
                CommonAlertDialog.super.cancel();
            }
        } else if (v.getId() == R.id.common_alert_dialog_confirm_button) {
            if (mConfirmClickListener != null) {
                mConfirmClickListener.onClick(CommonAlertDialog.this);
            } else {
                CommonAlertDialog.super.cancel();
            }
        }
    }
}
