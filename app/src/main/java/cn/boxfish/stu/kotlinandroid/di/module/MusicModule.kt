package cn.boxfish.stu.kotlinandroid.di.module

import cn.boxfish.stu.kotlinandroid.ui.mvp.interactor.MusicIntractor
import cn.boxfish.stu.kotlinandroid.ui.mvp.presenter.MusicPresenter
import cn.boxfish.stu.kotlinandroid.ui.mvp.view.MusicContract
import dagger.Module
import dagger.Provides

/**
 * Created by lishaowei on 2017/6/2.
 */
@Module
class MusicModule(var view: MusicContract.View) {
    @Provides
    fun getMusicI(): MusicContract.Interactor {
        return MusicIntractor()
    }

    @Provides
    fun getMusicP(intractor: MusicContract.Interactor): MusicContract.Presenter {
        return MusicPresenter(view, intractor)
    }
}