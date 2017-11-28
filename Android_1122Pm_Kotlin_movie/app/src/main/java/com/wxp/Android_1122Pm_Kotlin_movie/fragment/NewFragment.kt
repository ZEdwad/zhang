package com.wxp.Android_1122Pm_Kotlin_movie.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import com.tt.lvruheng.eyepetizer.mvp.model.bean.HotBean
import com.wxp.Android_1122Pm_Kotlin_movie.R
import com.wxp.Android_1122Pm_Kotlin_movie.adapter.RankAdapter
import com.wxp.Android_1122Pm_Kotlin_movie.base.BaseFragment
import com.wxp.Android_1122Pm_Kotlin_movie.presenter.HotPresenter
import com.wxp.Android_1122Pm_Kotlin_movie.view.HotView
import kotlinx.android.synthetic.main.week_activity.*

/**
 * 1.类的用途
 * 2.@author 123
 * 3.@date 2017/11/23 09 :04
 */
class NewFragment : BaseFragment<HotView, HotPresenter>(),HotView {


    lateinit var path: String
    lateinit var adadpter:RankAdapter
    var mList: ArrayList<HotBean.ItemListBean.DataBean> = ArrayList()

    override fun setPresenter(): HotPresenter {
        return HotPresenter()
    }

    override fun initView() {
        recyclerView.layoutManager=LinearLayoutManager(context)
        adadpter=RankAdapter(context,mList)
        recyclerView.adapter=adadpter
    }

    override fun initOnClick() {
    }

    override fun initData() {
        path=arguments.getString("path")
        getPresenter()?.getHotPresenter(context,path)
        Toast.makeText(context,path,Toast.LENGTH_LONG).show()
    }

    override fun setLayout(): View {
        return View.inflate(context, R.layout.week_activity,null)
    }


    companion object {
        fun newInstanc(path: String): Fragment {
            val fragment = NewFragment()
            val bundle = Bundle()
            bundle.putString("path", path)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getHotView(hotBean: HotBean) {

        Log.i("rrr",hotBean.toString())
        if(mList.size>0){
            mList.clear()
        }
        hotBean.itemList?.forEach {

            it.data?.let {
                it1->mList.add(it1)
            }
        }

        adadpter.notifyDataSetChanged()
    }


}