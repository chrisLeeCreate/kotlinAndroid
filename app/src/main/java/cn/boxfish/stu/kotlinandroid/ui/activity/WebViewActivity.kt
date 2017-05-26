package cn.boxfish.stu.kotlinandroid.ui.activity

import android.os.Bundle
import cn.boxfish.stu.kotlinandroid.R
import cn.boxfish.stu.kotlinandroid.di.component.DaggerWebviewComponent
import cn.boxfish.stu.kotlinandroid.di.module.WebViewModule
import cn.boxfish.stu.kotlinandroid.ui.mvp.view.WebViewContract
import com.wingsofts.gankclient.bean.FuckGoods
import kotlinx.android.synthetic.main.activity_web_view.*
import javax.inject.Inject

class WebViewActivity : BaseActivity(), WebViewContract.View {

    @Inject
    lateinit var presenter: WebViewContract.Presenter
    var fuckGoods: FuckGoods? = null
    override fun getDataSuccess() {
        println("WebViewActivity")
    }

    override fun loadDaggerComponent() {
        DaggerWebviewComponent.builder()
                .webViewModule(WebViewModule(this)).build().inject(this)
    }

    override fun getArgs(bundle: Bundle?) {
        fuckGoods = bundle?.getSerializable("fuck") as FuckGoods
    }

    override fun setListener() {

    }

    override fun initView() {
        presenter.getData()
        webView.loadUrl(fuckGoods?.url)
    }

    override fun setView() = R.layout.activity_web_view

}
