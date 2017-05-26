package cn.boxfish.stu.kotlinandroid.ui.mvp.view

import cn.boxfish.stu.kotlinandroid.mvp.model.JsonResult
import com.wingsofts.gankclient.bean.FuckGoods
import rx.Observable

/**
 * Created by lishaowei on 2017/5/22.
 */
interface KongfuContract {
    interface View {
        fun getDataSucc(results: List<FuckGoods>)
    }

    interface Model {
        fun getIntrarator(page: Int, type: String): Observable<JsonResult<List<FuckGoods>>>
    }

    interface Presenter {
        fun getData(page: Int, type: String)
    }
}