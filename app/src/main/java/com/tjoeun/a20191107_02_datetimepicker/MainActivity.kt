package com.tjoeun.a20191107_02_datetimepicker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        selectTimeBtn.setOnClickListener {
            var timePickerDialog = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->

                var selectdTime = Calendar.getInstance()
                selectdTime.set(Calendar.HOUR_OF_DAY, hourOfDay)
                selectdTime.set(Calendar.MINUTE, minute)

                var sdf = SimpleDateFormat("a h:m")
                timeTxt.text = sdf.format(selectdTime.time)

            }, 10,20,true)
            timePickerDialog.show()
        }



        selectDateBtn.setOnClickListener {
            var datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                var selectdDate = Calendar.getInstance()

                //원하는 항목별로 직접 입력
                selectdDate.set(Calendar.YEAR, year)

                //년/월/일을 한번에 집어넣기
                selectdDate.set(year, month, dayOfMonth)

                var sdf = SimpleDateFormat("yyyy년 MM월 dd일")
                var resultStr = sdf.format(selectdDate.time)
                dateTxt.text = resultStr

//                dateTxt.text = "${year}년 ${month+1}월 ${dayOfMonth}일"

            },2019,Calendar.NOVEMBER,7)
            datePickerDialog.show()
        }
    }

    override fun setValues() {

    }

}
