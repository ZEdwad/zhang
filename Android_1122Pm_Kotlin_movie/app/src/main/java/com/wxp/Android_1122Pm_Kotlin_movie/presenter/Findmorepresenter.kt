package com.wxp.Android_1122Pm_Kotlin_movie.presenter

import android.content.Context
import com.tt.lvruheng.eyepetizer.mvp.model.bean.HotBean
import com.wxp.Android_1122Pm_Kotlin_movie.base.BasePresenter
import com.wxp.Android_1122Pm_Kotlin_movie.model.MvpModelImpl
import com.wxp.Android_1122Pm_Kotlin_movie.view.Findmoredata
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * dell 孙劲雄
 *2017/11/23
 *19:37
 */
class Findmorepresenter: BasePresenter<Findmoredata>() {

    private val model: MvpModelImpl
    init {
        model= MvpModelImpl();
    }

    fun finddata(context: Context, categoryName: String, strategy: String?){

        var mode = model.Finddata(context, categoryName, strategy)

        mode?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { hot: HotBean ->

                    view?.findmore(hot)

                }
    }
    fun findmore(context: Context, start: Int, categoryName: String, strategy: String?)
    {
        var mode = model.Findmoredata(context, start, categoryName,strategy)

        mode?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { hot: HotBean ->

                    view?.findmore(hot)

                }

    }



}