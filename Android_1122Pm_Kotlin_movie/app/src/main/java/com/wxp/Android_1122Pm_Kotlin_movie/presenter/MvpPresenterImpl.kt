package com.wxp.Android_1122Pm_Kotlin_movie.presenter

import android.content.Context
import android.util.Log
import com.wxp.Android_1122Pm_Kotlin_movie.base.BasePresenter
import com.wxp.Android_1122Pm_Kotlin_movie.bean.Msg
import com.wxp.Android_1122Pm_Kotlin_movie.bean.ShouyeBean
import com.wxp.Android_1122Pm_Kotlin_movie.model.MvpModel
import com.wxp.Android_1122Pm_Kotlin_movie.model.MvpModelImpl
import com.wxp.Android_1122Pm_Kotlin_movie.view.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/** 类的用途
 *  @author weixiaopeng
 *  @date 2017/11/21 16:05
 */
class MvpPresenterImpl(): BasePresenter<MainView>() {

    var model: MvpModel? = null

    fun ConnectMGetData(context: Context,num:String) {
        model = MvpModelImpl()
        val flowable = model?.getServerData(context,num)
        flowable?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { msg: Msg ->
                        view?.setData(msg)
                }
    }

}