package com.example.fuliang_comp304sec002_lab02_ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class FurnitureActivity : MenuEnableActivity() {
    var productOptionList = mutableListOf(
        ProductOption("Living Room Chairs Modern Black Textured Velvet Accent Chair", R.drawable.f1, false, "f"),
        ProductOption("Modway Prospect Performance Velvet Living Room Lounge Armchair in Navy", R.drawable.f2, false, "f"),
        ProductOption("Dewhut Modern Velvet Barrel Accent Chair, Comfy Wide Handmade Woven Bucket Arm Chair", R.drawable.f3, false, "f"),
        ProductOption("24KF Modern Taupe Velvet Button Tufted Accent Chair with Golden Metal Stand", R.drawable.f4, false, "f"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_furniture)
        // making sure previously selected item is handled
        val selectProductNames = loadProducts("f").map{it.title}
        productOptionList.filter{ selectProductNames.contains(it.title)}.forEach{it.isChecked=true}


        // setting up product options adapter for recyclerview
        val adapter = ProductOptionsAdapter(productOptionList)
        val recyclerView: RecyclerView = findViewById(R.id.rv_furniture)
        recyclerView.adapter = adapter
        findViewById<Button>(R.id.btn_furniture_checkout).setOnClickListener{

            check(it)
            intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)

        }
    }

    override fun check(view: View?) {
        var result: List<ProductOption> = productOptionList.filter {
            it.isChecked
        }
        saveProducts(result, "f")
    }
}