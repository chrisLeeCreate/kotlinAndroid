package cn.boxfish.stu.kotlinandroid.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by lishaowei on 2017/5/19.
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        getArgs()
        setContentView(setView())
        initView()
        runOnUiThread { loadDaggerComponent() }
        setListener()
    }

    abstract fun loadDaggerComponent()

    abstract fun getArgs()

    abstract fun setListener()

    abstract fun initView()

    abstract fun setView(): Int
}