package cn.boxfish.stu.kotlinandroid.ui.mvp.interactor

import cn.boxfish.stu.kotlinandroid.ui.mvp.view.MusicContract

/**
 * Created by lishaowei on 2017/6/2.
 */
class MusicIntractor:MusicContract.Interactor{
    override fun getDataInteractor() {
        println("getData" + "getDataInteractor")

    }

}