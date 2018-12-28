package com.study.iayout.kotlindatetimepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity() {
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        datepicker.setOnClickListener {
            showDatePicker()
        }
        timepicker.setOnClickListener {
            showTimePicker()
        }
    }

    fun showDatePicker(){
        DatePickerDialog(this,DatePickerDialog.OnDateSetListener{ datePicker, year,month, day ->
            print(year)

            // 개월수를 0부터 시작하므로 1을 추가해야 사람이 보는 개월수로 출력된다.
            print(month + 1)
            println(day)

        }, cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DATE)).show()

    }

    fun showTimePicker(){
        TimePickerDialog(this, TimePickerDialog.OnTimeSetListener{timePicker, hour, minute ->
            print(hour)
            println(minute)

        }, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),true).show()

    }
}
