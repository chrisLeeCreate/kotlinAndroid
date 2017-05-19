package cn.boxfish.stu.kotlinandroid.ui.activity

import android.widget.Toast
import cn.boxfish.stu.kotlinandroid.R
import cn.boxfish.stu.kotlinandroid.mvp.model.MainIntrator
import cn.boxfish.stu.kotlinandroid.mvp.presenter.MainPresenter
import cn.boxfish.stu.kotlinandroid.mvp.view.MainContract
import com.jakewharton.rxbinding.view.RxView.clicks
import com.wingsofts.gankclient.bean.FuckGoods
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : BaseActivity(), MainContract.View {

    override fun getArgs() {

    }

    override fun setView(): Int = R.layout.activity_main

    override fun initView() {

        etUsername.text = "lishaowei"
    }

    override fun setListener() {
        clicks(bt_button).throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe({
            val mainPresenter = MainPresenter(this, MainIntrator())
            mainPresenter.getData("1")
            Toast.makeText(applicationContext, "houshishadiao", Toast.LENGTH_SHORT).show()
        })
    }

    override fun getDataSuccess(goods: FuckGoods) {
        print(goods.toString())
        print(goods.createdAt)
        print(goods.url)
        Toast.makeText(applicationContext, "houshishadiao", Toast.LENGTH_SHORT).show()
    }

}
