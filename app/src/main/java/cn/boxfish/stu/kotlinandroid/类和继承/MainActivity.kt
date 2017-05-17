package cn.boxfish.stu.kotlinandroid.类和继承

class MainActivity : android.support.v7.app.AppCompatActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(cn.boxfish.stu.kotlinandroid.R.layout.activity_main)
        fujiuhong()
    }

    fun fujiuhong() {
        var x = 1
        var info: String = "info"
        var XA: Int = 1;
        android.util.Log.e("sa", "ds")
        val sum = sum(x, XA)
        print(sum)
        print(sum1(x, XA))
        printSum(x, XA)
        val person = cn.boxfish.stu.kotlinandroid.Person("lishaowei")
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun sum1(a: Int, b: Int) = a + b

    fun printSum(a: Int, b: Int): Unit {
        print(a + b)
    }

}
