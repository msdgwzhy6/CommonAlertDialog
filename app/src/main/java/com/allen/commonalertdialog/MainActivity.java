package com.allen.commonalertdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.allen.commonalertdialog.dialogview.CommonAlertDialog;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CommonAlertDialog(MainActivity.this)
                        .setTitleText("只有标题的dialog")
                        .setConfirmText("确定")
                        .show();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CommonAlertDialog(MainActivity.this)
                        .setTitleText("温馨提示")
                        .setContentText("这是内容部分这是内容部分这是内容部分这是内容部分这是内容部分")
                        .setCancelText("取消")
                        .setConfirmText("确定")
                        .setCancelClickListener(new CommonAlertDialog.OnCommonClickListener() {
                            @Override
                            public void onClick(CommonAlertDialog commonAlertDialog) {
                                commonAlertDialog.dismiss();
                                Toast.makeText(MainActivity.this, "点击了取消按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setConfirmClickListener(new CommonAlertDialog.OnCommonClickListener() {
                            @Override
                            public void onClick(CommonAlertDialog commonAlertDialog) {
                                Toast.makeText(MainActivity.this, "点击了确定按钮", Toast.LENGTH_SHORT).show();
                                commonAlertDialog.dismiss();
                            }
                        })
                        .setCustomImage(R.mipmap.ic_launcher)
                        .show();

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CommonAlertDialog(MainActivity.this)
                        .setTitleText("这是title")
                        .setContentText("内容部分内容部分内容部分内容部分内容部分内容部分")
                        .setCancelText("取消")
                        .setConfirmText("确定")
                        .setCustomImage(R.mipmap.ic_launcher)
                        .show();

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CommonAlertDialog(MainActivity.this)
                        .showProgress()
                        .setTitleText("正在加载...")
                        .show();
            }
        });
    }
}
