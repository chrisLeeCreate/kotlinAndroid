package cn.boxfish.stu.kotlinandroid.adapter

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import cn.boxfish.stu.kotlinandroid.R
import cn.boxfish.stu.kotlinandroid.bean.Songs
import com.bumptech.glide.Glide

/**
 * Created by lishaowei on 2017/5/26.
 */
class MusicAdapter(var lists: MutableList<Songs>, var activity: Activity) : RecyclerView.Adapter<MusicAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.musicName?.text = lists[position].name
        holder?.albumName?.text = lists[position].album?.name
        Glide.with(activity)
                .load(lists[position].album?.picUrl)
                .crossFade()
                .into(holder?.musicBg)
    }

    override fun getItemCount(): Int = lists.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(activity).inflate(R.layout.item_music, parent, false)
        return ViewHolder(inflate)
    }

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var musicName: TextView? = view.findViewById(R.id.musicName) as TextView?
        var albumName: TextView? = view.findViewById(R.id.albumName) as TextView?
        var musicBg: ImageView? = view.findViewById(R.id.musicBg) as ImageView?
    }
}