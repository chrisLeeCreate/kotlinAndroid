package cn.boxfish.stu.kotlinandroid.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import cn.boxfish.stu.kotlinandroid.AndroidAdapter
import cn.boxfish.stu.kotlinandroid.R
import cn.boxfish.stu.kotlinandroid.mvp.model.KongfuIntrator
import cn.boxfish.stu.kotlinandroid.mvp.presenter.KongFuPresenter
import cn.boxfish.stu.kotlinandroid.mvp.view.KongfuContract
import com.wingsofts.gankclient.bean.FuckGoods

/**
 * Created by lishaowei on 2017/5/22.
 */
class AndroidFragment : Fragment(), KongfuContract.View {

    var mLists = ArrayList<FuckGoods>()
    var page: Int = 1
    lateinit var mAdapter: AndroidAdapter
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.frag_android, container, false) as View
        initView(view)
        return view
    }

    fun initView(view: View) {
        mAdapter = AndroidAdapter(mLists, activity)
        val kongFuPresenter = KongFuPresenter(this, KongfuIntrator())
        kongFuPresenter.getData(page++, ANDROID)
        val recycle = view.findViewById(R.id.rv_recycle) as RecyclerView
        recycle.adapter = mAdapter
        recycle.layoutManager = LinearLayoutManager(context)
        recycle.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (!recyclerView?.canScrollVertically(1)!!) {
                    kongFuPresenter.getData(page++, ANDROID)

                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }
        })
        mAdapter.setOnItemClickListener({
            Toast.makeText(context, "发财", Toast.LENGTH_SHORT).show()
        })
    }

    companion object {
        val ANDROID = "ANDROID"
        fun newInstance(): AndroidFragment {
            val fragment = AndroidFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }

    }

    override fun getDataSucc(results: List<FuckGoods>) {
        this.mLists.addAll(results)
        mAdapter.notifyDataSetChanged()
        Log.d(ANDROID, results.toString())
    }
}