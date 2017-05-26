package cn.boxfish.stu.kotlinandroid.ui.mvp.view

/**
 * Created by lishaowei on 2017/5/26.
 */
interface WebViewContract {
    interface Presenter {
        fun getData()
    }

    interface View {
        fun getDataSuccess()
    }

    interface Interactor {
        fun getData()
    }
}