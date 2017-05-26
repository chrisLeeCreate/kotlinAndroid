package cn.boxfish.stu.kotlinandroid.ui.mvp.interactor

import cn.boxfish.stu.kotlinandroid.ui.mvp.view.WebViewContract

/**
 * Created by lishaowei on 2017/5/26.
 */
class WebviewInteractor : WebViewContract.Interactor {
    override fun getData() {
        println("WebviewInteractor")
    }
}