package cn.boxfish.stu.kotlinandroid.ui.activity

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by lishaowei on 2017/5/19.
 */
abstract class BaseActivity : AppCompatActivity() {
    lateinit var activity: Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this
        getArgs(intent.extras)
        setContentView(setView())
        runOnUiThread { loadDaggerComponent() }
        initView()
        setListener()
    }

    abstract fun loadDaggerComponent()

    abstract fun getArgs(bundle: Bundle?)

    abstract fun setListener()

    abstract fun initView()

    abstract fun setView(): Int
}