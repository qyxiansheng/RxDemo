package com.qyue.rxdemo.widget

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.annotation.Dimension
import android.text.InputFilter
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.qyue.rxdemo.R
import com.qyue.rxdemo.utils.DensityUtil

//在有默认参数值的方法中使用@JvmOverloads注解，则Kotlin就会暴露多个重载方法。
class AccountView : @JvmOverloads LinearLayout {

    private lateinit var panel: LinearLayout
    private lateinit var tip: TextView
    private lateinit var input: EditText
    private lateinit var clear: ImageView

    private var av_tip_text: String = ""
    private var av_tip_textColor: Int = 0
    private var av_tip_textSize: Float = 0.0f
    private var av_tip_marginLeft: Int = 0
    private var av_tip_marginRight: Int = 0
    private var av_input_text: String = ""
    private var av_input_textColor: Int = 0
    private var av_input_textSize: Float = 0.0F
    private var av_input_marginLeft: Int = 0
    private var av_input_marginRight: Int = 0
    private var av_input_hint: String = ""
    private var av_input_maxLength: Int = 0
    private var av_clear_mipmap: Int = 0
    private var av_clear_drawable: Int = 0
    private var av_clear_background: Int = 0
    private var av_clear_width: Int = 0
    private var av_clear_height: Int = 0
    private var av_clear_marginTop: Int = 0
    private var av_clear_marginBottom: Int = 0
    private var av_clear_marginRight: Int = 0
    private var av_clear_padding: Int = 0

    private lateinit var mContext: Context
    private var mAttrs: AttributeSet? = null
    private var mDefStyleAttr: Int = 0


    constructor(context: Context) : super(context) {
        mContext = context
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mContext = context
        mAttrs = attrs
        if (mAttrs != null) {
            init(mContext, mAttrs, mDefStyleAttr)
        }
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        mContext = context
        mAttrs = attrs
        mDefStyleAttr = defStyleAttr
        if (mAttrs != null) {
            init(mContext, mAttrs, mDefStyleAttr)
        }
    }


    private fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        LayoutInflater.from(context).inflate(R.layout.login_account, this, true)
        //获取自定义属性
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.AccountView, defStyleAttr, 0); av_tip_text = typedArray.getString(R.styleable.AccountView_av_tip_text);

        av_tip_textColor = typedArray.getColor(R.styleable.AccountView_av_tip_textColor, Color.WHITE);
        av_tip_textSize = typedArray.getDimension(R.styleable.AccountView_av_tip_textSize, 14f);
        av_tip_marginLeft = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_tip_marginLeft, 0);
        av_tip_marginRight = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_tip_marginRight, 0);

        av_input_text = typedArray.getString(R.styleable.AccountView_av_input_text);
        av_input_textColor = typedArray.getColor(R.styleable.AccountView_av_input_textColor, Color.WHITE);
        av_input_textSize = typedArray.getDimension(R.styleable.AccountView_av_input_textSize, 14f);
        av_input_marginLeft = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_input_marginLeft, 0);
        av_input_marginRight = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_input_marginRight, 0);
        av_input_hint = typedArray.getString(R.styleable.AccountView_av_input_hint);
        av_input_maxLength = typedArray.getInt(R.styleable.AccountView_av_input_maxLength, -1);

        av_clear_mipmap = typedArray.getResourceId(R.styleable.AccountView_av_clear_mipmap, R.drawable.login_account_clear);
        av_clear_drawable = typedArray.getResourceId(R.styleable.AccountView_av_clear_drawable, R.drawable.login_account_clear);
        av_clear_background = typedArray.getResourceId(R.styleable.AccountView_av_clear_background, R.drawable.login_account_clear);
        av_clear_width = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_clear_width, 0);
        av_clear_height = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_clear_height, 0);
        av_clear_marginTop = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_clear_marginTop, 0);
        av_clear_marginBottom = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_clear_marginBottom, 0);
        av_clear_marginRight = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_clear_marginRight, 0);
        av_clear_padding = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_clear_padding, 0);

        typedArray.recycle()
    }

    /**
     * 当View中所有的子控件均映射成XML后触发
     */
    override fun onFinishInflate() {
        super.onFinishInflate()
//        panel = LayoutInflater.from(context).inflate(R.layout.login_account, this, true) as LinearLayout;

        tip = findViewById(R.id.tv_account_tip)
        input = findViewById(R.id.et_account_input)
        clear = findViewById(R.id.iv_account_clear)

        tip.setText(av_tip_text)
        tip.setTextColor(av_tip_textColor)
        tip.setTextSize(av_tip_textSize)
        var tip_lp = LayoutParams(tip.getLayoutParams())
        tip_lp.setMargins(av_tip_marginLeft, 0, av_tip_marginRight, 0);
        tip.layoutParams = tip_lp

        input.setText(av_input_text)
        input.setTextColor(av_input_textColor)
        input.textSize = av_input_textSize
        var input_lp = LayoutParams(input.getLayoutParams())
        input_lp.setMargins(av_input_marginLeft, 0, av_input_marginRight, 0);
        input.layoutParams = input_lp
        input.hint = av_input_hint
        input.filters = arrayOf(InputFilter.LengthFilter(av_input_maxLength))

        clear.setImageBitmap(BitmapFactory.decodeResource(this.resources, av_clear_mipmap))
        clear.setImageBitmap(BitmapFactory.decodeResource(this.resources, av_clear_drawable))
        clear.setImageBitmap(BitmapFactory.decodeResource(this.resources, av_clear_background))
        clear.layoutParams.width = av_clear_width
        clear.layoutParams.height = av_clear_height
        var clear_lp = LayoutParams(input.getLayoutParams())
        clear_lp.setMargins(0, av_clear_marginTop, av_clear_marginRight, av_clear_marginBottom);
        clear.setPadding(av_clear_padding, av_clear_padding, av_clear_padding, av_clear_padding)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var hms = heightMeasureSpec
        var height = MeasureSpec.getSize(hms)
        hms = MeasureSpec.makeMeasureSpec(height, MeasureSpec.UNSPECIFIED)
        super.onMeasure(widthMeasureSpec, hms)
    }
}