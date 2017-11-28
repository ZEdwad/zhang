package com.wxp.Android_1122Pm_Kotlin_movie.adapter

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.tt.lvruheng.eyepetizer.mvp.model.bean.HotBean
import com.wxp.Android_1122Pm_Kotlin_movie.R

/**
 * dell 孙劲雄
 *2017/11/24
 *8:41
 */
class FindMoreadapter(val context: Context,val hot: HotBean): RecyclerView.Adapter<FindMoreadapter.RankViewHolder>() {
    override fun getItemCount(): Int {

        return hot.itemList!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RankViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RankViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class RankViewHolder(itemView: View?, context: Context) : RecyclerView.ViewHolder(itemView) {
        var iv_photo: ImageView = itemView?.findViewById(R.id.iv_photo) as ImageView
        var tv_title: TextView = itemView?.findViewById(R.id.tv_title) as TextView
        var tv_time: TextView = itemView?.findViewById(R.id.tv_time) as TextView
        init {
            tv_title?.typeface = Typeface.createFromAsset(context?.assets, "fonts/FZLanTingHeiS-L-GB-Regular.TTF")

        }
    }
}