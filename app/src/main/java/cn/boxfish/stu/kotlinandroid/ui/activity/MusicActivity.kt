package cn.boxfish.stu.kotlinandroid.ui.activity

import android.media.MediaPlayer
import android.os.Bundle
import cn.boxfish.stu.kotlinandroid.R
import cn.boxfish.stu.kotlinandroid.bean.Songs
import cn.boxfish.stu.kotlinandroid.di.component.DaggerMusicComponent
import cn.boxfish.stu.kotlinandroid.di.module.MusicModule
import cn.boxfish.stu.kotlinandroid.ui.mvp.view.MusicContract
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.activity_music_.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MusicActivity : BaseActivity(), MusicContract.View {
    override fun getDataSucc() {
        println("getData" + "MusicActivity")
    }

    @Inject
    lateinit var presenter: MusicContract.Presenter
    private var mediaPlayer: MediaPlayer? = null
    private var songs: Songs? = null

    override fun getArgs(bundle: Bundle?) {
        songs = bundle?.getSerializable("song") as Songs

    }

    override fun setListener() {
        RxView.clicks(playMucis).throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe {
            mediaPlayer?.start()
        }
        RxView.clicks(pause).throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe {
            mediaPlayer?.pause()
        }
        RxView.clicks(stopMucis).throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe {
            mediaPlayer?.stop()
        }
    }

    override fun initView() {
        println("getData" + "initView")
        presenter.getData()
        println("songs" + songs.toString())
        mediaPlayer = MediaPlayer()
        mediaPlayer?.setDataSource(songs?.audio)
        mediaPlayer?.prepare()

    }

    override fun setView() = R.layout.activity_music_


    override fun loadDaggerComponent() {
        DaggerMusicComponent.builder()
                .musicModule(MusicModule(this)).build().inject(this)
    }

}
