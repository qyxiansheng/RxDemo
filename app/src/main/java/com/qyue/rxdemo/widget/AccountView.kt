package com.qyue.rxdemo.widget

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.text.InputFilter
import android.text.TextUtils
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
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

    private var av_panel_width: Int = 0
    private var av_panel_height: Int = 0

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
    private var av_input_width: Int = 0
    private var av_input_height: Int = 0

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

    private val DEFAULT_WIDTH = 200
    private val DEFAULT_HEIGHT = 400

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
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.AccountView, defStyleAttr, 0);

        av_panel_width = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_panel_width, 0)
        av_panel_height = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_panel_height, 0)

        if (TextUtils.isEmpty(typedArray.getString(R.styleable.AccountView_av_tip_text))) {
            av_tip_text = ""
        } else {
            av_tip_text = typedArray.getString(R.styleable.AccountView_av_tip_text);
        }
        av_tip_textColor = typedArray.getColor(R.styleable.AccountView_av_tip_textColor, Color.WHITE);
        av_tip_textSize = typedArray.getDimension(R.styleable.AccountView_av_tip_textSize, DensityUtil.sp2px(mContext,14.0f));
        av_tip_marginLeft = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_tip_marginLeft, 10);
        av_tip_marginRight = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_tip_marginRight, 10);

        if (TextUtils.isEmpty(typedArray.getString(R.styleable.AccountView_av_input_text))) {
            av_input_text = ""
        } else {
            av_input_text = typedArray.getString(R.styleable.AccountView_av_input_text)
        }
        av_input_textColor = typedArray.getColor(R.styleable.AccountView_av_input_textColor, Color.WHITE);
        av_input_textSize = typedArray.getDimension(R.styleable.AccountView_av_input_textSize, 14f);
        av_input_marginLeft = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_input_marginLeft, 0);
        av_input_marginRight = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_input_marginRight, 0);
        if (TextUtils.isEmpty(typedArray.getString(R.styleable.AccountView_av_input_hint))) {
            av_input_hint = ""
        } else {
            av_input_hint = typedArray.getString(R.styleable.AccountView_av_input_hint);
        }
        av_input_maxLength = typedArray.getInt(R.styleable.AccountView_av_input_maxLength, -1);
        av_input_width = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_input_width, WindowManager.LayoutParams.MATCH_PARENT);
        av_input_height = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_input_height, WindowManager.LayoutParams.MATCH_PARENT);

        av_clear_mipmap = typedArray.getResourceId(R.styleable.AccountView_av_clear_mipmap, R.drawable.login_account_clear);
        av_clear_drawable = typedArray.getResourceId(R.styleable.AccountView_av_clear_drawable, R.drawable.login_account_clear);
        av_clear_background = typedArray.getResourceId(R.styleable.AccountView_av_clear_background, R.drawable.login_account_clear);
        av_clear_width = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_clear_width, WindowManager.LayoutParams.WRAP_CONTENT);
        av_clear_height = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_clear_height, WindowManager.LayoutParams.MATCH_PARENT);
        av_clear_marginTop = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_clear_marginTop, 0);
        av_clear_marginBottom = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_clear_marginBottom, 0);
        av_clear_marginRight = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_clear_marginRight, 10);
        av_clear_padding = typedArray.getDimensionPixelSize(R.styleable.AccountView_av_clear_padding, 0);

        typedArray.recycle()
    }

    /**
     * 当View中所有的子控件均映射成XML后触发
     */
    override fun onFinishInflate() {
        super.onFinishInflate()
        panel = findViewById(R.id.ll_account_panel)
        tip = findViewById(R.id.tv_account_tip)
        input = findViewById(R.id.et_account_input)
        clear = findViewById(R.id.iv_account_clear)

        //组合件（login_account.xml）ll_account_panel外层宽度必须是MATCH_PARENT才能充满整个控件，
        // 不然account_view即使设置了MATCH_PARENT，组合件的内容（三个控件的呈现）也无法充满整个控件
        //查看login_account.xml的et_account_input即可反应此现象
        var panel_lp = LayoutParams(input.getLayoutParams())
        panel_lp.width = WindowManager.LayoutParams.MATCH_PARENT
        panel_lp.height = WindowManager.LayoutParams.MATCH_PARENT
        panel.layoutParams = panel_lp

        tip.text = av_tip_text
        tip.setTextColor(av_tip_textColor)
        //TODO 不能只是通过再调用setTextSize方法设置字体大小，必须使用paint方法得到mTextPaint，再调用setTextSize设置字体大小，不然字体大小会出现字体大小异常（偏大,获取的是sp值）
        //不可以这样用tip.textSize = av_tip_textSize，应该选择以下两种方式之一：
        tip.paint.textSize = av_tip_textSize
//        tip.setTextSize(TypedValue.COMPLEX_UNIT_PX, av_tip_textSize)
        var tip_lp = LayoutParams(tip.layoutParams)
        tip_lp.setMargins(DensityUtil.dp2px(mContext, av_tip_marginLeft), 0, DensityUtil.dp2px(mContext, av_tip_marginRight), 0);
        tip.layoutParams = tip_lp

        input.setText(av_input_text)
        input.setTextColor(av_input_textColor)
        input.hint = av_input_hint
        //TODO EditText可直接设置字体大小，无需调用上面TextView的两种方式，原因待查明
        input.textSize = av_input_textSize
        var input_lp = LayoutParams(input.layoutParams)

        input_lp.setMargins(av_input_marginLeft, 0, av_input_marginRight, 0);
        input_lp.width = WindowManager.LayoutParams.MATCH_PARENT
        input_lp.height = WindowManager.LayoutParams.MATCH_PARENT
        input_lp.weight = 1.0f//设置权重，不然后面的clear按钮会被撑出屏幕外
        input.filters = arrayOf(InputFilter.LengthFilter(av_input_maxLength))
        input.layoutParams = input_lp

        clear.setImageBitmap(BitmapFactory.decodeResource(this.resources, av_clear_mipmap))
        clear.setImageBitmap(BitmapFactory.decodeResource(this.resources, av_clear_drawable))
        clear.setImageBitmap(BitmapFactory.decodeResource(this.resources, av_clear_background))
        var clear_lp = LayoutParams(input.getLayoutParams())
        clear_lp.width = av_clear_width
        clear_lp.height = av_clear_height
        clear_lp.gravity = Gravity.CENTER
        clear_lp.setMargins(0, DensityUtil.dp2px(mContext, av_clear_marginTop), DensityUtil.dp2px(mContext, av_clear_marginRight), DensityUtil.dp2px(mContext, av_clear_marginBottom))
        clear.setPadding(DensityUtil.dp2px(mContext, av_clear_padding), DensityUtil.dp2px(mContext, av_clear_padding), DensityUtil.dp2px(mContext, av_clear_padding), DensityUtil.dp2px(mContext, av_clear_padding))
        clear.layoutParams = clear_lp
    }


}