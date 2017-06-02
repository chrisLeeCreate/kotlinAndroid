package cn.boxfish.stu.kotlinandroid.di.component

import android.app.Activity
import cn.boxfish.stu.kotlinandroid.di.module.MusicModule
import cn.boxfish.stu.kotlinandroid.ui.activity.MusicActivity
import dagger.Component

/**
 * Created by lishaowei on 2017/6/2.
 */

@Component(modules = arrayOf(MusicModule::class))
interface MusicComponent {
    fun inject(activity: MusicActivity)
}
