package com.example.bmi_calculator


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etWeight = findViewById<EditText>(R.id.etWeight)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCalculate.setOnClickListener {

            val weightText = etWeight.text.toString()
            val heightText = etHeight.text.toString()

            if (weightText.isNotEmpty() && heightText.isNotEmpty()) {

                val weight = weightText.toDouble()
                val height = heightText.toDouble()

                val bmi = weight / (height * height)

                tvResult.text = "Your BMI is %.2f".format(bmi)

            } else {
                tvResult.text = "Please enter both values"
            }
        }
    }
}
