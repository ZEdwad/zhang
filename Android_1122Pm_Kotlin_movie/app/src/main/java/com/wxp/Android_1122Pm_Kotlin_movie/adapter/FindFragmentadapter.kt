package com.wxp.Android_1122Pm_Kotlin_movie.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.wxp.Android_1122Pm_Kotlin_movie.R
import com.wxp.Android_1122Pm_Kotlin_movie.bean.Find
import kotlinx.android.synthetic.main.find_item.*

/**
 * dell 孙劲雄
 * 2017/11/22
 * 20:06
 */

class FindFragmentadapter(var find:List<Find>,var context:Context) : BaseAdapter() {

    override fun getCount(): Int {

        return find?.size
    }

    override fun getItem(position: Int): Any? {

        return find?.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int,convertView: View?, parent: ViewGroup): View? {

        var holder:Findholder
        var v:View
        if(convertView==null){

            v=View.inflate(context,R.layout.find_item,null)

            holder=Findholder(v);

            v.tag=holder

        }else{

            v=convertView

            holder=v.tag as Findholder

        }

         Picasso.with(context).load(find?.get(position).bgPicture).into(holder.iv_photo)

          holder.tv_title.text=find?.get(position).name

        return v
    }

    class Findholder(var view: View){

       var tv_title:TextView=view.findViewById(R.id.tv_title) as TextView
       var iv_photo:ImageView=view.findViewById(R.id.iv_photo) as ImageView


    }

}
