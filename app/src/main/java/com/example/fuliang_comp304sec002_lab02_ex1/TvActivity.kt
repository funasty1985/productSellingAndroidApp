package com.example.fuliang_comp304sec002_lab02_ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class TvActivity : MenuEnableActivity() {

    var productOptionList = mutableListOf(
        ProductOption("INSIGNIA 32-inch Class F20 Series Smart HD 720p Fire TV with Alexa Voice Remote", R.drawable.t1, false, "t"),
        ProductOption("SAMSUNG 32-inch Class LED Smart FHD TV 720P", R.drawable.t2, false, "t"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv)
        val selectProductNames = loadProducts("f").map{it.title}
        productOptionList.filter{ selectProductNames.contains(it.title)}.forEach{it.isChecked=true}


        // setting up product options adapter for recyclerview
        val adapter = ProductOptionsAdapter(productOptionList)
        val recyclerView: RecyclerView = findViewById(R.id.rv_tv)
        recyclerView.adapter = adapter
        findViewById<Button>(R.id.btn_tv_checkout).setOnClickListener{

            check(it)
            intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)

        }
    }

    override fun check(view: View?) {
        var result: List<ProductOption> = productOptionList.filter {
            it.isChecked
        }
        saveProducts(result, "t")
    }
}