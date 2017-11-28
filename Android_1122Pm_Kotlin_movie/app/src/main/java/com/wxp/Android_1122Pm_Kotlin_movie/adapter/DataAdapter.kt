package com.wxp.Android_1122Pm_Kotlin_movie.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.wxp.Android_1122Pm_Kotlin_movie.R
import com.wxp.Android_1122Pm_Kotlin_movie.bean.Msg
import kotlinx.android.synthetic.main.dataitem.*

/** 类的用途
 *  @author weixiaopeng
 *  @date 2017/11/21 18:18
 */
class DataAdapter(val list: Msg, val context:Context) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder :MyViewHolder
        var v:View
        if(convertView == null){
            v = View.inflate(context, R.layout.dataitem,null)
            holder = MyViewHolder(v)
            v.tag = holder
        }else{
            v = convertView
            holder = v.tag as MyViewHolder
        }

        holder.title.text = list.data?.get(position)?.title
        holder.name.text = list.data?.get(position)?.userName
        holder.content.text = list.data?.get(position)?.content
        Picasso.with(context).load(list.data?.get(position)?.headImg).into(holder.img)
        return v

    }

    override fun getItem(position: Int): Any {
        return list.data!!.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.data!!.size
    }

    class MyViewHolder(item:View) {
        var title: TextView = item.findViewById(R.id.main_title) as TextView
        var name: TextView = item.findViewById(R.id.main_name) as TextView
        var img: ImageView = item.findViewById(R.id.main_img) as ImageView
        var content: TextView = item.findViewById(R.id.main_content) as TextView
    }

}