package cn.boxfish.stu.kotlinandroid.ui.mvp.view

/**
 * Created by lishaowei on 2017/6/2.
 */
interface MusicContract {
    interface View {
        fun getDataSucc()
    }

    interface Presenter {
        fun getData()
        fun kotlin()
    }

    interface Interactor {
        fun getDataInteractor()
    }
}