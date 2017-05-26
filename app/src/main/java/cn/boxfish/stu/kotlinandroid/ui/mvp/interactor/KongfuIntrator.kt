package cn.boxfish.stu.kotlinandroid.ui.mvp.interactor

import cn.boxfish.stu.kotlinandroid.api.KotlinApi
import cn.boxfish.stu.kotlinandroid.api.getInternetInstance
import cn.boxfish.stu.kotlinandroid.mvp.model.JsonResult
import cn.boxfish.stu.kotlinandroid.ui.fragment.AndroidFragment.Companion.ANDROID
import cn.boxfish.stu.kotlinandroid.ui.fragment.IOSFragment.Companion.IOS
import cn.boxfish.stu.kotlinandroid.ui.fragment.JavaFragment.Companion.JAVA
import cn.boxfish.stu.kotlinandroid.ui.mvp.view.KongfuContract
import com.wingsofts.gankclient.bean.FuckGoods
import rx.Observable

/**
 * Created by lishaowei on 2017/5/22.
 */
class KongfuIntrator() : KongfuContract.Model {
    override fun getIntrarator(page: Int, type: String): Observable<JsonResult<List<FuckGoods>>> {
        var create = getInternetInstance().create(KotlinApi::class.java)
        when (type) {
            ANDROID -> return create.getAndroidData(page)
            IOS -> return create.getiOSData(page)
            JAVA -> return create.getGirlData(page)
            else -> return create.getAndroidData(page)
        }
    }

}