package com.study.iayout.kotlinrequestpermission

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.Manifest
import android.os.Build

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var calender = Manifest.permission.READ_CALENDAR
        var camera = Manifest.permission.CAMERA
        var contect = Manifest.permission.READ_CONTACTS

        var location = Manifest.permission.ACCESS_FINE_LOCATION
        var microphone = Manifest.permission.RECORD_AUDIO
        var phone = Manifest.permission.READ_PHONE_STATE

        var sensor = Manifest.permission.BODY_SENSORS
        var sms = Manifest.permission.SEND_SMS
        var storage = Manifest.permission.READ_EXTERNAL_STORAGE

//      마시멜로 버전 이상 이 권한을 허용해야 접근할수 있다. alt + enter 4번째 surround with if ....

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(calender, camera, contect, location, microphone, phone, sensor, sms, storage), 100)
        }


    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100) {
            for (i in permissions.indices) {
                println("권한 : " + permissions[i] + "허가 상태: " + grantResults[i])
            }
        }
    }
}

