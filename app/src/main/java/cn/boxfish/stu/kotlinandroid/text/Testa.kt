package cn.boxfish.stu.kotlinandroid.text

/**
 * Created by lishaowei on 2017/5/23.
 */
class Testa {

}

fun main(args: Array<String>) {

    val intArrayOf = intArrayOf(5, 6, 7, 8, 9)
    for ((index, value) in intArrayOf.withIndex()) {
        println("arrayInt[$index] is $value")
    }
}