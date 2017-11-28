package com.wxp.Android_1122Pm_Kotlin_movie.bean

/** 类的用途
 *  @author weixiaopeng
 *  @date 2017/11/23 09:28
 */
class ShouyeBean {


data class Bean(
		val issueList: List<Issue>,
		val nextPageUrl: String, //http://baobab.kaiyanapp.com/api/v2/feed?date=1511226000000&num=2
		val nextPublishTime: Long, //1511485200000
		val newestIssueType: String, //morning
		val dialog: Any //null
)

data class Issue(
		val releaseTime: Long, //1511398800000
		val type: String, //morning
		val date: Long, //1511398800000
		val publishTime: Long, //1511398800000
		val itemList: List<Item>,
		val count: Int //5
)

data class Item(
		val type: String, //banner2
		val data: Data,
		val tag: Any, //null
		val id: Int //0
)

data class Data(
        val dataType: String, //VideoBeanForClient
        val id: Int, //19977
        val title: String, //听「丹麦一哥」讲述丹麦人民的幸福秘诀
        val slogan: String, //纪念麦斯·米科尔森 52 岁生日
        val description: String, //麦斯·米科尔森是著名丹麦男演员，凭借在 2012 年电影「捕猎」中的演出夺得第 65 届戛纳电影节最佳男演员奖。今天是他的 52 岁生日。这条短片向他致敬，每一帧画幅都令人赏心悦目~From Carlsberg UK
        val provider: ShouyeBean.Provider,
        val category: String, //广告
        val author: ShouyeBean.Author,
        val cover: ShouyeBean.Cover,
        val playUrl: String, //http://baobab.kaiyanapp.com/api/v1/playUrl?vid=19977&editionType=default&source=qcloud
        val thumbPlayUrl: Any, //null
        val duration: Int, //60
        val webUrl: Any, //null
        val releaseTime: Long, //1511312400000
        val library: String, //DAILY
        val playInfo: List<ShouyeBean.PlayInfo>,
        val consumption: ShouyeBean.Consumption,
        val campaign: Any, //null
        val waterMarks: Any, //null
        val adTrack: Any, //null
        val tags: List<ShouyeBean.Tag>,
        val type: String, //NORMAL
        val titlePgc: String,
        val descriptionPgc: String,
        val remark: String, //http://weibo.com/3635862124/F0dKouVeh?type=comment 今天是麦叔生日   麦斯·米科尔森   1965 年 11 月 22 日
        val idx: Int, //0
        val shareAdTrack: Any, //null
        val favoriteAdTrack: Any, //null
        val webAdTrack: Any, //null
        val date: Long, //1511312400000
        val promotion: Any, //null
        val label: Any, //null
        val labelList: List<Any>,
        val descriptionEditor: String, //麦斯·米科尔森是著名丹麦男演员，凭借在 2012 年电影「捕猎」中的演出夺得第 65 届戛纳电影节最佳男演员奖。今天是他的 52 岁生日。这条短片向他致敬，每一帧画幅都令人赏心悦目~From Carlsberg UK
        val collected: Boolean, //false
        val played: Boolean, //false
        val subtitles: List<Any>,
        val lastViewTime: Any, //null
        val playlists: Any //null
)

    data class Provider(
            val name: String, //YouTube
            val alias: String, //youtube
            val icon: String //http://img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png
    )

    data class Cover(
            val feed: String, //http://img.kaiyanapp.com/1699f3946ccd281230a1d887d169439f.png?imageMogr2/quality/60/format/jpg
            val detail: String, //http://img.kaiyanapp.com/1699f3946ccd281230a1d887d169439f.png?imageMogr2/quality/60/format/jpg
            val blurred: String, //http://img.kaiyanapp.com/4bce6bf820dad1875e160fef05e91b90.png?imageMogr2/quality/60/format/jpg
            val sharing: Any, //null
            val homepage: String //http://img.kaiyanapp.com/1699f3946ccd281230a1d887d169439f.png?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
    )

    data class PlayInfo(
            val height: Int, //480
            val width: Int, //854
            val urlList: List<Url>,
            val name: String, //标清
            val type: String, //normal
            val url: String //http://baobab.kaiyanapp.com/api/v1/playUrl?vid=19977&editionType=normal&source=qcloud
    )

    data class Url(
            val name: String, //qcloud
            val url: String, //http://baobab.kaiyanapp.com/api/v1/playUrl?vid=19977&editionType=normal&source=qcloud
            val size: Int //7961337
    )

    data class Author(
            val id: Int, //2162
            val icon: String, //http://img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg
            val name: String, //开眼广告精选
            val description: String, //为广告人的精彩创意点赞
            val link: String,
            val latestReleaseTime: Long, //1511312400000
            val videoNum: Int, //805
            val adTrack: Any, //null
            val follow: Follow,
            val shield: Shield,
            val approvedNotReadyVideoCount: Int, //0
            val ifPgc: Boolean //true
    )

    data class Shield(
            val itemType: String, //author
            val itemId: Int, //2162
            val shielded: Boolean //false
    )

    data class Follow(
            val itemType: String, //author
            val itemId: Int, //2162
            val followed: Boolean //false
    )

    data class Tag(
            val id: Int, //530
            val name: String, //人生
            val actionUrl: String, //eyepetizer://tag/530/?title=%E4%BA%BA%E7%94%9F
            val adTrack: Any, //null
            val desc: Any, //null
            val bgPicture: String, //http://img.kaiyanapp.com/a57744110ddbaa1e99d148a01c1b1bd8.jpeg?imageMogr2/quality/60/format/jpg
            val headerImage: String, //http://img.kaiyanapp.com/a57744110ddbaa1e99d148a01c1b1bd8.jpeg?imageMogr2/quality/60/format/jpg
            val tagRecType: String //NORMAL
    )

    data class Consumption(
            val collectionCount: Int, //1204
            val shareCount: Int, //1099
            val replyCount: Int //26
    )

}