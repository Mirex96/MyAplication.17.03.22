package com.example.myapplication170322

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EditProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_product)

        val name = findViewById<EditText>(R.id.name)
        val price = findViewById<EditText>(R.id.price)


        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener() {
            val intent = Intent()
            intent.putExtra(KEY_EDIT_PRODUCT, name.text.toString())
            intent.putExtra(KEY_EDIT_PRODUCT, price.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }

    }
}