package com.example.simplecalculator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNumber1 = findViewById<EditText>(R.id.etNumber1)
        val etNumber2 = findViewById<EditText>(R.id.etNumber2)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSub = findViewById<Button>(R.id.btnSub)
        val btnMul = findViewById<Button>(R.id.btnMul)
        val btnDiv = findViewById<Button>(R.id.btnDiv)

        val tvResult = findViewById<TextView>(R.id.tvResult)

        fun getNumbers(): Pair<Double, Double>? {
            val num1 = etNumber1.text.toString()
            val num2 = etNumber2.text.toString()

            if (num1.isNotEmpty() && num2.isNotEmpty()) {
                return Pair(num1.toDouble(), num2.toDouble())
            }
            tvResult.text = "Please enter both numbers"
            return null
        }

        btnAdd.setOnClickListener {
            val numbers = getNumbers()
            numbers?.let {
                tvResult.text = "Result: ${it.first + it.second}"
            }
        }

        btnSub.setOnClickListener {
            val numbers = getNumbers()
            numbers?.let {
                tvResult.text = "Result: ${it.first - it.second}"
            }
        }

        btnMul.setOnClickListener {
            val numbers = getNumbers()
            numbers?.let {
                tvResult.text = "Result: ${it.first * it.second}"
            }
        }

        btnDiv.setOnClickListener {
            val numbers = getNumbers()
            numbers?.let {
                if (it.second != 0.0) {
                    tvResult.text = "Result: ${it.first / it.second}"
                } else {
                    tvResult.text = "Cannot divide by zero"
                }
            }
        }
    }
}
