package cn.boxfish.stu.kotlinandroid.类和继承

/**
 * Created by lishaowei on 2017/5/16.
 */
open class Base {
    fun getStringLength(obj: Any): Int? {
        if (obj is String && obj.length > 0) {
            return obj.length
        }
        return null
    }

    fun main(args: Array<String>) {
        for (arg in args) {
            print(arg)
        }
    }
    open fun lishaowei(){}

}