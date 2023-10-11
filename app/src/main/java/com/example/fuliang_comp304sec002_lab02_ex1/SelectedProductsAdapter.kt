package com.example.fuliang_comp304sec002_lab02_ex1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SelectedProductsAdapter(
  private val productOptions : List<ProductOption>
): RecyclerView.Adapter<SelectedProductsAdapter.ProductOptionViewHolder>() {

    inner class ProductOptionViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView
        val radioButton: RadioButton
        val imageView: ImageView

        init {
            textView = view.findViewById(R.id.tv_selected_product)
            radioButton = view.findViewById(R.id.rb_product)
            imageView = view.findViewById(R.id.iv_checkout_product_image)
        }

    }

    // create new view (invoked by the layout manage)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductOptionViewHolder {

        // inflate the product_item_option layout to the parent view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.checkout_product_item, parent, false)
        return ProductOptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductOptionViewHolder, position: Int) {

        // the inflated view of the product_item_option layout
        holder.apply {
            val product = productOptions[position]
            textView.text = product.title
            radioButton.isChecked = product.isSelected
            imageView.setImageResource(product.image)


            radioButton.setOnClickListener {
                (it as RadioButton).isChecked = !product.isSelected
                product.isSelected = !product.isSelected
            }
        }
    }

    override fun getItemCount(): Int {
        return productOptions.size
    }
}