package cn.boxfish.stu.kotlinandroid.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.tbruyelle.rxpermissions.RxPermissions
import rx.Observable

/**
 * Created by lishaowei on 2017/5/19.
 */
abstract class BaseActivity : AppCompatActivity() {
    lateinit var activity: Activity
    lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this
        context = this
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

    fun toast(message: String) {
        if (!checkActivityState()) return
        if (message.isNullOrEmpty()) return
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun checkActivityState(): Boolean {
        return !activity.isFinishing
    }

    fun startActivity(cls: Class<*>?, isFinished: Boolean) {
        startActivity(cls, null, isFinished)
    }

    fun startActivity(cls: Class<*>?, bundle: Bundle? = null, isFinished: Boolean = false) {
        if (cls == null || activity.isFinishing) return
        val intent = Intent()
        if (bundle != null)
            intent.putExtras(bundle)
        intent.setClass(activity, cls)
        startActivity(intent)
        if (isFinished)
            finish()
    }

    fun requestPermission(vararg permission: String): Observable<Boolean>? {
        val rxPermissions = RxPermissions(this)
        return rxPermissions.request(*permission)
    }
}