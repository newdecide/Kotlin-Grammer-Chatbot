package com.study.iayout.kotlinviewpager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // viewpager에 ViewPagerAdapter 연결
        viewpager.adapter = kotlinViewPagerAdapter(supportFragmentManager)

        // 탭 목록 이름 입력
        tablayout.addTab(tablayout.newTab().setText("Fragment1"))
        tablayout.addTab(tablayout.newTab().setText("Fragment2"))
        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            // 탭 클릭시 탭화면으로 이동
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewpager.setCurrentItem(tab!!.position)
            }

        })
        viewpager.addOnPageChangeListener(object : TabLayout.TabLayoutOnPageChangeListener(tablayout) {})

    }

    class kotlinViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        var fragments = arrayOf(Fragment1(), Fragment2())
        // 화면을 넣어주는 부분
        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        // 페이지 갯수를 세는 부분
        override fun getCount(): Int {
            return fragments.size
        }

    }


}
