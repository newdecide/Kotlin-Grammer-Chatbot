package com.study.iayout.rcyclerviewkotlin2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 리사이클러뷰에 어댑터 연결 리니어레이아웃 매니저 세팅
        kotlin_recyclerview_list.adapter = MainRecyclerviewwAdapter()
        kotlin_recyclerview_list.layoutManager = LinearLayoutManager(this)

    }

    class MainRecyclerviewwAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

        // 데이터 입력
        var images = arrayOf(R.drawable.rail1, R.drawable.rail2, R.drawable.rail3, R.drawable.rail4)
        var title = arrayOf("프랑크푸르트","런던","파리","프라하")
        var countries = arrayOf("독일","영국","프랑스","체코")

        // 각각 아이템의 디자인 레이아웃을 불러온다.
        override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_layout, parent, false)

            return CustomViewHolder(view)
        }

        class CustomViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
            var imageview: ImageView? = null
            var textview: TextView? = null
            var textview2: TextView? = null

            init{
                imageview = view!!.findViewById(R.id.profile_img)
                textview = view.findViewById(R.id.title)
                textview2 = view.findViewById(R.id.country)

            }
        }

        // 아이템 갯구 카운터
        override fun getItemCount(): Int {
            return images.size
        }

        // 각각의 아이템에 데이터를 바인딩한다.
        override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
            var view = p0 as CustomViewHolder
            view.imageview!!.setImageResource(images[p1])
            view.textview!!.text = title[p1]
            view.textview2!!.text = countries[p1]
        }
    }
}
