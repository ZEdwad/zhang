package com.wxp.Android_1122Pm_Kotlin_movie.model

import android.content.Context
import com.tt.lvruheng.eyepetizer.mvp.model.bean.HotBean
import com.wxp.Android_1122Pm_Kotlin_movie.bean.Find
import com.wxp.Android_1122Pm_Kotlin_movie.bean.HomeBean
import com.wxp.Android_1122Pm_Kotlin_movie.bean.Msg
import io.reactivex.Flowable

/** 类的用途
 *  @author weixiaopeng
 *  @date 2017/11/21 16:01
 */
interface MvpModel {

    // 请求网络数据
    fun getServerData(context: Context,num:String):Flowable<Msg>?

    // 请求首页网络数据
    fun getShouyeServerData(context: Context,isFirst: Boolean,data: String?):Flowable<HomeBean>?

    //发现详情更多
     fun Findmoredata(context: Context, start: Int, categoryName: String, strategy: String?): Flowable<HotBean>?

    //发现详情
      fun Finddata(context: Context, categoryName: String, strategy: String?): Flowable<HotBean>?

    //发现详情
    fun find(context: Context): Flowable<List<Find>>?

    //热门排行
    fun getHotView(context: Context,num: Int, strategy: String?,uid: String,start: Int): Flowable<HotBean>?






}