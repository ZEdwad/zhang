package com.wxp.Android_1122Pm_Kotlin_movie.base

import android.util.Log
import java.lang.ref.WeakReference

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * 类的用途
 *
 * @author weixiaopeng
 * @date 2017/11/2 20:53
 */

open class BasePresenter<V> {

    private var disposable: CompositeDisposable? = null
    private var weakReference: WeakReference<V>? = null

    open val view: V?
            get() = if (weakReference?.get() != null) weakReference!!.get() else null

    init {
        disposable = CompositeDisposable()
    }

    fun createView(mView: V) {
        weakReference = WeakReference<V>(mView)
    }

    fun addDisposable(d: Disposable?) {
        if (d != null) {
            disposable!!.add(d)
        }
    }

    fun disposableDestory() {
        if (disposable!!.size() > 0) {
            disposable!!.dispose()
        }

        if (weakReference != null) {
            weakReference!!.clear()
            weakReference = null
        }

    }
}
