package cn.boxfish.stu.kotlinandroid.ui.mvp.presenter

import cn.boxfish.stu.kotlinandroid.ui.mvp.view.WebViewContract
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by lishaowei on 2017/5/26.
 */
class WebviewPresenter(var view: WebViewContract.View, var interactor: WebViewContract.Interactor) : WebViewContract.Presenter {
    override fun getData(type: String) {
        val subscribe = interactor.getData(type).observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    print(it.result.toString())
                    print(it.code)
                    view.getDataSuccess(it.result.songs!!)
                }, {
                    view.getDataError()
                })
    }
}