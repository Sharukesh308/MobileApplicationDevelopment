package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBasic = findViewById<Button>(R.id.btnBasic)
        val btnAdditional = findViewById<Button>(R.id.btnAdditional)

        
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, MovieBasicDetailsFragment())
            .commit()

        btnBasic.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MovieBasicDetailsFragment())
                .commit()
        }

        btnAdditional.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MovieAdditionalDetailsFragment())
                .commit()
        }
    }
}
