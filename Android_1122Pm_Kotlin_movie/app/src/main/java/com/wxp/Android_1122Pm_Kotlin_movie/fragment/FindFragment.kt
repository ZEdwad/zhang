package com.wxp.Android_1122Pm_Kotlin_movie.fragment
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wxp.Android_1122Pm_Kotlin_movie.R
import com.wxp.Android_1122Pm_Kotlin_movie.activity.FindActivity
import com.wxp.Android_1122Pm_Kotlin_movie.activity.MainActivity
import com.wxp.Android_1122Pm_Kotlin_movie.adapter.FindFragmentadapter
import com.wxp.Android_1122Pm_Kotlin_movie.base.BaseFragment
import com.wxp.Android_1122Pm_Kotlin_movie.bean.Find
import com.wxp.Android_1122Pm_Kotlin_movie.presenter.Findpresenter
import com.wxp.Android_1122Pm_Kotlin_movie.view.Findview
import kotlinx.android.synthetic.main.find_activity.*

/** 类的用途
 *  @author weixiaopeng
 *  @date 2017/11/22 15:52
 */
class FindFragment: BaseFragment<Findview, Findpresenter>(),Findview {

    var list:List<Find>?=null
    override fun setPresenter(): Findpresenter {

        return Findpresenter()
    }

    var adapter:FindFragmentadapter?=null

    override fun find(find:List<Find>)
    {
        list=find
        adapter= FindFragmentadapter(find,context)
        gv_find.adapter=adapter
        adapter?.notifyDataSetChanged()

    }

    override fun initView() {

        getPresenter()?.find(context)

    }

    override fun initOnClick() {

        gv_find.setOnItemClickListener { parent, view, position, id ->

            var name=list?.get(position)?.name

            var inten:Intent= Intent(context,FindActivity::class.java)

            inten.putExtra("name",name)

            startActivity(inten)

        }

    }
    override fun initData() {

    }

    override fun setLayout(): View {

        return View.inflate(context,R.layout.find_activity,null)
    }


}