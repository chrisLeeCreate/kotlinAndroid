package cn.boxfish.stu.kotlinandroid.ui.activity

import android.widget.Toast
import cn.boxfish.stu.kotlinandroid.R
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : BaseActivity() {

    override fun getArgs() {

    }

    override fun setView(): Int = R.layout.activity_main

    override fun initView() {
        etUsername.text = "lishaowei"
        RxView.clicks(bt_button).throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe({
            Toast.makeText(applicationContext, "houshishadiao", Toast.LENGTH_SHORT).show();
        })
    }

    override fun setListener() {
    }
}
