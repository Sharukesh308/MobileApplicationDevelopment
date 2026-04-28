package com.example.learning9

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val etUserName:EditText
        val etId:EditText
        val logBtn:Button
        val display:TextView

        etUserName=findViewById(R.id.editTextText)
        etId=findViewById(R.id.editTextText2)
        logBtn=findViewById(R.id.button)
        display=findViewById(R.id.textView2)

        logBtn.setOnClickListener{
            val userName=etUserName.text.toString().trim()
            val id=etId.text.toString().trim()
            if(!userName.isNotEmpty()&&!id.isNotEmpty()){
                display.setText("please enter all the fields")
                return@setOnClickListener
            }
            if(!userName.matches(Regex("^[a-zA-Z]+$"))){
                display.setText("the username must contain only characters")
                return@setOnClickListener
            }
            if(!id.matches(Regex("^\\d{4}$"))){
                display.setText("the id must need to be exactly 4 digits")
                return@setOnClickListener
            }

            display.setText("Login is successfull")

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
