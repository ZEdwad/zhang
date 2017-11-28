package com.wxp.Android_1122Pm_Kotlin_movie.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.tt.lvruheng.eyepetizer.mvp.model.bean.HotBean
import com.wxp.Android_1122Pm_Kotlin_movie.R

/**
 *
 * @author ${张健}
 *
 * @date 2017/11/28/8:14
 *
 */
class RankAdapter(context: Context, list: ArrayList<HotBean.ItemListBean.DataBean>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var context: Context? = null;
    var list: ArrayList<HotBean.ItemListBean.DataBean>? = null
    var inflater: LayoutInflater? = null

    init {
        this.context = context
        this.list = list
        this.inflater = LayoutInflater.from(context)
    }

    override fun getItemCount(): Int {
        return list?.size?:0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var viewholder:RankViewHolder= holder as RankViewHolder
        Glide.with(context).load(list?.get(position)?.cover?.feed).asBitmap().into(viewholder.iv_photo)
        viewholder.tv_title.setText(list?.get(position)?.title)
        var category = list?.get(position)?.category
        var duration = list?.get(position)?.duration
        var minute =duration?.div(60)
        var second = duration?.minus((minute?.times(60)) as Long )
        var realMinute : String
        var realSecond : String
        if(minute!!<10){
            realMinute = "0"+minute
        }else{
            realMinute = minute.toString()
        }
        if(second!!<10){
            realSecond = "0"+second
        }else{
            realSecond = second.toString()
        }
        viewholder.tv_time.setText(category +"/"+realMinute+"'"+realSecond+"''")
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return RankViewHolder(inflater?.inflate(R.layout.item_rank,parent,false),context!!)
    }

    class RankViewHolder(itemView: View?,context: Context) : RecyclerView.ViewHolder(itemView) {
        var iv_photo:ImageView= itemView?.findViewById(R.id.iv_photo) as ImageView
        var tv_title: TextView = itemView?.findViewById(R.id.tv_title) as TextView
        var tv_time: TextView = itemView?.findViewById(R.id.tv_time) as TextView
        /*init {
            tv_title?.typeface = Typeface.createFromAsset(context?.assets, "fonts/FZLanTingHeiS-L-GB-Regular.TTF")

        }*/
    }
}