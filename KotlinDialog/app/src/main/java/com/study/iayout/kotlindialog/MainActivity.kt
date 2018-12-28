package com.study.iayout.kotlindialog

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 메서드 호출
        button.setOnClickListener {
            showDialog()
        }

    }
    // 다이얼로그 함수
    fun showDialog(){
        // dialog builder 호출
        var builder = AlertDialog.Builder(this)
        // 다이얼로그 제목과 메시지
        builder.setTitle("알림")
        builder.setMessage("앱을 종료 하시겠습니까?")
        // 실수로 PostiveButton을 두번 쓸 경우 앞에거는 안나오고 뒤에거만 나 올 수 있습니다.
        builder.setPositiveButton("예", DialogInterface.OnClickListener{ dialog, which ->
            onBackPressed()
        })
        builder.setNegativeButton("아니오", DialogInterface.OnClickListener{dialog, which ->
            dialog.dismiss()
        }).show()
    }
}
