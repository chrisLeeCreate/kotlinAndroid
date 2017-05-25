package cn.boxfish.stu.kotlinandroid.text.collection

/**
 * Created by lishaowei on 2017/5/25.
 */
fun main(a: Array<String>) {
//    val mutableListOf = mutableListOf<Int>(1, 2, 3)
//    mutableListOf.swap(1, 2)
//    mutableListOf.forEach {
//        println("i=" + it)
//    }
//    println(mutableListOf)
//
//    var n = 3
//    println(n.isOdd)
//    var num = "1"
//    println(num.toInt())
    var sum: (i: Int, j: Int) -> Int = fun(a: Int, b: Int) = a + b
    var sum1 = fun(a: Int, b: Int) = a + b
    var sum2 = { a: Int, b: Int -> a + b }


    sum(1, 2)
    summ(1, ands(1, 2), ::ands)
    ands(1, 2)
    summ(1, 3, ::jias)

}

fun <T> MutableList<T>.swap(indexA: Int, indexB: Int) {
    val temp = this[indexA]
    this[indexA] = this[indexB]
    this[indexB] = temp
}

fun summ(inta: Int, intb: Int, arg: (i: Int, j: Int) -> Int): Int {
    return arg(inta, intb)
}

fun ands(i: Int, j: Int): Int {
    return i + j
}

fun jias(a: Int, b: Int): Int {
    return a + b
}

val Int.isOdd: Boolean
    get() = this and 1 == 1