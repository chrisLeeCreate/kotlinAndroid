package cn.boxfish.stu.kotlinandroid.text.`null`

/**
 * Created by lishaowei on 2017/5/31.
 */
fun getSum() {
    val arrayOf = arrayOf(1, 3, 4, 4)
    val count = arrayOf.count()
    val size = arrayOf.size
    println(arrayOf.conutSice())
    println(count)
    println(size)
    run {  }

}


fun main(args: Array<String>) {
    getSum()
}

fun <T> Array<T>.conutSice(): Int {
    return this.size
}