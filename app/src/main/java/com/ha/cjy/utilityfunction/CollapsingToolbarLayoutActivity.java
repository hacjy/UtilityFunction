package com.ha.cjy.utilityfunction;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * CollapsingToolbarLayout实现上滑隐藏ToolBar
 * Created by cjy on 17/11/21.
 */

public class CollapsingToolbarLayoutActivity extends AppCompatActivity implements View.OnClickListener {
    private AppBarLayout mAppBarLayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolBar;
    private TextView mTvTitle;
    private TextView mTvTime;
    private TextView mTvContent;
    private TextView mTvShare;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_appbarlayout);

        findControl();
        initControl();
    }


    public void findControl() {
        mAppBarLayout = (AppBarLayout) findViewById(R.id.appbar_layout);
        mCollapsingToolbarLayout  = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mToolBar = (Toolbar) mCollapsingToolbarLayout.findViewById(R.id.tool_bar);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvTime = (TextView) findViewById(R.id.tv_time);
        mTvContent = (TextView) findViewById(R.id.tv_content);
        mTvShare = (TextView) findViewById(R.id.tv_share);

        //这句话要加，不然底部滚动文本会显示不全
        setSupportActionBar(mToolBar);
    }

    public void initControl() {
        //监听展开折叠状态
        mAppBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if( state == State.EXPANDED ) {//展开状态
                    //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
                    mCollapsingToolbarLayout.setTitle("展开状态的标题");
                }else if(state == State.COLLAPSED){//折叠状态
                    mCollapsingToolbarLayout.setTitle("详情");
                }else {//中间状态
                    mCollapsingToolbarLayout.setTitle("");
                }
            }
        });
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTvShare.setOnClickListener(this);

        refreshUI();
    }

    private void refreshUI() {
        mTvTitle.setText(getString(R.string.txt_appbarlayout));
        mTvTime.setText(getString(R.string.txt_time, "2017-11-21","2017-12-11"));
        mTvContent.setText(getString(R.string.txt_content));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_share:{
                Toast.makeText(this,"分享一次",Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}
