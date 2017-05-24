package cn.boxfish.stu.kotlinandroid.text

/**
 * Created by lishaowei on 2017/5/24.
 */
open class Person constructor(PersonName: String, var id: Int) {

    var name: String = "lishaowei"
    open var name2 = ""
    fun make() {
        MaxId
        mix()
    }

//    constructor(name: String) : this(name.hashCode().()) {
//        this.name = name
//    }

    companion object {
        @JvmStatic
        val anonymousPerson = Person("LI", 18)

        fun sayHello() {
            println(anonymousPerson.name)
        }
    }
}