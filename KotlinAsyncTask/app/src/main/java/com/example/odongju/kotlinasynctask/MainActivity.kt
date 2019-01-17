package com.example.odongju.kotlinasynctask

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var async = object : AsyncTask<Int, Int, String>(){
            override fun doInBackground(vararg params: Int?): String {
                var position = params[0]!!
                while(position < 100){
                    Thread.sleep(100)
                    position=position+1
                    publishProgress(position)
                }
                return "다운로드가 끝났습니다."
            }

            override fun onProgressUpdate(vararg values: Int?) {
                super.onProgressUpdate(*values)
                textView.setText(values[0].toString() + "%")
            }

            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                textView.setText(result)
            }
        }
//        1 부터 시작
        async.execute(0)
    }
}
