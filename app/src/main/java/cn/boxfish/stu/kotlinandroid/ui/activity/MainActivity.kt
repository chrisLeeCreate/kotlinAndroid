package cn.boxfish.stu.kotlinandroid.ui.activity

import android.Manifest
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import cn.boxfish.stu.kotlinandroid.BuildConfig
import cn.boxfish.stu.kotlinandroid.R
import cn.boxfish.stu.kotlinandroid.di.component.DaggerMainComponent
import cn.boxfish.stu.kotlinandroid.di.module.MainModule
import cn.boxfish.stu.kotlinandroid.extensions.register
import cn.boxfish.stu.kotlinandroid.ui.fragment.AndroidFragment
import cn.boxfish.stu.kotlinandroid.ui.fragment.IOSFragment
import cn.boxfish.stu.kotlinandroid.ui.fragment.JavaFragment
import cn.boxfish.stu.kotlinandroid.ui.fragment.KotlinFragment
import cn.boxfish.stu.kotlinandroid.ui.mvp.view.MainContract
import com.jakewharton.rxbinding2.view.RxView.clicks
import com.tbruyelle.rxpermissions2.RxPermissions
import com.wingsofts.gankclient.bean.FuckGoods
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    lateinit var fragments: MutableList<Fragment>
    override fun getArgs(bundle: Bundle?) {

    }

    override fun setView(): Int = R.layout.activity_main
    override fun loadDaggerComponent() {
        DaggerMainComponent.builder().mainModule(MainModule(this)).build().inject(this)
    }

    override fun initView() {
        if (!BuildConfig.Debug) {
            requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE)
                    ?.register({
                        Log.e("permission2", "我有权限")
                        if (BuildConfig.PrintLog) {
                            toast("我有权限")
                        }
                    })
        }
        initFragment()
        vp_fragments.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getCount() = fragments.size
            override fun getItem(position: Int) = fragments[position]
        }
        navigationView.setOnNavigationItemSelectedListener {
            var tab = 0
            when (it.itemId) {
                R.id.menu_android -> tab = 0
                R.id.menu_ios -> tab = 1
                R.id.menu_girl -> tab = 2
                R.id.menu_about -> tab = 3
            }
            vp_fragments.currentItem = tab
            false
        }

    }

    fun initFragment() {
        fragments = ArrayList()
        fragments.add(AndroidFragment())
        fragments.add(IOSFragment())
        fragments.add(KotlinFragment())
        fragments.add(JavaFragment())
    }

    override fun setListener() {
//        clicks(floatingActionButton).throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe({
//            requestPermission(Manifest.permission.CAMERA)?.subscribe { granted ->
//                if (granted) {
//                    Log.e("permission2", "我有权限，你要我怎样")
//                } else {
//                    Log.e("permission2", "我没有权限")
//                }
//            }
//        })

        clicks(floatingActionButton)
                .compose(RxPermissions(this).ensure(Manifest.permission.CAMERA))
                .subscribe({ granted ->
                    if (granted) {
                        Log.e("permission2", "我有权限，你要我怎样")

                    } else {
                        Log.e("permission2", "我没有权限")
                    }
                })

    }

    override fun getDataSuccess(goods: FuckGoods) {
        Log.d("li", goods.toString())
    }

}
