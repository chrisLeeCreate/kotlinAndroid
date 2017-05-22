package cn.boxfish.stu.kotlinandroid.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.boxfish.stu.kotlinandroid.R
import cn.boxfish.stu.kotlinandroid.mvp.model.KongfuIntrator
import cn.boxfish.stu.kotlinandroid.mvp.presenter.KongFuPresenter
import cn.boxfish.stu.kotlinandroid.mvp.view.KongfuContract
import com.wingsofts.gankclient.bean.FuckGoods

/**
 * Created by lishaowei on 2017/5/22.
 */
class IOSFragment : Fragment(), KongfuContract.View {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.frag_ios, container, false)
        initView()
        return view
    }

    fun initView() {
        val kongFuPresenter = KongFuPresenter(this, KongfuIntrator())
        kongFuPresenter.getData(1, IOS)
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
        Log.d(IOS, results.toString())
    }

}