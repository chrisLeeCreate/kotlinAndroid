package cn.boxfish.stu.kotlinandroid.ui.mvp.presenter

import cn.boxfish.stu.kotlinandroid.ui.mvp.view.MusicContract

/**
 * Created by lishaowei on 2017/6/2.
 */
class MusicPresenter(var view: MusicContract.View, var musicIntractor: MusicContract.Interactor) : MusicContract.Presenter {
    override fun kotlin() {
        val listOf = listOf<String>("lishaowei", "libing", "shijiao", "jiuge", "houzi")
        for (s in listOf.filter { it.length > 5 }) {
            println(s)
        }
    }

    override fun getData() {
        println("getData" + "MusicPresenter")
        musicIntractor.getDataInteractor()
        view.getDataSucc()
    }
}
