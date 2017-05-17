package cn.boxfish.stu.kotlinandroid.接口

/**
 * Created by lishaowei on 2017/5/17.
 */
interface MyInterface {
    fun bar()

    var property: Int

    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        print(property)
    }
}