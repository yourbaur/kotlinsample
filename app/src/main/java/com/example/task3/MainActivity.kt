package com.example.task3

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var am: AlarmManager
    var hour:Int =0
    var min:Int = 0
    lateinit var con:Context
    lateinit var pi:PendingIntent
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //this.con = this
        //am = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        //var myIntent: Intent = Intent(this, AlarmReceiver::class.java)
        val cal = Calendar.getInstance()
        pickTimeButton.setOnClickListener{

            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    cal.set(Calendar.HOUR_OF_DAY, hour)
                    cal.set(Calendar.MINUTE, minute)
                    cal.set(Calendar.SECOND, 0)
                    cal.set(Calendar.MILLISECOND, 0)
                } else {
                    cal.set(Calendar.HOUR_OF_DAY, timePicker.currentHour)
                    cal.set(Calendar.MINUTE, timePicker.currentMinute)
                    cal.set(Calendar.SECOND, 0)
                    cal.set(Calendar.MILLISECOND, 0)
                }
                print(cal.time)

                //pi = PendingIntent.getBroadcast(this@MainActivity, 0, myIntent, PendingIntent.FLAG_UPDATE_CURRENT)
                //myIntent.putExtra("extra", "on")
                //am.setExact(AlarmManager.RTC_WAKEUP, cal.timeInMillis, pi)
                timetv.text = SimpleDateFormat("HH:mm").format(cal.time)

            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }
        changeButton1.setOnClickListener {
            imageView2.setImageResource(R.drawable.like)
        }
        changeButton2.setOnClickListener {
            imageView2.setImageResource(R.drawable.dislike)
        }

    }
}
