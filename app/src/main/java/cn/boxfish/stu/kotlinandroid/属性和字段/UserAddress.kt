package cn.boxfish.stu.kotlinandroid.属性和字段

/**
 * Created by lishaowei on 2017/5/17.
 */
class UserAddress {
    fun copyAddress(addresss: Addresss) {
        var result = Addresss()
        result.city = addresss.city
        result.name = addresss.name
    }
}