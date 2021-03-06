package cn.boxfish.stu.kotlinandroid.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.boxfish.stu.kotlinandroid.R
import cn.boxfish.stu.kotlinandroid.adapter.AndroidAdapter
import cn.boxfish.stu.kotlinandroid.ui.activity.WebViewActivity
import cn.boxfish.stu.kotlinandroid.ui.mvp.interactor.KongfuIntrator
import cn.boxfish.stu.kotlinandroid.ui.mvp.presenter.KongFuPresenter
import cn.boxfish.stu.kotlinandroid.ui.mvp.view.KongfuContract
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
        val kongFuPresenter = KongFuPresenter(this, KongfuIntrator())
        kongFuPresenter.getData(page++, ANDROID)
        mAdapter = AndroidAdapter(mLists, activity)
        val recyclerView = view.findViewById(R.id.rv_recycle) as RecyclerView
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
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
            val fuckGoods = mAdapter.getPositionData(it)
            println(fuckGoods.toString())
            val bundle = Bundle()
            var intent = Intent()
            bundle.putSerializable("fuck", fuckGoods)
            intent.putExtras(bundle)
            intent.setClass(activity, WebViewActivity::class.java)
            activity.startActivity(intent)
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

