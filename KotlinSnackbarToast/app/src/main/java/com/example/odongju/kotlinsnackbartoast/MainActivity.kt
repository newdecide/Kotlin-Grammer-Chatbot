package com.example.odongju.kotlinsnackbartoast

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toast.setOnClickListener {
            Toast.makeText(this, "토스트메세지", Toast.LENGTH_SHORT).show()
        }
        snackbar.setOnClickListener {
            Snackbar.make(mainView, "스낵바메시지", Snackbar.LENGTH_SHORT).show()
        }
    }
}
