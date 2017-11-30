package com.wxp.Android_1122Pm_Kotlin_movie.fragment

import android.content.Intent
import android.os.Parcelable
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import com.wxp.Android_1122Pm_Kotlin_movie.R
import com.wxp.Android_1122Pm_Kotlin_movie.activity.VideoDetailActivity
import com.wxp.Android_1122Pm_Kotlin_movie.adapter.ShouyeFragmentAdapter
import com.wxp.Android_1122Pm_Kotlin_movie.base.BaseFragment
import com.wxp.Android_1122Pm_Kotlin_movie.bean.HomeBean
import com.wxp.Android_1122Pm_Kotlin_movie.bean.VideoBean
import com.wxp.Android_1122Pm_Kotlin_movie.presenter.ShouyePrensenterImpl
import com.wxp.Android_1122Pm_Kotlin_movie.util.OnRecyclerItemClickListener
import com.wxp.Android_1122Pm_Kotlin_movie.view.ShouyeView
import kotlinx.android.synthetic.main.shouye_activity.*
import java.util.*
import java.util.regex.Pattern


/** 类的用途
 *  @author weixiaopeng
 *  @date 2017/11/22 15:52
 */
class ShouyeFragment: BaseFragment<ShouyeView,ShouyePrensenterImpl>(),ShouyeView, SwipeRefreshLayout.OnRefreshListener{


    var mIsRefresh: Boolean = false
    var mList = ArrayList<HomeBean.IssueListBean.ItemListBean>()
    var adapter: ShouyeFragmentAdapter? = null
    var data: String? = null

    override fun setPresenter(): ShouyePrensenterImpl {
        return ShouyePrensenterImpl()
    }

    override fun setShouyeData(bean: HomeBean) {

        val regEx = "[^0-9]"
        val p = Pattern.compile(regEx)
        val m = p.matcher(bean?.nextPageUrl)
        data = m.replaceAll("").subSequence(1, m.replaceAll("").length - 1).toString()
        if (mIsRefresh) {
            mIsRefresh = false
            refreshLayout.isRefreshing = false
            if (mList.size > 0) {
                mList.clear()
            }

        }
        bean.issueList!!
                .flatMap { it.itemList!! }
                .filter { it.type.equals("video") }
                .forEach { mList.add(it) }
        adapter?.notifyDataSetChanged()
        Log.e("123","adapter")

    }



    override fun initView() {

    }

    override fun initOnClick() {


    }

    override fun initData() {
        getPresenter()?.ConnectMGetShouye(context)
        adapter = ShouyeFragmentAdapter(context, mList)
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
        refreshLayout.setOnRefreshListener(this)
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                var layoutManager: LinearLayoutManager = recyclerView?.layoutManager as LinearLayoutManager
                var lastPositon = layoutManager.findLastVisibleItemPosition()
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastPositon == mList.size - 1) {
                    if (data != null) {
                        getPresenter()?.ConnectMGetShouyeNext(context, data!!)
                    }

                }
            }
        })
        //点击事件
        recyclerView.addOnItemTouchListener(object : OnRecyclerItemClickListener(recyclerView) {
            override fun onItemClick(viewHolder: RecyclerView.ViewHolder) {
                val adapter = viewHolder as ShouyeFragmentAdapter.ViewHodler
                val position = adapter.adapterPosition
                val string = adapter?.tv_title?.text.toString()
                //val string = adapter?.textView.getText().toString()
                var photo = mList.get(position).data?.cover?.feed
                var title = mList.get(position).data?.title
                var category = mList.get(position).data?.category
                var desc = mList.get(position).data?.description
                var duration = mList.get(position).data?.duration
                var playUrl = mList.get(position).data?.playUrl
                var blurred = mList.get(position).data?.cover?.blurred
                var collect = mList.get(position).data?.consumption?.collectionCount
                var share = mList.get(position).data?.consumption?.shareCount
                var reply = mList.get(position).data?.consumption?.replyCount
                var time = System.currentTimeMillis()
                var videoBean  = VideoBean(photo,title,desc,duration,playUrl,category,blurred,collect ,share ,reply,time)
                //Toast.makeText(context, videoBean.toString(), Toast.LENGTH_SHORT).show()
                var intent : Intent = Intent(context, VideoDetailActivity::class.java)
                intent.putExtra("data",videoBean as Parcelable)
                Log.e("123","intent")
                startActivity(intent)

            }


            override fun onLongClick(viewHolder: RecyclerView.ViewHolder) {
                Toast.makeText(context, "长按", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onRefresh() {
        Log.e("123",mIsRefresh.toString())
        if (!mIsRefresh) {
            mIsRefresh = true

            mPresenter?.ConnectMGetShouyeNext(context,data!!)
        }
    }

    override fun setLayout(): View {
        return View.inflate(context,R.layout.shouye_activity,null)
    }


}