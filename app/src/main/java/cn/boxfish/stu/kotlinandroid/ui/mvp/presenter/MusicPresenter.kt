package cn.boxfish.stu.kotlinandroid.ui.mvp.presenter

import cn.boxfish.stu.kotlinandroid.ui.mvp.view.MusicContract

/**
 * Created by lishaowei on 2017/6/2.
 */
class MusicPresenter(var view: MusicContract.View, var musicIntractor: MusicContract.Interactor) : MusicContract.Presenter {
    override fun getData() {
        println("getData" + "MusicPresenter")
        musicIntractor.getDataInteractor()
        view.getDataSucc()
    }
}