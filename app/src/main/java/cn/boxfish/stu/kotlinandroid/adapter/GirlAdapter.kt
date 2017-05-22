package cn.boxfish.stu.kotlinandroid.adapter

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import cn.boxfish.stu.kotlinandroid.R
import com.bumptech.glide.Glide
import com.wingsofts.gankclient.bean.FuckGoods

/**
 * Created by lishaowei on 2017/5/22.
 */
class GirlAdapter(var lists: ArrayList<FuckGoods>, var activity: FragmentActivity) : RecyclerView.Adapter<GirlAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if (holder != null) {
            val fuckGoods = lists[position]
            if (fuckGoods.hasImg()){
                Glide.with(activity)
                        .load(fuckGoods.images[0])
                        .crossFade()
                        .into(holder.image)
            }else{
                Glide.with(activity)
                        .load(fuckGoods.url)
                        .crossFade()
                        .into(holder.image)
            }


            holder.itemView.setOnClickListener {
                mListener?.invoke(holder.adapterPosition)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent!!.context).inflate(R.layout.item_girl, parent, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int = lists.size


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var image: ImageView? = view.findViewById(R.id.im_girl) as ImageView?
    }

    var mListener: ((pos: Int) -> Unit)? = null


    fun setOnItemClickListener(listener: ((pos: Int) -> Unit)) {
        mListener = listener
    }
}