package com.example.odongju.kotlinservice

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService : Service() {

    // 서비스가 생성될때 작동
    override fun onCreate() {
        super.onCreate()
    }
    // 생성되기 직전에 작동

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        while (true){
//            Thread.sleep(3000)
//            println("서비스 실행 중입니다.")
//        }
//        return START_STICKY
        Thread {
            run {
                while (true) {
                    Thread.sleep(3000)
                    println("서비스 실행 중입니다.")
                }
            }
        }.start()
        return START_STICKY
    }

    // 서비스가 제거될 때 작동
    override fun onDestroy() {
        super.onDestroy()
    }


    override fun onBind(intent: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}