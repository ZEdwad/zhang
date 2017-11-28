package com.wxp.Android_1122Pm_Kotlin_movie.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wxp.Android_1122Pm_Kotlin_movie.R
import kotlinx.android.synthetic.main.activity_watch.*

class CacheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cache)
        setToobar()
    }

    private fun setToobar(){
        setSupportActionBar(toolbar)
        var bar = supportActionBar
        bar?.title = "我的缓存"
    }
}
