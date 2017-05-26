package cn.boxfish.stu.kotlinandroid.adapter

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import cn.boxfish.stu.kotlinandroid.R
import com.bumptech.glide.Glide
import com.wingsofts.gankclient.bean.FuckGoods


/**
 * Created by lishaowei on 2017/5/22.
 */
class AndroidAdapter(val Lists: ArrayList<FuckGoods>, var activity: FragmentActivity) : RecyclerView.Adapter<AndroidAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(activity).inflate(R.layout.item_android, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if (holder != null) {
            val fuckGoods = Lists[position]
            if (fuckGoods.hasImg()) {
//                holder.imageView!!.setImageURI(Uri.parse(fuckGoods.images[0]))
                Glide.with(activity).load(fuckGoods.images[0]).into(holder.imageView)
//                Glide.with(activity)
//                        .load(fuckGoods.images[0])
//                        .asGif() //判断加载的url资源是否为gif格式的资源
//                        .error(R.mipmap.ic_launcher_round)
//                        .into(holder.imageView)
                holder.textView?.text = fuckGoods.who
                holder.tv_android_des?.text = fuckGoods.desc
                holder.itemView.setOnClickListener {
                    mListener?.invoke(holder.adapterPosition)
                }
            } else {
                holder.textView?.text = fuckGoods.who
                holder.tv_android_des?.text = fuckGoods.desc
                holder.itemView.setOnClickListener {
                    mListener?.invoke(holder.adapterPosition)
                }
            }

        }
    }

    override fun getItemCount(): Int = Lists.size


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var textView: TextView? = view.findViewById(R.id.tv_android_name) as TextView?
        var tv_android_des: TextView? = view.findViewById(R.id.tv_android_des) as TextView?
        var imageView: ImageView? = view.findViewById(R.id.sdv) as ImageView?

    }

    var mListener: ((pos: Int) -> Unit)? = null


    fun setOnItemClickListener(listener: ((pos: Int) -> Unit)) {
        mListener = listener
    }

    fun getPositionData(pos: Int): FuckGoods {
        return Lists[pos]
    }

}