package com.example.odongju.kotlinfcm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var token = FirebaseInstanceId.getInstance().getToken()

        println(token)

        tokeninput!!.setText("토큰값은: '"+token+"'"+"입니다.")

        // 로그로 토큰값 확인
        Log.e("token값: ", token.toString())


    }
}
