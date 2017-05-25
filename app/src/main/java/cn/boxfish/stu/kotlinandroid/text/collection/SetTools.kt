package cn.boxfish.stu.kotlinandroid.text.collection

/**
 * Created by lishaowei on 2017/5/25.
 */
fun main(arg: Array<String>) {

    val hashSetOf = hashSetOf<Int>(1, 2, 1, 2, 3, 4, 4, 5)
    hashSetOf.add(6)
    hashSetOf.forEach {
        println(it)
    }
    println("++++++++++++")


    val of = mutableListOf<Int>()
    of.add(6)
    of.forEach {
        println(it)
    }

    val of1 = setOf(1, 2, 3)
    setOf(of, of1, 3, 4).forEach {
        println(it)
    }


    val listOf = listOf<Int>()
    val listOf1 = listOf(1, 2, 3)
    val listOf2 = listOf(listOf1)
    for (list in listOf(listOf, listOf1, listOf2)) {
        println(list)
    }
    println("++++++++++++")
    val listOf3 = listOf(listOf, listOf1, listOf2)
    listOf(listOf3).forEach {
        println(it)
    }
}