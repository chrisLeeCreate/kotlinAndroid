package cn.boxfish.stu.kotlinandroid.ui.mvp.presenter

import cn.boxfish.stu.kotlinandroid.ui.mvp.view.WebViewContract

/**
 * Created by lishaowei on 2017/5/26.
 */
class WebviewPresenter(var view: WebViewContract.View, var interactor: WebViewContract.Interactor) : WebViewContract.Presenter {
    override fun getData() {
        interactor.getData()
        println("WebviewPresenter")
        view.getDataSuccess()

    }
}