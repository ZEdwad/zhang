package com.wxp.Android_1122Pm_Kotlin_movie.api

import com.tt.lvruheng.eyepetizer.mvp.model.bean.HotBean
import com.wxp.Android_1122Pm_Kotlin_movie.bean.Find
import com.wxp.Android_1122Pm_Kotlin_movie.bean.HomeBean
import com.wxp.Android_1122Pm_Kotlin_movie.bean.Msg
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/** 类的用途
 *  @author weixiaopeng
 *  @date 2017/11/21 16:10
 */
interface RetrofitService {

    //首页数据
    @GET("v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun getHomeData(): Flowable<HomeBean>

    //获取首页第一页之后的数据  ?date=1499043600000&num=2
    @GET("v2/feed")
    fun getHomeMoreData(@Query("date") date :String,@Query("num") num :String) : Flowable<HomeBean>

    //获取发现频道详情信息
    @GET("v3/videos")
    fun getFindDetailData(@Query("categoryName") categoryName :String,@Query("strategy") strategy :String,
                          @Query("udid") udid :String,@Query("vc") vc :Int) : Flowable<HotBean>

    //获取发现详情加载更多消息
    @GET("v3/videos")
    fun getFindDetailMoreData(@Query("start") start :Int,@Query("num") num :Int, @Query("categoryName") categoryName :String,@Query("strategy") strategy :String) : Flowable<HotBean>

    // weixiaopeng
    @GET("allTypeList?sign=376C5BFC22179A1B8FF3A86D4588B29F&pageSize=10&ts=1877785007&forumType=0")
    fun getData(@Query("page") num:String):Flowable<Msg>

    //sunjinxiong
    @GET("v2/categories?udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun Find(): Flowable<List<Find>>


    //获取热门排行信息
    @GET("v3/ranklist")
    fun getHotData(@Query("num") num :Int,@Query("strategy") strategy :String,
                   @Query("udid") udid :String,@Query("vc") vc :Int) : Flowable<HotBean>
}