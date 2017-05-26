package cn.boxfish.stu.kotlinandroid.ui.mvp.presenter

import android.util.Log
import cn.boxfish.stu.kotlinandroid.ui.mvp.model.KongfuIntrator
import cn.boxfish.stu.kotlinandroid.ui.mvp.view.KongfuContract
import rx.android.schedulers.AndroidSchedulers

/**
 * Created by lishaowei on 2017/5/22.
 */
class KongFuPresenter(val view: KongfuContract.View, var interator: KongfuIntrator) : KongfuContract.Presenter {
    override fun getData(page: Int, type: String) {
        interator.getIntrarator(page, type).observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view.getDataSucc(it.results)
                    Log.e("li", it.results.toString())

                }, {
                })
    }

}