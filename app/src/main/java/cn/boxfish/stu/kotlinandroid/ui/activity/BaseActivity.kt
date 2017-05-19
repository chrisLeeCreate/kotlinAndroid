package cn.boxfish.stu.kotlinandroid.ui.activity

import android.app.Activity
import android.os.Bundle

/**
 * Created by lishaowei on 2017/5/19.
 */
abstract class BaseActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        getArgs()
        setContentView(setView())
        initView()
        setListener()
    }

    abstract fun getArgs()

    abstract fun setListener()

    abstract fun initView()

    abstract fun setView(): Int
}