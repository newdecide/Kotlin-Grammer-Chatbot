package com.example.odongju.kotlinboradcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBoradCastTeceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
//        Toast.makeText(context,"리시버 테스트",Toast.LENGTH_SHORT).show()

        when (intent!!.action){
            Intent.ACTION_BOOT_COMPLETED -> context!!.startActivity(Intent(context,MainActivity::class.java))
            Intent.ACTION_BATTERY_LOW -> Toast.makeText(context,"배터리가 없습니다",Toast.LENGTH_SHORT).show()
            "android.net.conn.CONNECTIVITY_CHANGE" -> Toast.makeText(context,"네트워크 상태가 변경 되었습니다.",Toast.LENGTH_SHORT).show()
            "android.provider.Telephony.SMS_RECEIVED" -> Toast.makeText(context,"문자가 도착했습니다.",Toast.LENGTH_SHORT).show()
            Intent.ACTION_CAMERA_BUTTON -> Toast.makeText(context,"카메라버튼을 클릭하였습니다.",Toast.LENGTH_SHORT).show()
            Intent.ACTION_SHUTDOWN -> Toast.makeText(context,"디바이스가 종료됩니다.",Toast.LENGTH_SHORT).show()
            Intent.ACTION_AIRPLANE_MODE_CHANGED -> Toast.makeText(context,"비행기모드로 전환됩니다.",Toast.LENGTH_SHORT).show()
            Intent.ACTION_DATE_CHANGED -> Toast.makeText(context,"날짜가 변경되었습니다.",Toast.LENGTH_SHORT).show()
            Intent.ACTION_TIME_TICK -> Toast.makeText(context,"분이 변경되었습니다.",Toast.LENGTH_SHORT).show()
        }
    }
}