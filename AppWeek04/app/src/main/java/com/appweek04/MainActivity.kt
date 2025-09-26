package com.appweek04

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val buttonGreat = findViewById<Button>(R.id.buttonGreat)
        val textViewGreating = findViewById<TextView>(R.id.textViewGreating)

        buttonGreat.setOnClickListener {
            val name = editTextName.text.toString().trim()

            var greating: String = ""

            if(name.isNotEmpty()){
                greating = "안녕하세요, ${name}님!"

            }else{
                greating = "이름을 입력해주세요"
            }
            textViewGreating.text = greating
            textViewGreating.visibility = View.VISIBLE
            Log.d("kotlinWeek04App", greating)
        }
    }
}