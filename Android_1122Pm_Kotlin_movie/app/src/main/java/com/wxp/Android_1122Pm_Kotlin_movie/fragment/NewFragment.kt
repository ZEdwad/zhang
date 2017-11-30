package com.wxp.Android_1122Pm_Kotlin_movie.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import com.tt.lvruheng.eyepetizer.mvp.model.bean.HotBean
import com.wxp.Android_1122Pm_Kotlin_movie.R
import com.wxp.Android_1122Pm_Kotlin_movie.activity.VideoDetailActivity
import com.wxp.Android_1122Pm_Kotlin_movie.adapter.RankAdapter
import com.wxp.Android_1122Pm_Kotlin_movie.base.BaseFragment
import com.wxp.Android_1122Pm_Kotlin_movie.bean.VideoBean
import com.wxp.Android_1122Pm_Kotlin_movie.presenter.HotPresenter
import com.wxp.Android_1122Pm_Kotlin_movie.util.OnRecyclerItemClickListener
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
        recyclerViewHot.layoutManager=LinearLayoutManager(context)
        adadpter=RankAdapter(context,mList)
        recyclerViewHot.adapter=adadpter
    }

    override fun initOnClick() {
        //点击事件
        recyclerViewHot.addOnItemTouchListener(object : OnRecyclerItemClickListener(recyclerViewHot) {
            override fun onItemClick(viewHolder: RecyclerView.ViewHolder) {
                val adapter = viewHolder as RankAdapter.RankViewHolder
                val position = adapter.adapterPosition
                val string = adapter?.tv_title?.text.toString()
                //val string = adapter?.textView.getText().toString()
                var photo = mList.get(position).cover?.feed
                var title = mList.get(position).title
                var category = mList.get(position).category
                var desc = mList.get(position).description
                var duration = mList.get(position).duration
                var playUrl = mList.get(position).playUrl
                var blurred = mList.get(position).cover?.blurred
                var collect = mList.get(position).consumption?.collectionCount
                var share = mList.get(position).consumption?.shareCount
                var reply = mList.get(position).consumption?.replyCount
                var time = System.currentTimeMillis()
                var videoBean  = VideoBean(photo,title,desc,duration,playUrl,category,blurred,collect ,share ,reply,time)
                //Toast.makeText(context, videoBean.toString(), Toast.LENGTH_SHORT).show()
                var intent : Intent = Intent(context, VideoDetailActivity::class.java)
                intent.putExtra("data",videoBean as Parcelable)
                startActivity(intent)

            }


            override fun onLongClick(viewHolder: RecyclerView.ViewHolder) {
                Toast.makeText(context, "长按", Toast.LENGTH_SHORT).show()
            }
        })
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