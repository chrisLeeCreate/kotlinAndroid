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
    }

    interface Interactor {
        fun getDataInteractor()
    }
}