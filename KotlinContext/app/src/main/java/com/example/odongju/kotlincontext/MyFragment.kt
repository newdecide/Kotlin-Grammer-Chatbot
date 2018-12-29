package com.example.odongju.kotlincontext

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class MyFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.myfragment, container, false)
        Toast.makeText(activity, "프래그먼트 토스트메시지 입니다.",Toast.LENGTH_SHORT).show()
        return view
    }
}