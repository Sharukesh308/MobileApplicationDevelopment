package com.example.checkboxdemo

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var pizza: CheckBox
    lateinit var burger: CheckBox
    lateinit var coffee: CheckBox
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pizza = findViewById(R.id.checkPizza)
        burger = findViewById(R.id.checkBurger)
        coffee = findViewById(R.id.checkCoffee)
        button = findViewById(R.id.btnBill)

        button.setOnClickListener {

            var total = 0

            if (pizza.isChecked) {
                total += 150
            }

            if (burger.isChecked) {
                total += 120
            }

            if (coffee.isChecked) {
                total += 80
            }

            Toast.makeText(this, "Total Bill = ₹$total", Toast.LENGTH_LONG).show()
        }
    }
}
