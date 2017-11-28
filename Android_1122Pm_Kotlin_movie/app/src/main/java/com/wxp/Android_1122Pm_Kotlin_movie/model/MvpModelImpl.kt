package com.wxp.Android_1122Pm_Kotlin_movie.model

import android.content.Context
import com.tt.lvruheng.eyepetizer.mvp.model.bean.HotBean
import com.tt.lvruheng.eyepetizer.network.RetrofitClient
import com.wxp.Android_1122Pm_Kotlin_movie.api.API
import com.wxp.Android_1122Pm_Kotlin_movie.api.RetrofitService
import com.wxp.Android_1122Pm_Kotlin_movie.bean.Find
import com.wxp.Android_1122Pm_Kotlin_movie.bean.Msg
import com.wxp.Android_1122Pm_Kotlin_movie.bean.ShouyeBean
import io.reactivex.Flowable

/** 类的用途
 *  @author weixiaopeng
 *  @date 2017/11/21 16:05
 */
class MvpModelImpl():MvpModel {

    //热门
    override fun getHotView(context: Context, num: Int, strategy: String?, uid: String, start: Int): Flowable<HotBean>? {
        val flowable = RetrofitClient.getInstance(context,API.HOT_STRATEGY).create(RetrofitService::class.java)?.getHotData(num, strategy!!, uid, start)
        return flowable
    }

    //发现详情更多
    override fun Findmoredata(context: Context, start: Int, categoryName: String, strategy: String?): Flowable<HotBean>? {

        var floable=RetrofitClient.getInstance(context,API.FIND_MORE).create(RetrofitService::class.java)?.getFindDetailMoreData(start,10,categoryName, strategy!!)
        return floable
    }
    //发现详情
    override fun Finddata(context: Context, categoryName: String, strategy: String?): Flowable<HotBean>? {

        var floable=RetrofitClient.getInstance(context,API.FIND_MORE).create(RetrofitService::class.java)?.getFindDetailData(categoryName, strategy!!, "26868b32e808498db32fd51fb422d00175e179df", 83)
        return floable
    }

    //发现
    override fun find(context: Context): Flowable<List<Find>>? {

        var floable=RetrofitClient.getInstance(context,API.FIND_MORE).create(RetrofitService::class.java)?.Find()

        return floable
    }


    override fun getShouyeNextServerData(context: Context): Flowable<ShouyeBean.Bean>? {
        val flowable = RetrofitClient.getInstance(context, API.DAILY).create(RetrofitService::class.java)?.ShouyeNextData()
        return flowable
    }

    // 首页数据
    override fun getShouyeServerData(context: Context, num: String): Flowable<ShouyeBean.Bean>? {
        val flowable = RetrofitClient.getInstance(context, API.DAILY).create(RetrofitService::class.java)?.ShouyeData(num)
        return flowable
    }

    override fun getServerData(context: Context,num:String): Flowable<Msg>? {
        val flowable = RetrofitClient.getInstance(context, API.path).create(RetrofitService::class.java)?.getData(num)
        return flowable
    }

}