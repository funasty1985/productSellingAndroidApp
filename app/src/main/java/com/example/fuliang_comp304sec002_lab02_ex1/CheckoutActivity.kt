package com.example.fuliang_comp304sec002_lab02_ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CheckoutActivity : MenuEnableActivity() {

    override fun check(view: View?) {
        return
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val selectedProducts = loadProducts()

        val adapter = SelectedProductsAdapter(selectedProducts)
        val recyclerView: RecyclerView = findViewById(R.id.rv_checkout)
        recyclerView.adapter = adapter

        findViewById<Button>(R.id.btn_next).setOnClickListener{
            val myPreferences = getSharedPreferences("info", 0)
            val preferenceEditor = myPreferences.edit()
            val resultStr = productArrayToJson(selectedProducts.filter { it.isSelected })

            if(resultStr == "[]"){
                Toast.makeText(applicationContext,"Please select atleast one", Toast.LENGTH_SHORT).show()
            } else {
                preferenceEditor.putString("checkoutProduct", resultStr)
                preferenceEditor.commit()

                val intent = Intent(this, PaymentActivity::class.java)
                startActivity(intent)

            }
        }
    }
}