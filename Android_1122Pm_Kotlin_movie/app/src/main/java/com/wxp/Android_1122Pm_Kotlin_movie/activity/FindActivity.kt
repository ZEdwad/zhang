package com.wxp.Android_1122Pm_Kotlin_movie.activity

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.tt.lvruheng.eyepetizer.mvp.model.bean.HotBean
import com.wxp.Android_1122Pm_Kotlin_movie.R
import com.wxp.Android_1122Pm_Kotlin_movie.adapter.FindMoreadapter
import com.wxp.Android_1122Pm_Kotlin_movie.base.BaseActivity
import com.wxp.Android_1122Pm_Kotlin_movie.presenter.Findmorepresenter
import com.wxp.Android_1122Pm_Kotlin_movie.view.Findmoredata
import kotlinx.android.synthetic.main.activity_find.*

class FindActivity : BaseActivity<Findmoredata, Findmorepresenter>(),Findmoredata {

    var adapterr: FindMoreadapter?=null

    override fun findmore(hotBean: HotBean) {


        Log.e("XX",hotBean.count.toString())

        adapterr=FindMoreadapter(this,hotBean)

        recyclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        recyclerView.adapter


    }
    lateinit var name: String
    override val layoutResId: Int
        get() = R.layout.activity_find

    override fun setPresenter(): Findmorepresenter {

        return Findmorepresenter()
    }
    override fun initData() {
        setToolbar()
        getPresenter()?.finddata(this,"时尚","date");

    }
    private fun setToolbar() {
        setSupportActionBar(toolbar)
        var bar = supportActionBar
        intent.getStringExtra("name")?.let {
            name = intent.getStringExtra("name")
            bar?.title = name
        }
        bar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}
