package com.wxp.Android_1122Pm_Kotlin_movie.activity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.util.Log
import android.view.View
import com.wxp.Android_1122Pm_Kotlin_movie.R
import com.wxp.Android_1122Pm_Kotlin_movie.base.BaseActivity
import com.wxp.Android_1122Pm_Kotlin_movie.bean.Msg
import com.wxp.Android_1122Pm_Kotlin_movie.fragment.FindFragment
import com.wxp.Android_1122Pm_Kotlin_movie.fragment.HotFragment
import com.wxp.Android_1122Pm_Kotlin_movie.fragment.MineFragment
import com.wxp.Android_1122Pm_Kotlin_movie.fragment.ShouyeFragment
import com.wxp.Android_1122Pm_Kotlin_movie.presenter.MvpPresenterImpl
import com.wxp.Android_1122Pm_Kotlin_movie.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity() : BaseActivity<MainView,MvpPresenterImpl>() , MainView,View.OnClickListener {

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.main_home ->{
                showHide(homeFragment,findFragment,hotFragment,mineFragment)
                main_title.text="Main"
                right_up_image.setImageResource(R.drawable.icon_search)
            }
            R.id.main_find ->{
                showHide(findFragment,homeFragment,hotFragment,mineFragment)
                main_title.text="Videolist"
                right_up_image.setImageResource(R.drawable.icon_search)
            }
            R.id.main_hot ->{
                showHide(hotFragment,findFragment,homeFragment,mineFragment)
                main_title.text="Ranking"
               right_up_image.setImageResource(R.drawable.icon_search)
            }
            R.id.main_my ->{
                showHide(mineFragment,hotFragment,findFragment,homeFragment)
                main_title.text=""
                right_up_image.setImageResource(R.drawable.icon_setting)
            }
        }
    }


    lateinit var homeFragment: ShouyeFragment
    lateinit var findFragment: FindFragment
    lateinit var hotFragment: HotFragment
    lateinit var mineFragment:MineFragment
    lateinit var transaction: FragmentTransaction
    lateinit var fragmentManager: FragmentManager

    override val layoutResId: Int

        get() = R.layout.activity_main



    override fun initData() {
        fragmentManager=getSupportFragmentManager()
        homeFragment=ShouyeFragment()
        findFragment=FindFragment()
        hotFragment=HotFragment()
        mineFragment=MineFragment()
        main_home.setOnClickListener(this)
        main_find.setOnClickListener(this)
        main_hot.setOnClickListener(this)
        main_my.setOnClickListener(this)

        addFragment(homeFragment,findFragment,hotFragment,mineFragment)


    }

    override fun setPresenter(): MvpPresenterImpl {
        return MvpPresenterImpl()
    }


    override fun setData(b: Msg) {
        val data = b.data?.get(0)
        Log.e("tttt",data?.userName)
    }


    fun addFragment(showFragment: Fragment,hindFragment1: Fragment,hindFragment2: Fragment,hindFragment3: Fragment){
        //开启一个事物
        transaction=fragmentManager.beginTransaction()
        transaction.add(R.id.main_frame,showFragment)
                .add(R.id.main_frame,hindFragment1)
                .add(R.id.main_frame,hindFragment2)
                .add(R.id.main_frame,hindFragment3)
                .hide(hindFragment1)
                .hide(hindFragment2)
                .hide(hindFragment3)
        //千万不要忘记提交哦
        transaction.commit()
    }

    fun showHide(showFragment: Fragment,hindFragment1: Fragment,hindFragment2: Fragment,hindFragment3: Fragment){
        //开启一个事物
        transaction=fragmentManager.beginTransaction()
        transaction.show(showFragment)
                .hide(hindFragment1)
                .hide(hindFragment2)
                .hide(hindFragment3)
        //千万不要忘记提交哦
        transaction.commit()
    }

}
