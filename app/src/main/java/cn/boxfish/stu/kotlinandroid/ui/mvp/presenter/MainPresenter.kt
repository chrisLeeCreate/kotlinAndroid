package cn.boxfish.stu.kotlinandroid.ui.mvp.presenter

import cn.boxfish.stu.kotlinandroid.mvp.model.JsonResult
import cn.boxfish.stu.kotlinandroid.ui.mvp.view.MainContract
import com.wingsofts.gankclient.bean.FuckGoods

/**
 * Created by lishaowei on 2017/5/19.
 */
class MainPresenter(var view: MainContract.View, var interator: MainContract.Model) : MainContract.Presenter {
    override fun getData(page: String) {
        val subscribe = interator.mainInteractor(page)
                .subscribe({ it: JsonResult<List<FuckGoods>> ->
                    print(it.error)
                    print(it.results.toString())
                    view.getDataSuccess(it.results[0])
                }, { e -> e.printStackTrace() })
    }
}