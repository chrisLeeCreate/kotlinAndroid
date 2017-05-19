package cn.boxfish.stu.kotlinandroid.ui.activity

import cn.boxfish.stu.kotlinandroid.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun getArgs() {

    }

    override fun setView(): Int = R.layout.activity_main

    override fun initView() {
        etUsername.text = "lishaowei"
//        bt_button.click
    }

    override fun setListener() {
    }
}
