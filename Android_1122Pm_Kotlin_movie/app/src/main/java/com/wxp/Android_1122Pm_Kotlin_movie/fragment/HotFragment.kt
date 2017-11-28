package com.wxp.Android_1122Pm_Kotlin_movie.fragment

import com.wxp.Android_1122Pm_Kotlin_movie.R
import com.wxp.Android_1122Pm_Kotlin_movie.adapter.HotAdatpter
import kotlinx.android.synthetic.main.hot_activity.*

/** 类的用途
 *  @author weixiaopeng
 *  @date 2017/11/22 15:52
 */
class HotFragment : BaseFragment() {

    var mTabs = ArrayList<String>()
    val STRATEGY = arrayOf("weekly", "monthly", "historical")

    override fun getLayoutResources(): Int {
        return R.layout.hot_activity
    }

    override fun initView() {
       mTabs.add("周排行")
       mTabs.add("月排行")
       mTabs.add("总排行")
        vp_content.adapter = HotAdatpter(fragmentManager, STRATEGY, mTabs)
        tabs.setupWithViewPager(vp_content)
    }





}