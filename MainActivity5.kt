package com.example.userprofile

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    // Shared Preferences keys
    private val PREFS_NAME = "UserProfilePrefs"
    private val KEY_NAME = "name"
    private val KEY_EMAIL = "email"
    private val KEY_AGE = "age"
    private val KEY_COLOR_ID = "color_id"
    private val KEY_BIO = "bio"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etAge = findViewById<EditText>(R.id.etAge)
        val rgColor = findViewById<RadioGroup>(R.id.rgColor)
        val etBio = findViewById<EditText>(R.id.etBio)
        val btnSave = findViewById<Button>(R.id.btnSave)

        // 1. Automatically load data when app opens
        val sharedPref = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        etName.setText(sharedPref.getString(KEY_NAME, ""))
        etEmail.setText(sharedPref.getString(KEY_EMAIL, ""))
        etAge.setText(sharedPref.getInt(KEY_AGE, 0).toString())
        etBio.setText(sharedPref.getString(KEY_BIO, ""))

        // Restore RadioGroup selection
        val savedColorId = sharedPref.getInt(KEY_COLOR_ID, -1)
        if (savedColorId != -1) {
            rgColor.check(savedColorId)
        }

        // 2. Save data on button click
        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val age = etAge.text.toString().toIntOrNull() ?: 0
            val bio = etBio.text.toString()
            val selectedColorId = rgColor.checkedRadioButtonId

            val editor = sharedPref.edit()
            editor.putString(KEY_NAME, name)
            editor.putString(KEY_EMAIL, email)
            editor.putInt(KEY_AGE, age)
            editor.putString(KEY_BIO, bio)
            editor.putInt(KEY_COLOR_ID, selectedColorId)

            // Use apply() for asynchronous saving (better performance)
            editor.apply()

            Toast.makeText(this, "Profile Saved!", Toast.LENGTH_SHORT).show()
        }
    }
