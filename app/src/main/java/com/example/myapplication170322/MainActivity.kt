package com.example.myapplication170322

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


data class Product(
    val name: String,
    val price: String
)

const val KEY_EDIT_PRODUCT = "KEY_EDIT_PRODUCT"
const val KEY_PRODUCT = "KEY_PRODUCT"

class MainActivity : AppCompatActivity() {
    lateinit var product: Product

    private val defaultProductList = mutableListOf(
        Product("One", "1 rub."),
        Product("Two", "2 rub."),
        Product("Three", "3 rub."),
        Product("Four", "4 rub."),
        Product("Five", "5 rub."),
        Product("Six", "6 rub."),
        Product("Seven", "7 rub."),
        Product("Eight", "8 rub."),
        Product("Nine", "9 rub."),
        Product("Ten", "10 rub.")
    )


    private val adapter = ProductAdapter(::onToast, ::onAdd, ::onDelete, ::onEdit, ::onInformationProduct)

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productList = findViewById<RecyclerView>(R.id.productList)
        productList.adapter = adapter
        adapter.setData(defaultProductList)

    }


    private fun onToast(product: Product) {
        val pr = Toast.LENGTH_SHORT
        Toast.makeText(this, "$product", pr).show()
    }

    private fun onAdd(product: Product) {
        defaultProductList.add(product)
        adapter.setData(defaultProductList)
    }

    private fun onDelete(product: Product) {
        defaultProductList.remove(product)
        adapter.setData(defaultProductList)
    }

    private fun onInformationProduct(product: Product) {
        val intent = Intent(this, InformationProduct::class.java)
        intent.putExtra(KEY_PRODUCT,  product.toString())
        startActivity(intent)
    }

    private fun onEdit(product: Product) {
        val intent = Intent(this, EditProductActivity::class.java)
        intent.putExtra(KEY_EDIT_PRODUCT, product.toString())
        startActivityForResult(intent, 100)
        adapter.setData(defaultProductList)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 100 && resultCode == RESULT_OK && data != null) {
            val editProduct = data.getStringExtra(KEY_EDIT_PRODUCT)



        }

    }



}