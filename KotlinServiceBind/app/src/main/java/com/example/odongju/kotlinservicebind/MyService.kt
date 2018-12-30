package com.example.odongju.kotlinservicebind

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class MyService : Service() {

    var message : String? = null
    override fun onCreate() {
        super.onCreate()
        message = "서비스가 작동 중입니다."
    }

    inner class MyBinder : Binder(){
        fun getService() : MyService{
            return this@MyService
        }
    }
    override fun onBind(intent: Intent?): IBinder? {
        return MyBinder()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}