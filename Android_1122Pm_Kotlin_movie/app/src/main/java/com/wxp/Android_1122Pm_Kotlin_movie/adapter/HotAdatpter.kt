package com.wxp.Android_1122Pm_Kotlin_movie.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.wxp.Android_1122Pm_Kotlin_movie.fragment.NewFragment

/**
 *
 * @author ${张健}
 *
 * @date 2017/11/27/19:12
 *
 */
class HotAdatpter(fm: FragmentManager, titles: Array<String>,mTitles : ArrayList<String>) : FragmentPagerAdapter(fm) {

    var mFm : FragmentManager = fm!!
    var mList : Array<String> = titles
    var mTitles : ArrayList<String> = mTitles

    override fun getPageTitle(position: Int): CharSequence {
        return mTitles[position]
    }

    override fun getItem(position: Int): Fragment {
       return NewFragment.newInstanc(mList[position])
    }

    override fun getCount(): Int {
        return mList.size
    }
}