package cn.boxfish.stu.kotlinandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        fujiuhong()
    }

    fun fujiuhong() {
        var x = 1
        var info: String = "info"
        var XA: Int = 1;
        Log.e("sa", "ds")
        val sum = sum(x, XA)
        print(sum)
        print(sum1(x, XA))
        printSum(x,XA)
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun sum1(a: Int, b: Int) = a + b

    fun printSum(a: Int, b: Int): Unit {
        print(a + b);
    }

}
