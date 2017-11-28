package com.wxp.Android_1122Pm_Kotlin_movie.bean

/** 类的用途
 *  @author weixiaopeng
 *  @date 2017/11/21 15:54
 */
class User {

    var title:String? = null
    var userName:String? = null
    var headImg:String? = null
    var content:String? = null

    constructor(title: String?, userName: String?, headImg: String?, content: String?) {
        this.title = title
        this.userName = userName
        this.headImg = headImg
        this.content = content
    }
}