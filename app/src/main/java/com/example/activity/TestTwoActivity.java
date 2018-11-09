package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * activity生命周期学习
 * <p>
 * Created by 罗威 on 2018/11/2.
 */

public class TestTwoActivity extends Activity {


    @BindView(R.id.testtwo_btn1)
    Button testtwoBtn1;
    @BindView(R.id.testtwo_btn2)
    Button testtwoBtn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testtwo);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.testtwo_btn1, R.id.testtwo_btn2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.testtwo_btn1:
                startActivity(new Intent(TestTwoActivity.this, TestOneActivity.class));
                break;
            case R.id.testtwo_btn2:
                startActivity(new Intent(TestTwoActivity.this, TestOneActivity.class));
                TestTwoActivity.this.finish();
                break;
        }
    }
}
