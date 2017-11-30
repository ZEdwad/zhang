package com.wxp.Android_1122Pm_Kotlin_movie.presenter

import android.content.Context
import com.wxp.Android_1122Pm_Kotlin_movie.base.BasePresenter
import com.wxp.Android_1122Pm_Kotlin_movie.bean.HomeBean
import com.wxp.Android_1122Pm_Kotlin_movie.model.MvpModel
import com.wxp.Android_1122Pm_Kotlin_movie.model.MvpModelImpl
import com.wxp.Android_1122Pm_Kotlin_movie.view.ShouyeView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/** 类的用途
 *  @author weixiaopeng
 *  @date 2017/11/23 11:57
 */
class ShouyePrensenterImpl:BasePresenter<ShouyeView>() {

    var model: MvpModel? = null

    // 首页数据
    fun ConnectMGetShouye(context: Context) {
        model = MvpModelImpl()
        val flowable = model?.getShouyeServerData(context,true,"0")

        flowable?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { shouye: HomeBean ->
                    view?.setShouyeData(shouye)
                }
    }

    // 首页+数据
    fun ConnectMGetShouyeNext(context: Context,path:String) {
        model = MvpModelImpl()
        val flowable = model?.getShouyeServerData(context,false,path)

        flowable?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { shouye: HomeBean ->
                    view?.setShouyeData(shouye)
                }
    }

}