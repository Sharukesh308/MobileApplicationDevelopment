package com.example.temperatureconverter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etTemperature = findViewById<EditText>(R.id.etTemperature)
        val btnToCelsius = findViewById<Button>(R.id.btnToCelsius)
        val btnToFahrenheit = findViewById<Button>(R.id.btnToFahrenheit)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnToFahrenheit.setOnClickListener {
            val input = etTemperature.text.toString()

            if (input.isEmpty()) {
                Toast.makeText(this, "Please enter a temperature", Toast.LENGTH_SHORT).show()
            } else {
                val celsius = input.toDouble()
                val fahrenheit = (celsius * 9/5) + 32
                tvResult.text = "Fahrenheit: %.2f °F".format(fahrenheit)
            }
        }

        btnToCelsius.setOnClickListener {
            val input = etTemperature.text.toString()

            if (input.isEmpty()) {
                Toast.makeText(this, "Please enter a temperature", Toast.LENGTH_SHORT).show()
            } else {
                val fahrenheit = input.toDouble()
                val celsius = (fahrenheit - 32) * 5/9
                tvResult.text = "Celsius: %.2f °C".format(celsius)
            }
        }
    }
}