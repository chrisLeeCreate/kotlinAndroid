package cn.boxfish.stu.kotlinandroid.text

/**
 * Created by lishaowei on 2017/5/24.
 */
class Person2(name: String) {
    val age: Int
    val id: Long = 0
    var nationality: String = ""
    var name = name
        set(value) {
            field = if (value.isEmpty()) "" else value[0].toUpperCase() + value.substring(1)
        }

    val isValidName
        get() = !name.isEmpty()


    init {
        age = 0
    }
}

fun main(args: Array<String>) {
//    val person2 = cn.boxfish.stu.kotlinandroid.text.Person2("li")
//    println(person2.nationality)
//    person2.nationality = "lishaowei"
//    println(person2.nationality)
//    println(person2.isValidName)
//    println()
//    println(person2.name)
//    person2.name = "lishaowei"
//    println(person2.name)
//    Person.sayHello()
//    println(Person.anonymousPerson)
//    val copy = Libber("libing", 23).copy()
//    val copy2 = Libber("libing", 23).copy(name = "lishaowei")
//    println(copy.toString())
//    println(copy2.toString())
//    val (lbname, lbage) = copy
//    println("lb:" + lbname + "lbage:" + lbage)
//    for (i in mutableListOf(1, 2, 3, 4, 5, 6)) {
//        println("$i=" + i)
//    }
//    val arrayListOf = arrayListOf<Int>(1, 2, 3, 4)
//    arrayListOf.add(5)
//    val listOf = listOf<Int>(1, 2, 3, 4, 5)
//    listOf.add
    val mutableListOf = mutableListOf<Int>(1, 2, 3, 4)
    mutableListOf.add(5)
    for (i in listOfNotNull(1, 2, 3, 4, null, 5, 6, null, 7)) {
        println(i)
    }
    val binarySearch = mutableListOf.binarySearch(1, mutableListOf.size/2, 3)
    println("binarySearch"+binarySearch)
}

const val MaxId = Int.MAX_VALUE
internal fun mix() {
    println(cn.boxfish.stu.kotlinandroid.text.MaxId)
}