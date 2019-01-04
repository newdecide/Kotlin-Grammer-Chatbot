package com.example.kotlincalcifer

import ai.api.AIConfiguration
import ai.api.AIDataService
import ai.api.model.AIRequest
import ai.api.model.Result
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import com.google.firebase.firestore.FirebaseFirestore
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    var messageDTOs = arrayListOf<MessageDTO>()
    var aiDataService: AIDataService? = null
    var dateFormatFromString = SimpleDateFormat("yyyy-MM-dd")

    var weatherDateFormatFromString = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
    var weatherDateFormatToString = SimpleDateFormat("MM월 dd일 hh시")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview.adapter = MyRecylcerViewAdapter(messageDTOs)
        recyclerview.layoutManager = LinearLayoutManager(this)
        var config = AIConfiguration("5084e2a8272b47908c9f0055b3897a94", AIConfiguration.SupportedLanguages.Korean)
        aiDataService = AIDataService(config)
        button.setOnClickListener {
            if (!TextUtils.isEmpty(editText.text)) {
                messageDTOs.add(MessageDTO(true, editText.text.toString()))
                recyclerview.adapter.notifyDataSetChanged()
                recyclerview.smoothScrollToPosition(messageDTOs.size - 1)
                TalkAsyncTask().execute(editText.text.toString())
                editText.setText("")
            }


        }
    }

    inner class TalkAsyncTask : AsyncTask<String, Void, Result>() {
        override fun doInBackground(vararg params: String?): Result? {

            var aiRequest = AIRequest()
            aiRequest.setQuery(params[0])
            return aiDataService?.request(aiRequest)?.result
        }

        override fun onPostExecute(result: Result?) {
            if (result != null) {
                makeMessage(result)
            }
        }

    }

    fun makeMessage(result: Result) {

        when (result.metadata.intentName) {
            "Weather" -> {
                var city = result.parameters["geo-city"]
                if (city == null) {
                    weatherMessage("서울특별시")
                } else {
                    weatherMessage(city.asString)
                }
            }

            "Schedule" -> {
                var date = result.parameters["date"]?.asString
                if (date == null) {
                    var dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
                    scheduleMessage(dayOfWeek)
                } else {
                    var dateFromString = dateFormatFromString.parse(date)

                    var cal = Calendar.getInstance()
                    cal.time = dateFromString
                    var dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)
                    scheduleMessage(dayOfWeek)
                }


            }
            "Meal" -> {

                var meal = result.parameters["meal"]?.asString
                var date = result.parameters["date"]?.asString

                if(date == null){
                    date = dateFormatFromString.format(Date())
                }
                mealMessage(meal,date)

            }
            else -> {
                var speech = result.fulfillment.speech
                messageDTOs.add(MessageDTO(false, speech))
                recyclerview.adapter.notifyDataSetChanged()
                recyclerview.smoothScrollToPosition(messageDTOs.size - 1)
            }

        }
    }
    fun mealMessage(meal : String?, date : String?){

        FirebaseFirestore.getInstance().collection("meals").whereEqualTo("mealtime",meal).whereEqualTo("date",date).get().addOnCompleteListener {
            task ->
            if(task.isSuccessful){
                for(document in task.result){

                    var message = "메뉴는 " + document.data["menu"] + " 입니다."
                    messageDTOs.add(MessageDTO(false,message))
                    recyclerview.adapter.notifyDataSetChanged()
                    recyclerview.smoothScrollToPosition(messageDTOs.size - 1)
                     break
                }
            }
        }
    }

    fun weatherMessage(city: String) {

        var weatherUrl = "https://api.openweathermap.org/data/2.5/forecast?id=524901&APPID=e672212a01a640e7415425b6feca726b&q=" + city + "&units=metric"
        var request = Request.Builder().url(weatherUrl).build()
        OkHttpClient().newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {

            }

            override fun onResponse(call: Call?, response: Response?) {
                var result = response?.body()?.string()

                var weatherDTO = Gson().fromJson(result, WeatherDTO::class.java)
                for (item in weatherDTO.list!!) {
                    var weatherItemUnixTime = weatherDateFormatFromString.parse(item.dt_txt).time
                    if (weatherItemUnixTime > System.currentTimeMillis()) {
                        //온도
                        var temp = item.main?.temp
                        //날씨 상태
                        var description = item.weather!![0].description
                        //시간
                        var time = weatherDateFormatToString.format(weatherItemUnixTime)
                        //습도
                        var humidity = item.main?.humidity

                        var message = time + " " + city + "의 기온은 " + temp + "도 하늘은 " + description + "습도는 " + humidity + "% 입니다."
                        runOnUiThread {
                            messageDTOs.add(MessageDTO(false, message))
                            recyclerview.adapter.notifyDataSetChanged()
                            recyclerview.smoothScrollToPosition(messageDTOs.size - 1)
                        }
                        break

                    }
                }
            }

        })
    }

    fun scheduleMessage(dayOfWeek: Int?) {
        var dayOfWeekString: String? = null
        when (dayOfWeek) {
            1 -> {
                dayOfWeekString = "월요일"
            }
            2 -> {
                dayOfWeekString = "월요일"
            }
            3 -> {
                dayOfWeekString = "화요일"
            }
            4 -> {
                dayOfWeekString = "수요일"
            }
            5 -> {
                dayOfWeekString = "목요일"
            }
            6 -> {
                dayOfWeekString = "금요일"
            }
            7 -> {
                dayOfWeekString = "토요일"
            }
        }
        FirebaseFirestore.getInstance().collection("schedules").whereEqualTo("dayofweek", dayOfWeekString).get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                for (document in task.result) {
                    var message = dayOfWeekString + "의 수업은 " + document.data["lecture"] + "입니다."
                    messageDTOs.add(MessageDTO(false, message))
                    recyclerview.adapter.notifyDataSetChanged()
                    recyclerview.smoothScrollToPosition(messageDTOs.size - 1)
                    break
                }
            }
        }

    }
}
