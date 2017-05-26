package cn.boxfish.stu.kotlinandroid.di.module

import cn.boxfish.stu.kotlinandroid.ui.mvp.interactor.WebviewInteractor
import cn.boxfish.stu.kotlinandroid.ui.mvp.presenter.WebviewPresenter
import cn.boxfish.stu.kotlinandroid.ui.mvp.view.WebViewContract
import dagger.Module
import dagger.Provides

/**
 * Created by lishaowei on 2017/5/26.
 */
@Module
class WebViewModule(private val view: WebViewContract.View) {

    @Provides
    fun getWebviewV(): WebViewContract.Interactor {
        return WebviewInteractor()
    }

    @Provides
    fun getWebviewP(interactor: WebViewContract.Interactor): WebViewContract.Presenter {
        return WebviewPresenter(view, interactor)
    }
}