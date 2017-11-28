package com.wxp.Android_1122Pm_Kotlin_movie.presenter

import android.content.Context
import com.tt.lvruheng.eyepetizer.mvp.model.bean.HotBean
import com.wxp.Android_1122Pm_Kotlin_movie.base.BasePresenter
import com.wxp.Android_1122Pm_Kotlin_movie.model.MvpModel
import com.wxp.Android_1122Pm_Kotlin_movie.model.MvpModelImpl
import com.wxp.Android_1122Pm_Kotlin_movie.view.HotView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *
 * @author ${张健}
 *
 * @date 2017/11/23/9:20
 *
 */
class HotPresenter : BasePresenter<HotView>() {

    var model: MvpModel

    init {

        this.model=MvpModelImpl()
    }

    fun getHotPresenter(context: Context,strategy: String?){
        val flowable = model?.getHotView(context, 10, strategy!!, "26868b32e808498db32fd51fb422d00175e179df", 83)
        flowable?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { hotbean:HotBean->
                    view?.getHotView(hotbean)
                }

    }


}