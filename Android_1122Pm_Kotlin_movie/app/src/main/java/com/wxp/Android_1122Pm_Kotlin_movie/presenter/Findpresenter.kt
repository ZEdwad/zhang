package com.wxp.Android_1122Pm_Kotlin_movie.presenter

import android.content.Context
import android.util.Log
import com.wxp.Android_1122Pm_Kotlin_movie.base.BasePresenter
import com.wxp.Android_1122Pm_Kotlin_movie.bean.Find
import com.wxp.Android_1122Pm_Kotlin_movie.bean.Msg
import com.wxp.Android_1122Pm_Kotlin_movie.model.MvpModelImpl
import com.wxp.Android_1122Pm_Kotlin_movie.view.Findview
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * dell 孙劲雄
 *2017/11/23
 *8:23
 */
class Findpresenter: BasePresenter<Findview>() {

    private val model:MvpModelImpl
    init {
        model= MvpModelImpl();
    }

    fun find(context: Context)
    {
        val mo=model?.find(context)
        mo?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { find:List<Find> ->
                   view?.find(find)
                }
    }


}