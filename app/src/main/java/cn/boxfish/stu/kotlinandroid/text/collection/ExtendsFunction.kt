@file:Suppress("CAST_NEVER_SUCCEEDS")

import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable


/**
 * Created by lishaowei on 2017/5/25.
 */

fun main(arg: Array<String>) {
    val listOf = listOf<String>("lishaowei", "libing", "shijiao", "jiuge", "houzi")
    listOf.toObservable().filter { it.length > 5 }
            .map {
                "it is" + it
            }.subscribeBy(onNext = { println(it) },
            onError = { it.printStackTrace() },
            onComplete = { println("done") })

    for (s in listOf.filter { it.length > 5 }) {
        println(s)
    }
}

fun IntArray.countPositive() = this.filter { it > 0 }.size