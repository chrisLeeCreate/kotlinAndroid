package cn.boxfish.stu.kotlinandroid.mvp.presenter

import cn.boxfish.stu.kotlinandroid.mvp.model.MainIntrator
import cn.boxfish.stu.kotlinandroid.mvp.view.MainContract
import rx.android.schedulers.AndroidSchedulers.mainThread

/**
 * Created by lishaowei on 2017/5/19.
 */
class MainPresenter(var view: MainContract.View, var interator: MainIntrator) : MainContract.Presenter {
    override fun getData(page: String) {
        val subscribe = interator.mainInteractor(page).observeOn(mainThread())
                .subscribe({
                    print(it.error)
                    print(it.results.toString())
                })
    }

}