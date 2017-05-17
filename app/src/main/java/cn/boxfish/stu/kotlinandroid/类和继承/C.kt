package cn.boxfish.stu.kotlinandroid.类和继承

/**
 * Created by lishaowei on 2017/5/17.
 */
class C() : cn.boxfish.stu.kotlinandroid.A(), cn.boxfish.stu.kotlinandroid.B {
    override fun f() {
        super<A>.f()
        super<B>.f()
    }

    override fun b() {
        super.b()
    }
}