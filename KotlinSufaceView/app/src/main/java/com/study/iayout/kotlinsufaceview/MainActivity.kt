package com.study.iayout.kotlinsufaceview

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SurfaceHolder.Callback,MediaPlayer.OnPreparedListener {

    var surfaceHolder : SurfaceHolder? = null
    var mediaPlayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        surfaceHolder = surfaceView.holder
        surfaceHolder!!.addCallback(this)

        back.setOnClickListener{
            var position = mediaPlayer!!.currentPosition - 5000
            mediaPlayer!!.seekTo(position)
        }

        forward.setOnClickListener{
            var position = mediaPlayer!!.currentPosition + 5000
            mediaPlayer!!.seekTo(position)
        }

        stop.setOnClickListener{
            mediaPlayer!!.pause()
        }

        play.setOnClickListener {
            mediaPlayer!!.start()
        }
    }

    // 서피스 체인지 발생시 호출된다. 영상은 다른 영상 호출
    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {

    }
    // 서피스 체인지 종료시
    override fun surfaceDestroyed(holder: SurfaceHolder?) {

    }
    // 서피스뷰 생성이 될때 영상 만들어지기직전
    override fun surfaceCreated(holder: SurfaceHolder?) {
        var url ="https://www.radiantmediaplayer.com/media/bbb-360p.mp4"
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setDisplay(holder)
        mediaPlayer!!.setDataSource(url)
        mediaPlayer!!.prepare()
        mediaPlayer!!.setOnPreparedListener(this)

    }
    // 영상 준비가 완료되었을 때
    override fun onPrepared(mp: MediaPlayer?) {
        mediaPlayer!!.start()
    }


}
