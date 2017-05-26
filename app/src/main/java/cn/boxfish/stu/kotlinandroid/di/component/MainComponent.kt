package cn.boxfish.stu.kotlinandroid.di.component

import cn.boxfish.stu.kotlinandroid.di.module.MainModule
import cn.boxfish.stu.kotlinandroid.ui.activity.MainActivity
import dagger.Component

/**
 * Created by lishaowei on 2017/5/26.
 */
@Component(modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}
/**
 * Component是一个接口或者抽象类，用@Component注解标注（这里先不管括号里的modules）
 * ，我们在这个接口中定义了一个inject()方法,参数是Mainactivity。
 * 然后rebuild一下项目，会生成一个以Dagger为前缀的Component类
 *
 *
 * 当看到某个类被@Inject标记时，就会到他的构造方法中，
 * 如果这个构造方法也被@Inject标记的话，就会自动初始化这个类，从而完成依赖注入。
 *
 *
 */
