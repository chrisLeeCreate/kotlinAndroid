package cn.boxfish.stu.kotlinandroid.ui.mvp.view

import cn.boxfish.stu.kotlinandroid.bean.JsonResul
import cn.boxfish.stu.kotlinandroid.bean.Songs
import io.reactivex.Observable

/**
 * Created by lishaowei on 2017/5/26.
 */
interface WebViewContract {
    interface Presenter {
        fun getData(type: String)
    }

    interface View {
        fun getDataSuccess(it: ArrayList<Songs>)
        fun getDataError()
    }

    interface Interactor {
        fun getData(type: String): Observable<JsonResul>
    }
}