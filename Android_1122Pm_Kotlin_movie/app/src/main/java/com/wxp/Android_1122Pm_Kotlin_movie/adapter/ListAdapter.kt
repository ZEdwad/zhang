package com.wxp.Android_1122Pm_Kotlin_movie.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.wxp.Android_1122Pm_Kotlin_movie.R

/** 类的用途
 *  @author weixiaopeng
 *  @date 2017/11/21 14:25
 */
class ListAdapter(val list:ArrayList<String> ,val context:Context) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder: MyViewHolder
        var v:View
        if(convertView == null){
            v = View.inflate(context, R.layout.item,null);
            holder = MyViewHolder(v);
            v.tag = holder;
        }else{
            v = convertView
            holder = v.tag as MyViewHolder
        }

        holder.str.text = list[position]
        return v
    }

    override fun getItem(position: Int): Any {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

    class MyViewHolder(var item:View){
        var str: TextView = item.findViewById(R.id.item_text) as TextView
    }

}