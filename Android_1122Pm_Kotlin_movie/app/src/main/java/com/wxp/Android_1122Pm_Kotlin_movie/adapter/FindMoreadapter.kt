package com.wxp.Android_1122Pm_Kotlin_movie.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.tt.lvruheng.eyepetizer.mvp.model.bean.HotBean
import com.wxp.Android_1122Pm_Kotlin_movie.R

/**
 * dell 孙劲雄
 *2017/11/24
 *8:41
 */
class FindMoreadapter(val context: Context,val hot:ArrayList<HotBean.ItemListBean.DataBean>): RecyclerView.Adapter<FindMoreadapter.RankViewHolder>() {

    var inflater: LayoutInflater? = null


    init {
        this.inflater = LayoutInflater.from(context)
    }

    override fun getItemCount(): Int {

        return  hot?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RankViewHolder {


        var view=View.inflate(context,R.layout.item_home,null)


        return RankViewHolder(inflater?.inflate(R.layout.findmore, parent, false), context!!)

    }

    override fun onBindViewHolder(holder: RankViewHolder?, position: Int) {


        var photoUrl : String? = hot?.get(position).cover?.feed
        Picasso.with(context).load(photoUrl).into(holder?.iv_photo)

        holder?.iv_photo?.scaleType=ImageView.ScaleType.FIT_XY

        var title : String? = hot?.get(position)?.title
        holder?.tv_title?.text = title
        var category = hot?.get(position)?.category
        var duration =hot?.get(position)?.duration
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
        holder?.tv_time?.text = "$category / $realMinute'$realSecond''"

    }


    class RankViewHolder(itemView: View?, context: Context) : RecyclerView.ViewHolder(itemView) {
        var iv_photo: ImageView = itemView?.findViewById(R.id.iv_photo) as ImageView
        var tv_title: TextView = itemView?.findViewById(R.id.tv_title) as TextView
        var tv_time: TextView = itemView?.findViewById(R.id.tv_time) as TextView


    }
}