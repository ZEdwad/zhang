package com.wxp.Android_1122Pm_Kotlin_movie.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.wxp.Android_1122Pm_Kotlin_movie.R
import com.wxp.Android_1122Pm_Kotlin_movie.bean.HomeBean
import java.util.*

/** 类的用途
 *  @author weixiaopeng
 *  @date 2017/11/23 15:20
 */
class ShouyeFragmentAdapter(val context:Context,val list:ArrayList<HomeBean.IssueListBean.ItemListBean>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var viewholder:ViewHodler = holder as ViewHodler
        viewholder.tv_title?.setText(list[position].data?.title)
        viewholder.tv_detail?.setText("发布于 "+list[position].data?.category+" / "+list[position].data?.duration+"s")
        Picasso.with(context).load(list[position].data?.cover?.feed).into(viewholder.iv_photo)
        viewholder.iv_photo?.scaleType = ImageView.ScaleType.FIT_XY
        if(!"".equals(list[position].data?.image)){
            Picasso.with(context).load(list[position].data?.image).into(viewholder.iv_user)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return ViewHodler(View.inflate(parent?.context, R.layout.item_home,null))
    }

    class ViewHodler(item : View) : RecyclerView.ViewHolder(item){
        var tv_detail : TextView?= null
        var tv_title : TextView? = null
        var iv_photo : ImageView? = null
        var iv_user : ImageView? = null
        init {
            tv_detail = itemView?.findViewById(R.id.tv_detail) as TextView?
            tv_title = itemView?.findViewById(R.id.tv_title) as TextView?
            iv_photo = itemView?.findViewById(R.id.iv_photo) as ImageView?
            iv_user =  itemView?.findViewById(R.id.iv_user) as ImageView?
        }
    }

}