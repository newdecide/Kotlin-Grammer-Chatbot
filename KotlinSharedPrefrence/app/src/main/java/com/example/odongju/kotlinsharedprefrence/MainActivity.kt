package com.example.odongju.kotlinsharedprefrence

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // SharedPreferences 객체
        var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        // SharedPreferences 수정 객
        var edit = sharedPreferences.edit()

        // 글자를 가져오는 부분
       var save_string = sharedPreferences.getString("userId","아이디를 입력해주세요.")
        editText.setText(save_string)

        // 글자를 입력하는 부분
        button.setOnClickListener {
            edit.putString("userId", editText.text.toString()).commit()
        }

        //논리값 저장 (True, False)
        edit.putBoolean("myBoolean",true).commit()
        //Int값 저장(-2의 32 제곱 값 +2의 32 제곱 값)
        edit.putInt("myInt",1).commit()
        //Float값 저장(소숫점 7짜리 까지 저장)
        edit.putFloat("myFloat",0.1f).commit()
        //Long값저장 (-2의 64 제곲 값 +2의 64 제곲 값 )
        edit.putLong("myLong", 1L).commit()
        //setString값저장(set<String> 값 저장)
        edit.putStringSet("mySetString", setOf("a","b")).commit()

        //논리값 가져오기
        var bool = sharedPreferences.getBoolean("myBoolean",false)
        //Int값 가져오기
        var int = sharedPreferences.getInt("myInt",1)
        //Float값 가져오기
        var float = sharedPreferences.getFloat("myFloat",0.1f)
        //Long값저장 가져오기
        var long = sharedPreferences.getLong("myLong", 1L)
        //setString값 가져오기
        var setString = sharedPreferences.getStringSet("mySetString", setOf("a","b"))
    }
}
