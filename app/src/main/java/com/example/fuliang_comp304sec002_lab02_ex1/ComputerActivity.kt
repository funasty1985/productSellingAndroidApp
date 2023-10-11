package com.example.fuliang_comp304sec002_lab02_ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ComputerActivity : MenuEnableActivity() {

    var productOptionList = mutableListOf(
        ProductOption("Microsoft Surface Laptop 4, 15\" PixelSense Touchscreen", R.drawable.c1, false, "c"),
        ProductOption("HP 17.3\" Flagship HD+ Business Laptop, 16GB DDR4 RAM", R.drawable.c2, false, "c"),
        ProductOption("Lenovo ThinkPad E14 Gen 4 14\" FHD Touchscreen ", R.drawable.c3, false, "c"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_computer)
        // making sure previously selected item is handled
        val selectProductNames = loadProducts("c").map{it.title}
        productOptionList.filter{ selectProductNames.contains(it.title)}.forEach{it.isChecked=true}


        // setting up product options adapter for recyclerview
        val adapter = ProductOptionsAdapter(productOptionList)
        val recyclerView: RecyclerView = findViewById(R.id.rv_computer)
        recyclerView.adapter = adapter
        findViewById<Button>(R.id.btn_computer_checkout).setOnClickListener{

            check(it)
            goCheckOut()
        }
    }

    override fun check(view: View?) {
        var result: List<ProductOption> = productOptionList.filter {
            it.isChecked
        }
        saveProducts(result, "c")
    }
}