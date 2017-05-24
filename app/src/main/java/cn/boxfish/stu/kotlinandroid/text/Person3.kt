package cn.boxfish.stu.kotlinandroid.text

/**
 * Created by lishaowei on 2017/5/24.
 */
class Person3(var name: String) {
    lateinit var hello: String
    fun inithELLO() {
        hello = "hello world"
    }
}

fun main(arg: Array<String>) {
    val person3 = cn.boxfish.stu.kotlinandroid.text.Person3("li")
    person3.inithELLO()
    println(person3.hello)
}