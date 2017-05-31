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
import kotlinx.android.synthetic.main.item_music.view.*

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
        holder?.itemView?.setOnClickListener {
            listener?.invoke(it, position)
        }
    }

    override fun getItemCount(): Int = lists.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(activity).inflate(R.layout.item_music, parent, false)
        return ViewHolder(inflate)
    }

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var musicName: TextView? = view.musicName
        var albumName: TextView? = view.albumName
        var musicBg: ImageView? = view.musicBg
    }


    fun setItemOnclick(listener: (View, pos: Int) -> Unit) {
        this.listener = listener
    }

    private var listener: ((View, pos: Int) -> Unit)? = null

    fun getPositionData(pos: Int): Songs {
        return lists[pos]
    }
}