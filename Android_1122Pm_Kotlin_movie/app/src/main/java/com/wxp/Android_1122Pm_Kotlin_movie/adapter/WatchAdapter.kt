package com.wxp.Android_1122Pm_Kotlin_movie.adapter

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import com.wxp.Android_1122Pm_Kotlin_movie.R

/**
 *
 * @author ${张健}
 *
 * @date 2017/11/24/10:09
 *
 */
class WatchAdapter(context: Context,list: ArrayList<VideoView>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var context: Context?=null
    var list: ArrayList<VideoView>?=null
    var layoutinflater:LayoutInflater?=null

    init {
        this.context=context;
        this.list=list
        this.layoutinflater= LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return WatchViewHolder(layoutinflater?.inflate(R.layout.item_feed_result,parent,false),context!!)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

    }

    override fun getItemCount(): Int {
        return list?.size?:0
    }


    class WatchViewHolder(itemView: View?, context: Context) : RecyclerView.ViewHolder(itemView) {
        var iv_photo: ImageView = itemView?.findViewById(R.id.iv_photo) as ImageView
        var tv_title: TextView = itemView?.findViewById(R.id.tv_title) as TextView
        var tv_time: TextView = itemView?.findViewById(R.id.tv_detail) as TextView
        init {
            tv_title?.typeface = Typeface.createFromAsset(context?.assets, "fonts/FZLanTingHeiS-L-GB-Regular.TTF")

        }
    }
}