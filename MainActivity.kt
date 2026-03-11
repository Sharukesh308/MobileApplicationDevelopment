package com.example.radiobutton

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var layout: LinearLayout
    lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout = findViewById(R.id.mainLayout)
        radioGroup = findViewById(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->

            when (checkedId) {
                R.id.radioRed -> layout.setBackgroundColor(Color.RED)
                R.id.radioGreen -> layout.setBackgroundColor(Color.GREEN)
                R.id.radioBlue -> layout.setBackgroundColor(Color.BLUE)
            }
        }
    }
}
