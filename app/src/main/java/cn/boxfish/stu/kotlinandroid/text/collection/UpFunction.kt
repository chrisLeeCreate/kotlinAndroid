package cn.boxfish.stu.kotlinandroid.text.collection

/**
 * Created by lishaowei on 2017/5/25.
 */
class UpFunction {

}

fun main(arg: Array<String>) {
    val arrayOf = arrayOf(1, 2, 3)
    val mutableListOf = mutableListOf<Int>()
    val mapTo = arrayOf.mapTo(mutableListOf, ::square)
    mapTo.forEach {
        println(it)
    }

    val mapTo1 = arrayOf.mapTo(mutableListOf, fun(a: Int) = a * a)
    mapTo1.forEach {
        println(it)
    }
    val mapTo2 = arrayOf.mapTo(mutableListOf, { a: Int -> a * a })
    val mapTo3 = arrayOf.mapTo(mutableListOf) { a: Int -> a * a }
    val mapTo4 = arrayOf.mapTo(mutableListOf) { it * it }
    mapTo2.forEach {
        println(it)
    }

    var sum = { a: Int -> a * a }

    val mapOf = mapOf(1 to 2, 4 to 5)
    mapOf.forEach { t, u ->
        println("t:$t u:$u")
    }
}

fun square(a: Int) = a * a