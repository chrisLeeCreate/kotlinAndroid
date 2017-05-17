package cn.boxfish.stu.kotlinandroid.类和继承

/**
 * Created by lishaowei on 2017/5/17.
 */
sealed class Expr {
    class Const(val number: Double) : cn.boxfish.stu.kotlinandroid.类和继承.Expr()
    class Sum(val e1: cn.boxfish.stu.kotlinandroid.类和继承.Expr, val e2: cn.boxfish.stu.kotlinandroid.类和继承.Expr) : cn.boxfish.stu.kotlinandroid.类和继承.Expr()

    object NotANumber : cn.boxfish.stu.kotlinandroid.类和继承.Expr()

}