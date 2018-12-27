package com.study.iayout.kotlinspinner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // 나라와 도시 이름 array 문자열 생성
    var countries = arrayOf("한국","미국")
    var city_korea = arrayOf("서울","대전","부산")
    var city_usa = arrayOf("뉴욕","워싱턴","로스엔젤레스")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adapter 초기 설정
        var countryAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,countries)
        spinner_country.adapter = countryAdapter

        // 나라 이름 선택 리스너
        spinner_country.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // spinner_city에 어댑터 연결 한국과 미국 선택
                var country = parent!!.getItemAtPosition(position)
                if(country == "한국") {
                    var adapter = ArrayAdapter<String>(this@MainActivity, android.R.layout.simple_spinner_dropdown_item,city_korea)
                    spinner_city.adapter = adapter

                } else if(country == "미국"){
                    var adapter = ArrayAdapter<String>(this@MainActivity, android.R.layout.simple_spinner_dropdown_item,city_usa)
                    spinner_city.adapter = adapter
                }
            }

        }
        // 도시 이름 선택 리스너
        spinner_city.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var country = parent!!.getItemAtPosition(position).toString()
                // 로스엔젤레스만 를이 어울려 를을 조건문으로 구분해주어 토스트로 보여줍니다.
                if(country == "로스엔젤레스") {
                    Toast.makeText(this@MainActivity, country + "를 선택하셨습니다.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, country + "을 선택하셨습니다.", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}
