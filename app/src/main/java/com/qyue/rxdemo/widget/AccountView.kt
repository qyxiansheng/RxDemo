package com.qyue.rxdemo.widget

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.qyue.rxdemo.R

//在有默认参数值的方法中使用@JvmOverloads注解，则Kotlin就会暴露多个重载方法。
class AccountView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : @JvmOverloads LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var tip: TextView
    private lateinit var input: EditText
    private lateinit var clear: ImageView

    init {
        if (attrs != null) {
            init(context, attrs)
        }
    }

    private fun init(context: Context, attrs: AttributeSet) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //获取自定义属性
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.AccountView);
        var av_tip_text = typedArray.getText(R.styleable.AccountView_av_tip_text);
        var av_tip_textColor = typedArray.getColor(R.styleable.AccountView_av_tip_textColor,Color.WHITE);
        var av_tip_textSize = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_tip_textSize,14);
        var av_tip_marginLeft = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_tip_marginLeft,0);
        var av_tip_marginRight = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_tip_marginRight,0);

    }

}