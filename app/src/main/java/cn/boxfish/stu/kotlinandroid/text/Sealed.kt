package cn.boxfish.stu.kotlinandroid.text

/**
 * Created by lishaowei on 2017/5/24.
 */
sealed class Sealed(var name: String, val age: Int) {
    class Adult(name: String, age: Int) : Person(name, age)
    class Child(name: String, age: Int) : Person(name, age)
}