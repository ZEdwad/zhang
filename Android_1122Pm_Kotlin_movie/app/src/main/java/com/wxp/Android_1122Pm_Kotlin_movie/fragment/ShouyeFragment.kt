package com.wxp.Android_1122Pm_Kotlin_movie.fragment

import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import com.wxp.Android_1122Pm_Kotlin_movie.R
import com.wxp.Android_1122Pm_Kotlin_movie.adapter.ShouyeFragmentAdapter
import com.wxp.Android_1122Pm_Kotlin_movie.base.BaseFragment
import com.wxp.Android_1122Pm_Kotlin_movie.bean.Msg
import com.wxp.Android_1122Pm_Kotlin_movie.bean.ShouyeBean
import com.wxp.Android_1122Pm_Kotlin_movie.presenter.MvpPresenterImpl
import com.wxp.Android_1122Pm_Kotlin_movie.presenter.ShouyePrensenterImpl
import com.wxp.Android_1122Pm_Kotlin_movie.view.MainView
import com.wxp.Android_1122Pm_Kotlin_movie.view.ShouyeView
import kotlinx.android.synthetic.main.shouye_activity.*

/** 类的用途
 *  @author weixiaopeng
 *  @date 2017/11/22 15:52
 */
class ShouyeFragment: BaseFragment<ShouyeView,ShouyePrensenterImpl>(),ShouyeView{

    lateinit var beanList:ArrayList<ShouyeBean.Item>

    override fun setPresenter(): ShouyePrensenterImpl {
        return ShouyePrensenterImpl()
    }

    override fun setShouyeData(s: ShouyeBean.Bean) {

        beanList= ArrayList()
        for (i in 0..s.issueList.size-1){
            for(j in 0..s.issueList[i].itemList.size-1){
                if(s.issueList[i].itemList[j].type.equals("video")){
                    beanList.add(s.issueList[i].itemList[j])
                }
            }
        }

        val adapter=ShouyeFragmentAdapter(context,beanList)
        shouye_re.adapter = adapter
        Log.e("ttt",s.nextPageUrl)
    }

    override fun setShouyeNextData(s: ShouyeBean.Bean) {
        Log.e("ttt",s.nextPageUrl+"next")
    }

    override fun initView() {

    }

    override fun initOnClick() {

    }

    override fun initData() {
        getPresenter()?.ConnectMGetShouye(context,"83")
        getPresenter()?.ConnectMGetShouyeNext(context)

        shouye_re.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

    }

    override fun setLayout(): View {
        return View.inflate(context,R.layout.shouye_activity,null)
    }


}