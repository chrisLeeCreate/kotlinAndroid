package cn.boxfish.stu.kotlinandroid.ui.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import cn.boxfish.stu.kotlinandroid.R
import cn.boxfish.stu.kotlinandroid.adapter.MusicAdapter
import cn.boxfish.stu.kotlinandroid.bean.Songs
import cn.boxfish.stu.kotlinandroid.di.component.DaggerWebviewComponent
import cn.boxfish.stu.kotlinandroid.di.module.WebViewModule
import cn.boxfish.stu.kotlinandroid.ui.mvp.view.WebViewContract
import com.jakewharton.rxbinding.widget.RxTextView
import com.wingsofts.gankclient.bean.FuckGoods
import kotlinx.android.synthetic.main.activity_web_view.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class WebViewActivity : BaseActivity(), WebViewContract.View {
    override fun getDataSuccess(it: ArrayList<Songs>) {
        println(it.toString())
        mLists.clear()
        mLists.addAll(it)
        adapter.notifyDataSetChanged()

    }

    override fun getDataError() {
        println("houzishishadiao")
    }

    @Inject
    lateinit var presenter: WebViewContract.Presenter
    lateinit var adapter: MusicAdapter
    var mLists = ArrayList<Songs>()

    var fuckGoods: FuckGoods? = null


    override fun loadDaggerComponent() {
        DaggerWebviewComponent.builder()
                .webViewModule(WebViewModule(this)).build().inject(this)
    }

    override fun getArgs(bundle: Bundle?) {
        fuckGoods = bundle?.getSerializable("fuck") as FuckGoods
    }

    override fun setListener() {
        RxTextView.textChangeEvents(editSearch).debounce(500, TimeUnit.MILLISECONDS).subscribe({
            presenter.getData(it.text().toString())
        })
    }

    override fun initView() {
        adapter = MusicAdapter(mLists, activity)
        recycle.adapter = adapter
        recycle.layoutManager = LinearLayoutManager(activity)

    }

    override fun setView() = R.layout.activity_web_view

}
