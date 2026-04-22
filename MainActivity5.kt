package com.example.userprofile

import android.content.Context
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etAge: EditText
    private lateinit var etBio: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var btnSave: Button

    private val PREF_NAME = "UserProfile"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etAge = findViewById(R.id.etAge)
        etBio = findViewById(R.id.etBio)
        radioGroup = findViewById(R.id.radioGroup)
        btnSave = findViewById(R.id.btnSave)

        // Load saved data
        loadData()

        btnSave.setOnClickListener {
            saveData()
            Toast.makeText(this, "Profile Saved!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveData() {
        val sharedPref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.putString("name", etName.text.toString())
        editor.putString("email", etEmail.text.toString())
        editor.putString("age", etAge.text.toString())
        editor.putString("bio", etBio.text.toString())

        val selectedId = radioGroup.checkedRadioButtonId
        editor.putInt("color", selectedId)

        editor.apply()
    }

    private fun loadData() {
        val sharedPref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        etName.setText(sharedPref.getString("name", ""))
        etEmail.setText(sharedPref.getString("email", ""))
        etAge.setText(sharedPref.getString("age", ""))
        etBio.setText(sharedPref.getString("bio", ""))

        val selectedId = sharedPref.getInt("color", -1)
        if (selectedId != -1) {
            radioGroup.check(selectedId)
        }
    }
}
