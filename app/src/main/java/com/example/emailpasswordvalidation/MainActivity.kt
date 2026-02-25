package com.example.emailpasswordvalidation

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnValidate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Linking UI components
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnValidate = findViewById(R.id.btnValidate)

        btnValidate.setOnClickListener {
            validateFields()
        }
    }

    private fun validateFields() {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        // i) Check if fields are empty
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Both fields should not be empty", Toast.LENGTH_SHORT).show()
            return
        }

        // ii) Validate proper college email ID
        if (!isValidCollegeEmail(email)) {
            etEmail.error = "Enter a valid college email ID (example: student@college.edu)"
            etEmail.requestFocus()
            return
        }

        // iii) Password validation:
        // Minimum 12 characters, 1 uppercase, 1 number, 1 special symbol
        if (!isValidPassword(password)) {
            etPassword.error =
                "Password must be 12+ characters with 1 uppercase, 1 number & 1 special symbol"
            etPassword.requestFocus()
            return
        }

        // If all validations pass
        Toast.makeText(this, "Validation Successful!", Toast.LENGTH_LONG).show()
    }

    private fun isValidCollegeEmail(email: String): Boolean {
        // Standard email pattern check
        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        // College domain check (.edu / .edu.in)
        val isCollegeDomain = email.endsWith(".edu") ||
                email.endsWith(".edu.in") ||
                email.contains("@college")

        return isEmailValid && isCollegeDomain
    }

    private fun isValidPassword(password: String): Boolean {
        // Regex:
        // At least 1 uppercase, 1 digit, 1 special symbol, min 12 characters
        val passwordRegex = Regex("^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#\$%^&+=!]).{12,}$")
        return passwordRegex.matches(password)
    }
}