package cn.boxfish.stu.kotlinandroid.bean

import java.io.Serializable

/**
 * Created by lishaowei on 2017/5/26.
 */

class Songs : Serializable {

    var id: Int = 0
    var name: String? = null
    var album: AlbumBean? = null
    var audio: String? = null
    var djProgramId: Int = 0
    var page: String? = null
    var artists: List<ArtistsBean>? = null

    class AlbumBean : Serializable {

        var id: Int = 0
        var name: String? = null
        var artist: ArtistBean? = null
        var picUrl: String? = null

        class ArtistBean : Serializable {

            var id: Int = 0
            var name: String? = null
            var picUrl: Any? = null
        }
    }

    class ArtistsBean : Serializable {

        var id: Int = 0
        var name: String? = null
        var picUrl: Any? = null
    }
}
