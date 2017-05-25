@file:Suppress("CAST_NEVER_SUCCEEDS")


/**
 * Created by lishaowei on 2017/5/25.
 */

fun main(arg: Array<String>) {
    val arrayOf = arrayOf<Int>(1, 2, 3)
//    val intArrayOf = intArrayOf(1, 2, 3)
//    println(intArrayOf.countPositive())
//    val filter = arrayOf.filter { it > 2 }
//    println(filter)
    println(arrayOf.firstOrNull())
}

fun IntArray.countPositive() = this.filter { it > 0 }.size