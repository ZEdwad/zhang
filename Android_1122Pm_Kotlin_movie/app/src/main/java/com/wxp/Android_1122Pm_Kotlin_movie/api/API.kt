package com.wxp.Android_1122Pm_Kotlin_movie.api

/** 类的用途
 *  @author weixiaopeng
 *  @date 2017/11/21 15:46
 */
class API {

    companion object {
        val path = "http://www.yulin520.com/a2a/forum/"

        //每日精选
         val DAILY="http://baobab.wandoujia.com/api/";
        //发现更多
         val FIND_MORE="http://baobab.wandoujia.com/api/";
        //热门排行
         val HOT_STRATEGY="http://baobab.wandoujia.com/api/";
        //发现更多详情接口
         val FIND_DETAIL="http://baobab.wandoujia.com/api/v3/videos?categoryName=%s&strategy=%s&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83";
        //搜索关键字
         val SEARCH_RELATED = "http://baobab.kaiyanapp.com/api/v1/search?num=10&query=%E4%BD%A0&start=10"

    }

}