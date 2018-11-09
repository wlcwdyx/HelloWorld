package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.helloworld.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * activity生命周期学习
 * 链接；面试 - 一个帖子学会...
 *
 * 启动（startActivity）；onCreate、onStart、onResume
 * 转后台（不销毁跳转到另外的activity、Home键）；onPause、onSaveInstanceState、onStop
 * 转前台（Home后重新打开、不销毁跳转后Back）；onRestart、onStart、onResume
 * 关闭（finish） ；onPause、onStop、onDestroy
 *
 */

public class TestOneActivity extends Activity {

    @BindView(R.id.testone_tv1)
    TextView testoneTv1;
    @BindView(R.id.testone_btn1)
    Button testoneBtn1;
    @BindView(R.id.testone_btn2)
    Button testoneBtn2;

    //    private String TAG = this.getLocalClassName();
    private String TAG = "TestOneActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testone);
        ButterKnife.bind(this);

        Log.i(TAG, "onCreate");

        testoneTv1.setText(
                "启动方式；standard、singleTop、singleTask、singleInstance\n\n" +
                "状态；活动的、暂停、停止、待用\n\n" +
                "启动（startActivity）；onCreate、onStart、onResume\n" +
                "转后台（不销毁跳转到另外的activity、Home键）；onPause、onSaveInstanceState、onStop\n" +
                "转前台（Home后重新打开、不销毁跳转后Back）；onRestart、onStart、onResume\n" +
                "关闭（finish） ；onPause、onStop、onDestroy");

    }

    @OnClick({R.id.testone_btn1, R.id.testone_btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.testone_btn1:
                startActivity(new Intent(TestOneActivity.this, TestTwoActivity.class));
                break;
            case R.id.testone_btn2:
                startActivity(new Intent(TestOneActivity.this, TestTwoActivity.class));
                TestOneActivity.this.finish();
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    /**
     * 返回键监听
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    /**
     * 按键监听
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                break;
            default:
        }
        return super.onKeyDown(keyCode, event);
    }

}
