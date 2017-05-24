package cn.boxfish.stu.kotlinandroid.text

import java.util.*

/**
 * Created by lishaowei on 2017/5/23.
 */
class Test {
    var intKotlin = 1
    var intKotlin2: Int = 2
    var ines: Long = intKotlin.toLong()
    val d: String = "li"
}

fun main(args: Array<String>) {
//    println(Test().d)
//    println(add(1))
//    println(add(1, 2))
//    println(add(1, 1, 1))
//    println(add(1, 1, 1, 3, 2, 2, 1, 2))
//    var c: Char = '2'
//    print(c.toInt() == 2)
    var s: String = "123456"
    for (ch in s) {
        println(ch)
    }
    var a = arrayOf("hello", "world")
    a.forEach {
        println(it)
    }

    val arrayOfNulls = arrayOfNulls<Int>(0)
    val emptyArray = emptyArray<Int>()
    print("是否一致" + Arrays.equals(arrayOfNulls, emptyArray))

    val array = Array<Int>(10, { i -> i * 2 - 2 })
    array.forEach {
        println(it)
    }
}

fun add(a: Int, b: Int = 1, c: Int = 0): Int {
    return a + b + c
}

fun add(a: Int, b: Int, vararg n: Int): Int {
    var sum = a + b
//    n.forEach {
//        sum += it
//    }
    n.sum()
    for (ha in n) {
        sum += ha
    }
    return sum
}