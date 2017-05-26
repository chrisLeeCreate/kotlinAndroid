package cn.boxfish.stu.kotlinandroid.di.module

import cn.boxfish.stu.kotlinandroid.ui.mvp.interactor.MainIntrator
import cn.boxfish.stu.kotlinandroid.ui.mvp.presenter.MainPresenter
import cn.boxfish.stu.kotlinandroid.ui.mvp.view.MainContract
import dagger.Module
import dagger.Provides

/**
 * Created by lishaowei on 2017/5/26.
 */
@Module
class MainModule(private val view: MainContract.View) {
    @Provides
    fun getMainV(): MainContract.View {
        return view
    }

    @Provides
    fun getMainP(interator: MainContract.Model): MainContract.Presenter {
        return MainPresenter(view, interator)
    }

    @Provides
    fun getMainM(): MainContract.Model {
        return MainIntrator()
    }
}
/**
 * MainModlue是一个注解类，用@Module注解标注，主要用来提供依赖。
 * 等等，刚才通过@Inject就可以完成依赖，为什么这里还要用到Module类来提供依赖？
 * 之所以有Module类主要是为了提供那些没有构造函数的类的依赖，这些类无法用@Inject标注，
 * 比如第三方类库，系统类，以及上面示例的View接口。
 *
 *@Inject 带有此注解的属性或构造方法将参与到依赖注入中，Dagger2会实例化有此注解的类
@Module 带有此注解的类，用来提供依赖，里面定义一些用@Provides注解的以provide开头的方法，这些方法就是所提供的依赖，Dagger2会在该类中寻找实例化某个类所需要的依赖。
@Component 用来将@Inject和@Module联系起来的桥梁，从@Module中获取依赖并将依赖注入给@Inject
 *
 */
