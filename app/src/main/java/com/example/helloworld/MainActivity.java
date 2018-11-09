package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.activity.TestOneActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建项目时报错；com.android.tools.aapt2.Aapt2Exception
 * 解决办法；在project下的gradle.properties中添加一行代码 android.enableAapt2=false
 */

/**
 * 启动项目时报错；Resolved versions for app (26.1.0) and test app (27.1.1) differ.
 * 解决办法；
 * 1，临时解决；Rebulid Project
 * 2，彻底解决；在app下的build.gradle的dependencies下添加一段话：
 * configurations.all {
 * resolutionStrategy.force 'com.android.support:support-annotations:26.1.0'
 * }
 */

/*
AppcompaActivity其实就是ActionBarActivity
但是在compile ‘com.android.support:appcompat-v7:26.1.0’包下没有ActionBarActivity这个类了。

去掉AppcompaActivity的标题栏方法：
if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }

总结一下：AppcompaActivity相对于Activity的主要的两点变化；
1：主界面带有toolbar的标题栏；
2，theme主题只能用android:theme=”@style/AppTheme （appTheme主题或者其子类），而不能用android:style，否则会提示错误：
Caused by: java.lang.IllegalStateException: You need to use a Theme.AppCompat theme (or descendant) with this activity.
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.app_main_lv)
    ListView appMainLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Butterknife使用方法；右键activity_main → 点击Generate → 点击Generate Butterknife...
        ButterKnife.bind(this);

        setListener();
        setAdapter();
    }

    private void setAdapter() {

        ArrayList<String> datas = new ArrayList<>();
        datas.add("handle");
        datas.add("activity");

        appMainLv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas));

    }

    private void setListener() {
        appMainLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
//                        Toast.makeText(MainActivity.this, position + "", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, AppHandleActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, TestOneActivity.class));
                        break;
                }
            }
        });
    }


}
