package com.example.lab08

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.DatePicker
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab08.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    val pizzaSize = arrayOf("Your Pizza Size","Small","Medium","Large","ExtraLarge")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.schedulebtn.setOnClickListener {

            var intent = Intent(this, ThanksActivity::class.java)
            intent.putExtra("name",binding.nameEditText.text.toString())
            intent.putExtra("phone",binding.phoneEditText.text.toString())
            intent.putExtra("size",binding.pizzasizeTextView.text.toString())
            intent.putExtra("date",binding.dateTextView.text.toString())
            intent.putExtra("time",binding.timeTextView.text.toString())

            startActivity(intent)
        }

        binding.mySeekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {

            // bila seekbar berubah nilai
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.pizzasizeTextView.text = pizzaSize[progress]
            }

            // bila seekbaru ditekan
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                binding.pizzasizeTextView.text = "Your Pizza Size"
            }

            // bila seekbar habis ditekan
            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        binding.selectdatebtn.setOnClickListener {

            //Get the current date
            val c = Calendar.getInstance()
            val day = c.get(Calendar.DAY_OF_MONTH)
            val month = c.get(Calendar.MONTH)
            val year = c.get(Calendar.YEAR)

            // DatePicker ada 6 argument
            // 1) Dimana ia keluar (this - Main Activity)
            // 2) Design datePicker - Default called ThemeOverLay
            // 3) Listener -> setelah tarikh dipilih, what should be executed?
            // 4) Default year
            // 5) Default month
            // 6) Default day
            val myDatePicker =
                DatePickerDialog(
                    this,
                    android.R.style.ThemeOverlay,
                    DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                        // year, month, dayofMonth
                        binding.dateTextView.text = "$dayOfMonth/${month+1}/$year"
                    },
                    year,
                    month,
                    day
                )
            myDatePicker.show()
        }
        binding.selecttimebtn.setOnClickListener {

            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minute = c.get(Calendar.MINUTE)

            // Build Time Picker
            // 1 - Where the timepicker is built - here (MainActivity)
            // 2 - Listener - When the time is selected and what should be executed?
            // 3 - Default hour
            // 4 - Default minute
            // 5 - True for 24 hours time display
            val myTimePicker = TimePickerDialog (
                this,
                TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                                                   binding.timeTextView.text = "$hourOfDay:$minute"
                },
                hour,
                minute,
                true
            )
            myTimePicker.show()
        }
    }
}