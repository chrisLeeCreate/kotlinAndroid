package cn.boxfish.stu.kotlinandroid.schedule;

import android.os.Bundle
import cn.boxfish.stu.kotlinandroid.R
import cn.boxfish.stu.kotlinandroid.ui.activity.BaseActivity


/**
 * @author lishaowei
 * @Package cn.boxfish.stu.kotlinandroid.schedule
 * @Description: $description
 * @date 2017/06/06
 */
class ScheduleActivity : BaseActivity(),ScheduleContract.View{

    override fun getArgs(bundle: Bundle?) {}

    override fun setView(): Int {
        return R.layout.activity_main
    }

    override fun initView() { }

    override fun setListener() {
    }
    override fun loadDaggerComponent() {
    }

}