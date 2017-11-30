package com.wxp.Android_1122Pm_Kotlin_movie.activity

import android.content.Intent
import android.os.Parcelable
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.tt.lvruheng.eyepetizer.mvp.model.bean.HotBean
import com.wxp.Android_1122Pm_Kotlin_movie.R
import com.wxp.Android_1122Pm_Kotlin_movie.adapter.FindMoreadapter
import com.wxp.Android_1122Pm_Kotlin_movie.base.BaseActivity
import com.wxp.Android_1122Pm_Kotlin_movie.bean.VideoBean
import com.wxp.Android_1122Pm_Kotlin_movie.presenter.Findmorepresenter
import com.wxp.Android_1122Pm_Kotlin_movie.util.OnRecyclerItemClickListener
import com.wxp.Android_1122Pm_Kotlin_movie.view.Findmoredata
import kotlinx.android.synthetic.main.activity_find.*
import kotlinx.android.synthetic.main.shouye_activity.*
import java.util.regex.Pattern

class FindActivity : BaseActivity<Findmoredata, Findmorepresenter>(),Findmoredata, SwipeRefreshLayout.OnRefreshListener  {

    var adapterr: FindMoreadapter?=null
    lateinit var data: String
    var mIsRefresh: Boolean = false
    var mList: ArrayList<HotBean.ItemListBean.DataBean> = ArrayList()
    var mstart: Int = 10
    override fun findmore(hotBean: HotBean) {

        val regEx = "[^0-9]"
        val p = Pattern.compile(regEx)
        val m = p.matcher(hotBean.nextPageUrl as CharSequence?)
        data = m.replaceAll("").subSequence(1, m.replaceAll("").length - 1).toString()
        if (mIsRefresh) {
            mIsRefresh = false
            refreshLayout.isRefreshing = false
            if (mList.size > 0) {
                mList.clear()
            }

        }
        hotBean.itemList?.forEach {
            it.data?.let { it1 -> mList.add(it1) }
        }
        adapterr?.notifyDataSetChanged()

    }

    lateinit var name: String
    override val layoutResId: Int
        get() = R.layout.activity_find

    override fun setPresenter(): Findmorepresenter {

        return Findmorepresenter()
    }
    override fun initData() {


        var name= intent.getStringExtra("name");
        setToolbar()
        recyclerViewfind.layoutManager = LinearLayoutManager(this)
        adapterr = FindMoreadapter(this, mList)
        recyclerViewfind.adapter = adapterr
        refreshLayoutfind.setOnRefreshListener(this)
        getPresenter()?.finddata(this,name,"date")
        recyclerViewfind.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                var layoutManager: LinearLayoutManager = recyclerView?.layoutManager as LinearLayoutManager
                var lastPositon = layoutManager.findLastVisibleItemPosition()
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastPositon == mList.size - 1) {
                    if (data != null) {
                        getPresenter()?.findmore(this@FindActivity,mstart,name,"date")
                        mstart = mstart.plus(10)
                    }

                }
            }
        })

        //点击事件
        recyclerViewfind.addOnItemTouchListener(object : OnRecyclerItemClickListener(recyclerViewfind) {
            override fun onItemClick(viewHolder: RecyclerView.ViewHolder) {
                val adapter = viewHolder as FindMoreadapter.RankViewHolder
                val position = adapter.adapterPosition
                val string = adapter?.tv_title?.text.toString()
                //val string = adapter?.textView.getText().toString()
                var photo = mList.get(position)?.cover?.feed
                var title =  mList.get(position)?.title
                var category = mList.get(position)?.category
                var desc = mList.get(position)?.description
                var duration = mList.get(position)?.duration
                var playUrl = mList.get(position)?.playUrl
                var blurred = mList.get(position)?.cover?.blurred
                var collect = mList.get(position)?.consumption?.collectionCount
                var share = mList.get(position)?.consumption?.shareCount
                var reply = mList.get(position)?.consumption?.replyCount
                var time = System.currentTimeMillis()
                var videoBean  = VideoBean(photo,title,desc,duration,playUrl,category,blurred,collect ,share ,reply,time)
                //Toast.makeText(context, videoBean.toString(), Toast.LENGTH_SHORT).show()
                var intent : Intent = Intent(this@FindActivity, VideoDetailActivity::class.java)
                intent.putExtra("data",videoBean as Parcelable)
                Log.e("123","intent")
                startActivity(intent)

            }


            override fun onLongClick(viewHolder: RecyclerView.ViewHolder) {
                Toast.makeText(this@FindActivity, "长按", Toast.LENGTH_SHORT).show()
            }
        })
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
    override fun onRefresh() {
        if (!mIsRefresh) {
            mIsRefresh = true
            getPresenter()?.finddata(this,name, "date")
        }
    }
}
