package cn.boxfish.stu.kotlinandroid.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import cn.boxfish.stu.kotlinandroid.R
import cn.boxfish.stu.kotlinandroid.adapter.GirlAdapter
import cn.boxfish.stu.kotlinandroid.mvp.model.KongfuIntrator
import cn.boxfish.stu.kotlinandroid.mvp.presenter.KongFuPresenter
import cn.boxfish.stu.kotlinandroid.mvp.view.KongfuContract
import com.wingsofts.gankclient.bean.FuckGoods



/**
 * Created by lishaowei on 2017/5/22.
 */
class JavaFragment : Fragment(), KongfuContract.View {
    var mLists = ArrayList<FuckGoods>()
    var page: Int = 1
    lateinit var mAdapter: GirlAdapter


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.frag_java, container, false)
        initView(view)
        return view
    }

    fun initView(view: View?) {
        val kongFuPresenter = KongFuPresenter(this, KongfuIntrator())
        kongFuPresenter.getData(1, JAVA)

        mAdapter = GirlAdapter(mLists, activity)
        val recycle2 = view!!.findViewById(R.id.rv_girl) as RecyclerView
        recycle2.adapter = mAdapter
        recycle2.itemAnimator=DefaultItemAnimator()
        recycle2.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recycle2.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (!recyclerView?.canScrollVertically(1)!!) {
                    kongFuPresenter.getData(page++, IOSFragment.IOS)
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
        val JAVA = "JAVA"
        fun newInstance(): JavaFragment {
            val fragment = JavaFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getDataSucc(results: List<FuckGoods>) {
        Log.d(JAVA, results.toString())
        mLists.addAll(results)
        mAdapter.notifyDataSetChanged()
    }
}