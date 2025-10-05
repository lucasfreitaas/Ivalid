package com.example.ivalid

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class ProductAdapter(private var productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.product_image)
        val productName: TextView = itemView.findViewById(R.id.product_name)
        val productQuantity: TextView = itemView.findViewById(R.id.product_quantity)
        val productOldPrice: TextView = itemView.findViewById(R.id.product_old_price)
        val productNewPrice: TextView = itemView.findViewById(R.id.product_new_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_card, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]

        holder.productImage.setImageResource(product.imageResourceId)

        holder.productName.text = product.name
        holder.productQuantity.text = product.quantity
        holder.productNewPrice.text = product.newPrice

        holder.productOldPrice.text = product.oldPrice
        holder.productOldPrice.paintFlags = holder.productOldPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }

    override fun getItemCount(): Int = productList.size

    fun updateProducts(newProducts: List<Product>){
        this.productList = newProducts
        notifyDataSetChanged()
    }
}
