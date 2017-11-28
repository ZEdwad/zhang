package com.wxp.Android_1122Pm_Kotlin_movie.view

import com.wxp.Android_1122Pm_Kotlin_movie.bean.ShouyeBean

/** 类的用途
 *  @author weixiaopeng
 *  @date 2017/11/23 11:56
 */
interface ShouyeView {

    // 给首页赋值
    fun setShouyeData(s: ShouyeBean.Bean)
    // 给首页+赋值
    fun setShouyeNextData(s: ShouyeBean.Bean)
}