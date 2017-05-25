package cn.boxfish.stu.kotlinandroid.text.collection

import cn.boxfish.stu.kotlinandroid.text.Person

/**
 * Created by lishaowei on 2017/5/24.
 */
interface KotlinG<out t> {
    fun nextT(): t
}

fun demo(s: KotlinG<Libing>) {
    var sl: KotlinG<Lishaowei> = s
    var s: List<Int> = listOf(1, 2, 3)
//    var s2: List<Number> = listOf(1, 2, 3)
    var s3: List<Number> = s
}

fun main(arg: Array<String>) {
    println(operator(2, 3, ::jia))
    println(operator(2, 3, ::cheng))
    println(Person::class.java)

    val listOf = listOf(1, 2, 3, 4)
    println(listOf[0])
}

fun operator(a: Int, b: Int, f: (a1: Int, b1: Int) -> Int): Int {
    return f(a, b)
}

fun jia(a: Int, b: Int): Int {
    return a + b
}

fun cheng(a: Int, b: Int): Int {
    return a * b
}