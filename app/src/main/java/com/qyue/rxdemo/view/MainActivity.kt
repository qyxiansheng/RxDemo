package com.qyue.rxdemo.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import com.qyue.rxdemo.R
import com.qyue.rxdemo.widget.AccountView

/**
 * <br></br> Description:
 * <br></br> Author: Administrator
 * <br></br> Date: 2019/1/18 0018 下午 4:19
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //        if (getSupportActionBar() != null){
        //            getSupportActionBar().hide();
        //        }
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
