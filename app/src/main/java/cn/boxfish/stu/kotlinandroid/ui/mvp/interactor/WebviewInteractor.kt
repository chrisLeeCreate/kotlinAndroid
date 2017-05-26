package cn.boxfish.stu.kotlinandroid.ui.mvp.interactor

import cn.boxfish.stu.kotlinandroid.api.KotlinApi
import cn.boxfish.stu.kotlinandroid.api.getMusicInstance
import cn.boxfish.stu.kotlinandroid.bean.JsonResul
import cn.boxfish.stu.kotlinandroid.ui.mvp.view.WebViewContract
import rx.Observable

/**
 * Created by lishaowei on 2017/5/26.
 */
class WebviewInteractor : WebViewContract.Interactor {
    override fun getData(type: String): Observable<JsonResul> {
        val create = getMusicInstance().create(KotlinApi::class.java)
        return create.getMusicData("1", "10", type)
    }
}