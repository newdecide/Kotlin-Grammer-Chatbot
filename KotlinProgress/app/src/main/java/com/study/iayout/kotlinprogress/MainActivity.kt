package com.study.iayout.kotlinprogress

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 불확정성 버튼을 클리하면 불확정성 프로그래스바가 생성됩니다.
        button1.setOnClickListener {
            progressBar1.visibility = View.VISIBLE
        }

        // 확정성 버튼을 클릭하면 학정성 프로그래스바가 0~100까지 차게 됩니다.(반복됨)
        button2.setOnClickListener {
            object : AsyncTask<Void, Void, Void>() {
                override fun doInBackground(vararg params: Void?): Void? {

                    var i = 0
                    while (i <= 100) {
                        progressBar2.setProgress(i)
                        i = i + 1
                        Thread.sleep(100) //0.1초
                    }
                    return null
                }

            }.execute() // AsyncTask 실행
        }
    }
}
