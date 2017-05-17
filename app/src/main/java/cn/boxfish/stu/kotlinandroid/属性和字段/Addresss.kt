package cn.boxfish.stu.kotlinandroid.属性和字段

/**
 * Created by lishaowei on 2017/5/17.
 */
public class Addresss {
    public var name: String = "lishaowei"
    public var street: String = "heziyu"
    public var city: String = "beijing"
    public var state: String = "coder"
    var allByDefault: Int? = null
    var initialized = 1


    //备用字段
    var counter = 0 //初始化值会直接写入备用字段
        set(value) {
            if (value >= 0)
                field  = value
        }
}