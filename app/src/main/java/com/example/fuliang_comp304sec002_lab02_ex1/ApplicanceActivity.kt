package com.example.fuliang_comp304sec002_lab02_ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class ApplicanceActivity : MenuEnableActivity() {

    var productOptionList = mutableListOf(
        ProductOption("Canco SP47-12 Double Door 47\" Refrigerated Sandwich Prep Table", R.drawable.a1, false, "a"),
        ProductOption("Midea WHS-65LB1 Compact Refrigerator, 1.6 Cubic Feet Single Door Fridge", R.drawable.a2, false, "a"),
        ProductOption("COMFEE' 1.6 Cubic Feet Solo Series Retro Refrigerator Sleek Appearanc", R.drawable.a3, false, "a"),
        ProductOption("Keurig K-Compact Single Serve K-Cup Pod Coffee Maker", R.drawable.a4, false, "a"),
        ProductOption(" Compressor Wine Cooler Refrigerator w/Lock", R.drawable.a5, false, "a"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_applicance)


        // making sure previously selected item is handled
        val selectProductNames = loadProducts("a").map{it.title}
        productOptionList.filter{ selectProductNames.contains(it.title)}.forEach{it.isChecked=true}


        // setting up product options adapter for recyclerview
        val adapter = ProductOptionsAdapter(productOptionList)
        val recyclerView: RecyclerView = findViewById(R.id.rv_applicance)
        recyclerView.adapter = adapter

        // checkout handler
        findViewById<Button>(R.id.btn_appliance_checkout).setOnClickListener{

            check(it)
            goCheckOut()
        }
    }



    override fun check(view: View?) {
        var result: List<ProductOption> = productOptionList.filter {
            it.isChecked
        }
        saveProducts(result, "a")
    }
}