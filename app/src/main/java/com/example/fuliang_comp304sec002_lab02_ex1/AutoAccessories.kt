package com.example.fuliang_comp304sec002_lab02_ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AutoAccessories : MenuEnableActivity() {

    var productOptionList = mutableListOf(
        ProductOption("AstroAI Tire Inflator Portable Air Compressor Air Pump for Car Tires ", R.drawable.aa1, false, "aa"),
        ProductOption("NOCO Boost Plus GB40 1000A UltraSafe Car Battery Jump Starter", R.drawable.aa2, false, "aa"),
        ProductOption("Energizer Jumper Cables for Car Battery, Heavy Duty Automotive Booster Cables", R.drawable.aa3, false, "aa"),
        ProductOption("AstroAI Tire Inflator Portable Air Compressor Air Pump for Car Tires ", R.drawable.aa4, false, "aa"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_accessories)

        // making sure previously selected item is handled
        val selectProductNames = loadProducts("aa").map{it.title}
        productOptionList.filter{ selectProductNames.contains(it.title)}.forEach{it.isChecked=true}


        // setting up product options adapter for recyclerview
        val adapter = ProductOptionsAdapter(productOptionList)
        val recyclerView: RecyclerView = findViewById(R.id.rv_aa)
        recyclerView.adapter = adapter
        findViewById<Button>(R.id.btn_aa_checkout).setOnClickListener{

            check(it)
            goCheckOut()
        }

    }

    override fun check(view: View?) {
        var result: List<ProductOption> = productOptionList.filter {
            it.isChecked
        }
        saveProducts(result, "aa")
    }
}