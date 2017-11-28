package com.wxp.Android_1122Pm_Kotlin_movie.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.wxp.Android_1122Pm_Kotlin_movie.R
import com.wxp.Android_1122Pm_Kotlin_movie.activity.CacheActivity
import com.wxp.Android_1122Pm_Kotlin_movie.activity.WatchActivity
import com.wxp.Android_1122Pm_Kotlin_movie.base.BaseFragment
import com.wxp.Android_1122Pm_Kotlin_movie.presenter.MinePresenter
import com.wxp.Android_1122Pm_Kotlin_movie.view.MineView
import kotlinx.android.synthetic.main.mine_activity.*

/** 类的用途
 *  @author weixiaopeng
 *  @date 2017/11/22 15:52
 */
class MineFragment : BaseFragment<MineView,MinePresenter>(),View.OnClickListener {
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_save->{
                val intent = Intent(activity, CacheActivity::class.java)
                startActivity(intent)
            }
            R.id.tv_watch->{
                val intent = Intent(activity, WatchActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun setPresenter(): MinePresenter {
        return MinePresenter()
    }

    override fun initView() {
        tv_save.setOnClickListener(this)
        tv_watch.setOnClickListener(this)
    }

    override fun initOnClick() {
    }

    override fun initData() {


    }

    override fun setLayout(): View {
         return View.inflate(context,R.layout.mine_activity,null)
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}