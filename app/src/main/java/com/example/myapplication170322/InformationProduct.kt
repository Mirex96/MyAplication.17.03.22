package com.example.myapplication170322

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class InformationProduct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information_product)

        val namePrice = findViewById<TextView>(R.id.namePrice)

        val button = findViewById<Button>(R.id.buttonBack)

        val key = intent.getStringExtra(KEY_PRODUCT)
        namePrice.text = key.toString()




        button.setOnClickListener() {
            finish()
        }
    }
}