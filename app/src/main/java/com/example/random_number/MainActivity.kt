package com.example.random_number

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etMin = findViewById<EditText>(R.id.etMin)
        val etMax = findViewById<EditText>(R.id.etMax)
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnGenerate.setOnClickListener {

            val minText = etMin.text.toString()
            val maxText = etMax.text.toString()

            if (minText.isNotEmpty() && maxText.isNotEmpty()) {

                val min = minText.toInt()
                val max = maxText.toInt()

                if (min < max) {
                    val randomNumber = Random.nextInt(min, max + 1)
                    tvResult.text = "Random Number: $randomNumber"
                } else {
                    tvResult.text = "Minimum must be less than Maximum"
                }

            } else {
                tvResult.text = "Please enter both values"
            }
        }
    }
}
