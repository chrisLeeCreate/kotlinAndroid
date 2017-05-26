package cn.boxfish.stu.kotlinandroid.di.module

import cn.boxfish.stu.kotlinandroid.mvp.model.MainIntrator
import cn.boxfish.stu.kotlinandroid.mvp.presenter.MainPresenter
import cn.boxfish.stu.kotlinandroid.mvp.view.MainContract
import dagger.Module
import dagger.Provides

/**
 * Created by lishaowei on 2017/5/26.
 */
@Module
class MainModule(private val view: MainContract.View) {
    @Provides
    fun getMainV(): MainContract.View {
        return view
    }

    @Provides
    fun getMainP(interator: MainContract.Model): MainContract.Presenter {
        return MainPresenter(view, interator)
    }

    @Provides
    fun getMainM(): MainContract.Model {
        return MainIntrator()
    }
}