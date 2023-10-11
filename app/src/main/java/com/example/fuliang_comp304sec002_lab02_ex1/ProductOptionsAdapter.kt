package com.example.fuliang_comp304sec002_lab02_ex1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ProductOptionsAdapter(
  private val productOptions : List<ProductOption>
): RecyclerView.Adapter<ProductOptionsAdapter.ProductOptionViewHolder>() {

    inner class ProductOptionViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView
        val checkBox: CheckBox
        val imageView: ImageView

        init {
            textView = view.findViewById(R.id.tv_product_title)
            checkBox = view.findViewById(R.id.cb_product_select)
            imageView = view.findViewById(R.id.iv_product_image)
        }

    }

    // create new view (invoked by the layout manage)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductOptionViewHolder {

        // inflate the product_item_option layout to the parent view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item_option, parent, false)
        return ProductOptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductOptionViewHolder, position: Int) {

        // the inflated view of the product_item_option layout
        holder.apply {
            val product = productOptions[position]
            textView.text = product.title
            checkBox.isChecked = product.isChecked
            imageView.setImageResource(product.image)


            checkBox.setOnCheckedChangeListener { _, isChecked ->
                product.isChecked = isChecked
                //notifyItemChanged(holder.adapterPosition)
            }
        }
    }

    override fun getItemCount(): Int {
        return productOptions.size
    }
}