package cn.boxfish.stu.kotlinandroid.api

import cn.boxfish.stu.kotlinandroid.bean.JsonResul
import cn.boxfish.stu.kotlinandroid.mvp.model.JsonResult
import com.wingsofts.gankclient.bean.FuckGoods
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by lishaowei on 2017/5/19.
 */
interface KotlinApi {

    /**
     *  data/Android/10/{page}
     */
    @GET("data/Android/10/{page}")
    fun getData(@Path("page") path: String): Observable<JsonResult<List<FuckGoods>>>

    /**
     * Android所有数据
     */
    @GET("data/Android/10/{page}")
    fun getAndroidData(@Path("page") page: Int): Observable<JsonResult<List<FuckGoods>>>

    /**
     * iOS所有数据
     */
    @GET("data/iOS/10/{page}")
    fun getiOSData(@Path("page") page: Int): Observable<JsonResult<List<FuckGoods>>>

    /**
     * iOS所有数据
     */
    @GET("data/福利/10/{page}")
    fun getGirlData(@Path("page") page: Int): Observable<JsonResult<List<FuckGoods>>>

    /**
     * http://s.music.163.com/search/get/?type=1&limit=2&s=%E7%8E%8B%E8%8F%B2
     */

    @GET("search/get")
    fun getMusicData(@Query("type") type: String, @Query("limit") limit: String, @Query("s") s: String): Observable<JsonResul>
}