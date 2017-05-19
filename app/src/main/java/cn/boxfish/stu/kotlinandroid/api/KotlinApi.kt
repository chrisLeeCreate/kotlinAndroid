package cn.boxfish.stu.kotlinandroid.api

import cn.boxfish.stu.kotlinandroid.mvp.model.JsonResult
import com.wingsofts.gankclient.bean.FuckGoods
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by lishaowei on 2017/5/19.
 */
interface KotlinApi {

    /**
     *  data/Android/10/{page}
     */
    @GET("data/Android/10/{page}")
    fun getData(@Path("page") path: String): Observable<JsonResult<List<FuckGoods>>>

}