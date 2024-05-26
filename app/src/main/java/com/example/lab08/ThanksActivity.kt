package com.example.lab08

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.example.lab08.databinding.ActivityThanksBinding

class ThanksActivity : AppCompatActivity() {

    private lateinit var binding : ActivityThanksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThanksBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.nameTextView.text = intent.getStringExtra("name")
        binding.phoneTextView.text = intent.getStringExtra("phone")
        binding.sizeTextView.text = intent.getStringExtra("size")
        binding.pickupdateTextView.text = intent.getStringExtra("date")
        binding.pickuptimeTextView.text = intent.getStringExtra("time")

        binding.ratingBtn.setOnClickListener {
            binding.ratingTextView.text = binding.ratingBar.rating.toString()
        }

    }
}