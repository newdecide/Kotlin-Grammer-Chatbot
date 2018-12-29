package com.example.odongju.kotlincontext

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, MyFragment()).commit()

//        Toast.makeText(this,"토스트메시지 입니다.",Toast.LENGTH_SHORT).show()
    }
}
