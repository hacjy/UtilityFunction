package com.ha.cjy.utilityfunction;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * 首页
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnAppBarLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findControl();
        initControl();
    }

    private void findControl(){
        mBtnAppBarLayout = (Button)findViewById(R.id.btn_appbarlayout);
    }

    private void initControl(){
        mBtnAppBarLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_appbarlayout:{
                Intent intent = new Intent(MainActivity.this,CollapsingToolbarLayoutActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
