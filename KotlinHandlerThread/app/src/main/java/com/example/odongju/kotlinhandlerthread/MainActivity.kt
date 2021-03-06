package com.example.odongju.kotlinhandlerthread

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var thread = Thread{
            run {
                Thread.sleep(3000)
                Handler(Looper.getMainLooper()).post {
                    textview.setText("쓰레드 작동")
                }
            }
        }
        thread.start()
    }
}
