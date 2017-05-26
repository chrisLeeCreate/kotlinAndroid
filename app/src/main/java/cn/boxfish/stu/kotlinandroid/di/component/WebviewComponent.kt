package cn.boxfish.stu.kotlinandroid.di.component

import cn.boxfish.stu.kotlinandroid.di.module.WebViewModule
import cn.boxfish.stu.kotlinandroid.ui.activity.WebViewActivity
import dagger.Component

/**
 * Created by lishaowei on 2017/5/26.
 */
@Component(modules = arrayOf(WebViewModule::class))
interface WebviewComponent {

    fun inject(activity: WebViewActivity)
}