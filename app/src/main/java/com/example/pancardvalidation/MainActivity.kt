package com.example.pancardvalidation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etPan: EditText
    private lateinit var etPincode: EditText
    private lateinit var btnValidate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPan = findViewById(R.id.etPan)
        etPincode = findViewById(R.id.etPincode)
        btnValidate = findViewById(R.id.btnValidate)

        btnValidate.setOnClickListener {

            val pan = etPan.text.toString().trim()
            val pincode = etPincode.text.toString().trim()

            // i) Check if fields are empty
            if (pan.isEmpty() || pincode.isEmpty()) {
                Toast.makeText(this, "Both fields should not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // ii) PAN Validation (Alphanumeric & exactly 10 characters)
            val panPattern = Regex("^[A-Za-z0-9]{10}$")
            if (!panPattern.matches(pan)) {
                Toast.makeText(
                    this,
                    "PAN must be alphanumeric and exactly 10 characters",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // iii) Pincode Validation (Numeric & exactly 6 digits)
            val pincodePattern = Regex("^[0-9]{6}$")
            if (!pincodePattern.matches(pincode)) {
                Toast.makeText(
                    this,
                    "Pincode must be numeric and exactly 6 digits",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // If all validations pass
            Toast.makeText(this, "Validation Successful!", Toast.LENGTH_LONG).show()
        }
    }
}