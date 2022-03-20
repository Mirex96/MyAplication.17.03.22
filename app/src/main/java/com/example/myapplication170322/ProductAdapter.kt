package com.example.myapplication170322

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ProductAdapter(
    private val onToast: (Product) -> Unit,
    private val onAdd: (Product) -> Unit,
    private val onDelete: (Product) -> Unit,
    private val onEdit: (Product) -> Unit,
    private val onInformationProduct: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {


    private var productList = listOf<Product>()
    fun setData(productList: List<Product>) {
        this.productList = productList
        notifyDataSetChanged()


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return productList.size
    }


    inner class ProductViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(product: Product) {
            itemView.findViewById<TextView>(R.id.name).text = product.name
            itemView.findViewById<TextView>(R.id.price).text = product.price

            itemView.findViewById<View>(R.id.onToast).setOnClickListener {
                onToast(product)
            }

            itemView.findViewById<View>(R.id.onAdd).setOnClickListener {
                onAdd(product)
            }

            itemView.findViewById<View>(R.id.onDelete).setOnClickListener {
                onDelete(product)
            }

            itemView.findViewById<View>(R.id.onEdit).setOnClickListener {
                onEdit(product)
            }

            itemView.setOnClickListener() {
                onInformationProduct(product)
            }


        }


    }


}