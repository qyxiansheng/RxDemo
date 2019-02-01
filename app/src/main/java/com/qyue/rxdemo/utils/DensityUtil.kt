package com.qyue.rxdemo.utils

import android.content.Context

object  DensityUtil{
     fun dp2px(context: Context,value: Int): Int {
        val v = context.getResources().getDisplayMetrics().density
        return (v * value + 0.5f).toInt()
    }

     fun sp2px(context: Context,value: Float): Float {
        val v = context.getResources().getDisplayMetrics().scaledDensity
        return (v * value + 0.5f)
    }

}