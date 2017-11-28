package com.wxp.Android_1122Pm_Kotlin_movie.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wxp.Android_1122Pm_Kotlin_movie.R


/**
 * 类的用途
 *
 * @author weixiaopeng
 * @date 2017/10/31 18:04
 */

abstract class BaseActivity<V, T : BasePresenter<V>> : AppCompatActivity(), InitUtils {

    private var presenter: T? = null

    abstract val layoutResId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme);
        setContentView(layoutResId)
        presenter = setPresenter()
        presenter!!.createView(this as V)
        initView()
        initData()
        initListener()
    }

    protected abstract fun setPresenter(): T

    fun getPresenter(): T? {
        return if (presenter != null) presenter else null
    }

    override fun initView() {

    }

    override fun initData() {

    }

    override fun initListener() {

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.disposableDestory()
    }
}


