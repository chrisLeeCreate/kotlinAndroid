package cn.boxfish.stu.kotlinandroid.extensions

import android.util.Log
import rx.Observable

/**
 * Created by lishaowei on 2017/6/2.
 */
fun <T> Observable<T>.register(funcation: (T) -> Unit) {
    this.subscribe({ granted ->
        funcation(granted)
    }, {
        it.printStackTrace()
        Log.e("permission2", "我没有权限")
    })
}