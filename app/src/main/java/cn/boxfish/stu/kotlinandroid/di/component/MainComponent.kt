package cn.boxfish.stu.kotlinandroid.di.component

import cn.boxfish.stu.kotlinandroid.di.module.MainModule
import cn.boxfish.stu.kotlinandroid.ui.activity.MainActivity
import dagger.Component

/**
 * Created by lishaowei on 2017/5/26.
 */
@Component(modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}