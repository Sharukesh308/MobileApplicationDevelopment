package com.example.tooglebutton

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ToggleButton
    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggle = findViewById(R.id.toggleButton)
        text = findViewById(R.id.messageText)

        toggle.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {
                text.visibility = View.VISIBLE
            } else {
                text.visibility = View.GONE
            }

        }
    }
}
