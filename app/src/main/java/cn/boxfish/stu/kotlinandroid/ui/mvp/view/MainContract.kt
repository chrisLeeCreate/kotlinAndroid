package cn.boxfish.stu.kotlinandroid.ui.mvp.view

import cn.boxfish.stu.kotlinandroid.mvp.model.JsonResult
import com.wingsofts.gankclient.bean.FuckGoods
import io.reactivex.Observable

/**
 * Created by lishaowei on 2017/5/19.
 */
interface MainContract {
    interface View {
        fun getDataSuccess(goods: FuckGoods)
    }

    interface Model {
        fun mainInteractor(type: String): Observable<JsonResult<List<FuckGoods>>>
    }

    interface Presenter {
        fun getData(page: String)
    }
}