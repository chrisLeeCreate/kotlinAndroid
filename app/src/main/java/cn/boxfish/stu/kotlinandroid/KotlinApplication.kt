package cn.boxfish.stu.kotlinandroid

import android.app.Application
import android.content.Context
import com.mcxiaoke.packer.helper.PackerNg

/**
 * Created by lishaowei on 2017/5/19.
 */
class KotlinApplication : Application() {
    lateinit var instance: KotlinApplication
    override fun onCreate() {
        super.onCreate()
        val market = PackerNg.getMarket(context(), "lishaowei")
    }

    fun context(): Context {
        return instance.applicationContext
    }
}