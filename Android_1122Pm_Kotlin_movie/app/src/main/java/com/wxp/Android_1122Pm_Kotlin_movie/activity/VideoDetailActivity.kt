package com.wxp.Android_1122Pm_Kotlin_movie.activity

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer
import com.wxp.Android_1122Pm_Kotlin_movie.R
import com.wxp.Android_1122Pm_Kotlin_movie.bean.VideoBean
import com.wxp.Android_1122Pm_Kotlin_movie.util.VideoListener
import kotlinx.android.synthetic.main.activity_video_detail.*

class VideoDetailActivity : AppCompatActivity() {

    lateinit var bean: VideoBean
    lateinit var orientationUtils: OrientationUtils
    var isPlay: Boolean = false
    var isPause: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_detail)
        bean= intent.getParcelableExtra<VideoBean>("data")
        initdata()
        prepareVideo()
        Log.i("yyy","create")
    }

    private fun initdata(){
        var bgUrl = bean.blurred
        Glide.with(this).load(bgUrl).into(iv_bottom_bg)
        tv_video_desc.text = bean.description
        tv_video_title.text = bean.title
        var category = bean.category
        var duration = bean.duration
        var minute = duration?.div(60)
        var second = duration?.minus((minute?.times(60)) as Long)
        var realMinute: String
        var realSecond: String
        if (minute!! < 10) {
            realMinute = "0" + minute
        } else {
            realMinute = minute.toString()
        }
        if (second!! < 10) {
            realSecond = "0" + second
        } else {
            realSecond = second.toString()
        }
        tv_video_time.text = "$category / $realMinute'$realSecond''"
        tv_video_favor.text = bean.collect.toString()
        tv_video_share.text = bean.share.toString()
        tv_video_reply.text = bean.share.toString()
    }

    private fun prepareVideo(){
        //从文件中查出播放
        var uri = intent.getStringExtra("loaclFile")
        if(uri!=null){
            Log.e("uri",uri)
            gsy_player.setUp(uri, false, null, null)

        }else{
            gsy_player.setUp(bean.playUrl, false, null, null)
        }
        //加载封面
        var bgUrl2 = bean.feed
        var view= View.inflate(this,R.layout.find_player_view,null)
        var image=view.findViewById(R.id.iv) as ImageView
        Glide.with(this).load(bgUrl2).asBitmap().into(image)
        gsy_player.getThumbImageViewLayout()
        gsy_player.setThumbImageView(view)
        gsy_player.setIsTouchWiget(true);
        //关闭自动旋转
        gsy_player.isRotateViewAuto = false
        gsy_player.isLockLand = false
        gsy_player.isShowFullAnimation = false
        gsy_player.isNeedLockFull = true
        orientationUtils = OrientationUtils(this, gsy_player)
        gsy_player.fullscreenButton.setOnClickListener {
            //直接横屏
            //orientationUtils.resolveByClick();
            //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
            gsy_player.startWindowFullscreen(this, true, true);
        }

        gsy_player.setStandardVideoAllCallBack(object : VideoListener() {
            override fun onPrepared(url: String?, vararg objects: Any?) {
                super.onPrepared(url, *objects)
                //开始播放了才能旋转和全屏
                orientationUtils.isEnable = true
                isPlay = true;
            }

            override fun onAutoComplete(url: String?, vararg objects: Any?) {
                super.onAutoComplete(url, *objects)

            }

            override fun onClickStartError(url: String?, vararg objects: Any?) {
                super.onClickStartError(url, *objects)
            }

            override fun onQuitFullscreen(url: String?, vararg objects: Any?) {
                super.onQuitFullscreen(url, *objects)
                orientationUtils?.let { orientationUtils.backToProtVideo() }
            }
        })
        gsy_player.setLockClickListener { view, lock ->
            //配合下方的onConfigurationChanged
            orientationUtils.isEnable = !lock
        }
        gsy_player.backButton.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })

    }

    override fun onPause() {
        super.onPause()
        isPause = true
        Log.i("yyy","123")
        finish()
    }

    override fun onResume() {
        super.onResume()
        isPause = false
    }

    //退出当前页面停止播放
    override fun onDestroy() {
        super.onDestroy()
        GSYVideoPlayer.releaseAllVideos()
        orientationUtils?.let {
            orientationUtils.releaseListener()
        }
        Log.i("yyy","des")
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        if (isPlay && !isPause) {
            if (newConfig?.orientation == ActivityInfo.SCREEN_ORIENTATION_USER) {
                if (!gsy_player.isIfCurrentIsFullscreen) {
                    gsy_player.startWindowFullscreen(this, true, true)
                }
            } else {
                //新版本isIfCurrentIsFullscreen的标志位内部提前设置了，所以不会和手动点击冲突
                if (gsy_player.isIfCurrentIsFullscreen) {
                    StandardGSYVideoPlayer.backFromWindowFull(this);
                }
                orientationUtils?.let { orientationUtils.isEnable = true }
            }
        }
    }

}
