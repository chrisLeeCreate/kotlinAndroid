package cn.boxfish.stu.kotlinandroid.mvp.model

import cn.boxfish.stu.kotlinandroid.api.KotlinApi
import cn.boxfish.stu.kotlinandroid.api.getInternetInstance
import cn.boxfish.stu.kotlinandroid.mvp.view.MainContract
import com.wingsofts.gankclient.bean.FuckGoods
import rx.Observable

/**
 * Created by lishaowei on 2017/5/19.
 */
class MainIntrator() : MainContract.Model {
    override fun mainInteractor(type: String): Observable<JsonResult<List<FuckGoods>>> {
        val create = getInternetInstance().create(KotlinApi::class.java)
        return create.getData(type)
    }

}