package cn.boxfish.stu.kotlinandroid.text.collection

/**
 * Created by lishaowei on 2017/5/24.
 */
class Box<out T>(val value: T)

fun text() {
    val box1: Box<Int> = Box(1)
    val box2 = Box(2)
    val boxIn = boxIn(1)
}

fun <T> boxIn(value: T) = Box(value)