package cn.boxfish.stu.kotlinandroid.类和继承

/**
 * Created by lishaowei on 2017/5/16.
 */
data class Customer(var name: String, val email: String) {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
        println("name")
    }

    fun foo(a: Int = 0, b: String = "") {}

    init {

    }

    var customerKey = name.toUpperCase()


}