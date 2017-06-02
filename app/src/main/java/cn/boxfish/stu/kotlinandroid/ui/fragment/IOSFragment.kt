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
import cn.boxfish.stu.kotlinandroid.R
import cn.boxfish.stu.kotlinandroid.adapter.AndroidAdapter
import cn.boxfish.stu.kotlinandroid.ui.mvp.interactor.KongfuIntrator
import cn.boxfish.stu.kotlinandroid.ui.mvp.presenter.KongFuPresenter
import cn.boxfish.stu.kotlinandroid.ui.mvp.view.KongfuContract
import com.wingsofts.gankclient.bean.FuckGoods

/**
 * Created by lishaowei on 2017/5/22.
 */
class IOSFragment : Fragment(), KongfuContract.View {
    var mLists = ArrayList<FuckGoods>()
    var page: Int = 1
    lateinit var mAdapter: AndroidAdapter
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.frag_ios, container, false)
        initView(view)
        return view
    }

    fun initView(view: View?) {
        val kongFuPresenter = KongFuPresenter(this, KongfuIntrator())
        kongFuPresenter.getData(1, IOS)
        mAdapter = AndroidAdapter(mLists, activity)
        val rv_recycle2 = view?.findViewById(R.id.rv_recycle2) as RecyclerView
        rv_recycle2.adapter = mAdapter
        rv_recycle2.layoutManager = LinearLayoutManager(context)
        rv_recycle2.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (!recyclerView?.canScrollVertically(1)!!) {
                    kongFuPresenter.getData(page++, IOS)

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
        val IOS = "IOS"
        fun newInstance(): IOSFragment {
            val fragment = IOSFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getDataSucc(results: List<FuckGoods>) {
        mLists.addAll(results)
        mAdapter.notifyDataSetChanged()
        Log.d(IOS, results.toString())
    }

}