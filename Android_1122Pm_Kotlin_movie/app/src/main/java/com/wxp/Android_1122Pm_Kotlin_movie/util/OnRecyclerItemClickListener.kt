package com.wxp.Android_1122Pm_Kotlin_movie.util

import android.support.v4.view.GestureDetectorCompat
import android.support.v7.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent

/*******************************************************************
 * * * * *   * * * *   *     *       Created by OCN.Yang
 * *     *   *         * *   *       Time:2017/8/2 10:30.
 * *     *   *         *   * *       Email address:ocnyang@gmail.com
 * * * * *   * * * *   *     *.Yang  Web site:www.ocnyang.com
 */


abstract class OnRecyclerItemClickListener(private val mRecyclerView: RecyclerView) : RecyclerView.OnItemTouchListener {
    private val mGestureDetectorCompat: GestureDetectorCompat

    init {
        mGestureDetectorCompat = GestureDetectorCompat(mRecyclerView.context,
                ItemTouchHelperGestureListener())
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        mGestureDetectorCompat.onTouchEvent(e)
        return false
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
        mGestureDetectorCompat.onTouchEvent(e)
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

    }

    abstract fun onItemClick(viewHolder: RecyclerView.ViewHolder)
    abstract fun onLongClick(viewHolder: RecyclerView.ViewHolder)

    private inner class ItemTouchHelperGestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onSingleTapUp(e: MotionEvent): Boolean {
            val childViewUnder = mRecyclerView.findChildViewUnder(e.x, e.y)
            if (childViewUnder != null) {
                val childViewHolder = mRecyclerView.getChildViewHolder(childViewUnder)
                onItemClick(childViewHolder)
            }
            return true
        }

        override fun onLongPress(e: MotionEvent) {
            val childViewUnder = mRecyclerView.findChildViewUnder(e.x, e.y)
            if (childViewUnder != null) {
                val childViewHolder = mRecyclerView.getChildViewHolder(childViewUnder)
                onLongClick(childViewHolder)
            }
        }
    }
}
