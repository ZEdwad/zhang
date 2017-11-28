package com.wxp.Android_1122Pm_Kotlin_movie.base

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * 类的用途
 *
 * @author weixiaopeng
 * @date 2017/11/2 18:45
 */

abstract class BaseFragment<V, T : BasePresenter<V>> : Fragment() {

    protected lateinit var mPresenter: T
    protected var mContext: Activity? = null

    protected abstract fun setPresenter(): T

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mPresenter = setPresenter()
        mPresenter.createView(this as V)

        return setLayout()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        initData()
        initOnClick()
    }

    protected abstract fun initView()

    protected abstract fun initOnClick()

    protected abstract fun initData()

    protected abstract fun setLayout(): View

    fun getPresenter(): T? {
        return if (mPresenter != null) mPresenter else null
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}