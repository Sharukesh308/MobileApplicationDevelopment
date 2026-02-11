package com.example.techlounge

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvCount = findViewById<TextView>(R.id.tvCount)
        val btnCheckIn = findViewById<Button>(R.id.btnCheckIn)
        val btnCheckOut = findViewById<Button>(R.id.btnCheckOut)

        btnCheckIn.setOnClickListener {
            count++
            tvCount.text = count.toString()
        }

        btnCheckOut.setOnClickListener {
            if (count > 0) {
                count--
                tvCount.text = count.toString()
            }
        }
    }
}
