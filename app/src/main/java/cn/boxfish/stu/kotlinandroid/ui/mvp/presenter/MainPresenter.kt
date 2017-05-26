package cn.boxfish.stu.kotlinandroid.ui.mvp.presenter

import cn.boxfish.stu.kotlinandroid.ui.mvp.view.MainContract
import rx.android.schedulers.AndroidSchedulers.mainThread

/**
 * Created by lishaowei on 2017/5/19.
 */
class MainPresenter(var view: MainContract.View, var interator: MainContract.Model) : MainContract.Presenter {
    override fun getData(page: String) {
        val subscribe = interator.mainInteractor(page).observeOn(mainThread())
                .subscribe({
                    print(it.error)
                    print(it.results.toString())
                    view.getDataSuccess(it.results[0])
                }, {

                })
    }

}