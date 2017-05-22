package cn.boxfish.stu.kotlinandroid.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cn.boxfish.stu.kotlinandroid.R

/**
 * Created by lishaowei on 2017/5/22.
 */
class KotlinFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.frag_kotlin, container, false)
        return view
    }
}