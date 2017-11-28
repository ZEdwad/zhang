package com.wxp.Android_1122Pm_Kotlin_movie.bean

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

/**
 *
 * @author ${张健}
 *
 * @date 2017/11/24/10:27
 *
 */
data class VideoBean(var feed:String?,var title:String?,var description:String?,
                     var duration: Long?,var playUrl: String?,var category: String?,
                     var blurred : String?,var collect:Int?,var share:Int?,var reply:Int?,var time:Long) : Parcelable,Serializable {
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<VideoBean> = object : Parcelable.Creator<VideoBean> {
            override fun createFromParcel(source: Parcel): VideoBean = VideoBean(source)
            override fun newArray(size: Int): Array<VideoBean?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
    source.readString(),
    source.readString(),
    source.readString(),
    source.readValue(Long::class.java.classLoader) as Long?,
    source.readString(),
    source.readString(),
    source.readString(),
    source.readValue(Int::class.java.classLoader) as Int?,
    source.readValue(Int::class.java.classLoader) as Int?,
    source.readValue(Int::class.java.classLoader) as Int?,
    source.readLong()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(feed)
        dest.writeString(title)
        dest.writeString(description)
        dest.writeValue(duration)
        dest.writeString(playUrl)
        dest.writeString(category)
        dest.writeString(blurred)
        dest.writeValue(collect)
        dest.writeValue(share)
        dest.writeValue(reply)
        dest.writeLong(time)
    }
}