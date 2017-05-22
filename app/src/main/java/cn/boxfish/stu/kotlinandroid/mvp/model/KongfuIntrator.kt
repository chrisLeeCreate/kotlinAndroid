package cn.boxfish.stu.kotlinandroid.mvp.model

import cn.boxfish.stu.kotlinandroid.api.KotlinApi
import cn.boxfish.stu.kotlinandroid.api.getInternetInstance
import cn.boxfish.stu.kotlinandroid.mvp.view.KongfuContract
import cn.boxfish.stu.kotlinandroid.ui.fragment.AndroidFragment
import cn.boxfish.stu.kotlinandroid.ui.fragment.IOSFragment
import cn.boxfish.stu.kotlinandroid.ui.fragment.JavaFragment
import com.wingsofts.gankclient.bean.FuckGoods
import rx.Observable

/**
 * Created by lishaowei on 2017/5/22.
 */
class KongfuIntrator() : KongfuContract.Model {
    override fun getIntrarator(page: Int, type: String): Observable<JsonResult<List<FuckGoods>>> {
        var create = getInternetInstance().create(KotlinApi::class.java)
        when (type) {
            AndroidFragment.ANDROID -> return create.getAndroidData(page)
            IOSFragment.IOS -> return create.getiOSData(page)
            JavaFragment.JAVA -> return create.getGirlData(page)
            else -> return create.getAndroidData(page)
        }
    }

}