package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppHandleActivity extends Activity {

    @BindView(R.id.app_handle_btn)
    Button appHandleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_handle);
        ButterKnife.bind(this);

        setListener();
    }

    Handler mHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            appHandleBtn.setText(String.valueOf(msg.what));
            if (msg.what > 0) {
                mHandle.sendEmptyMessageDelayed(msg.what - 1, 1000);
            }

        }
    };

    private void setListener() {

        appHandleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Message message = new Message();
                message.what = 10;
                mHandle.sendMessage(message);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandle.removeCallbacksAndMessages(null);
    }
}
