package com.example.fuliang_comp304sec002_lab02_ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

abstract class MenuEnableActivity : AppCompatActivity() {
    // inflating the options menu by overriding event onCreateOptionsMenu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home_type, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun productArrayToJson(arr: List<ProductOption>): String{
        return Gson().toJson(arr)
    }

    fun jsonToProductArray(str :String?): List<ProductOption>{
        return Gson().fromJson(str, object: TypeToken<List<ProductOption>>() {}.type)
    }

    fun saveProducts(product: List<ProductOption>, type: String){

        // load previously saved products
        var previouslyLoadedProduct = loadProducts()
        // remove the products of selected type
        previouslyLoadedProduct = previouslyLoadedProduct.filter{it.type != type}
        val resultStr = productArrayToJson(previouslyLoadedProduct + product)
        val myPreference = getSharedPreferences("info",0)
        // prepare it for edit by creating an Edit obejct
        val preferenceEditor = myPreference.edit()
        preferenceEditor.putString("selectedProduct", resultStr)
        preferenceEditor.commit()
    }

    fun loadProducts(type: String): List<ProductOption> {
        val myPreference = getSharedPreferences("info",0)
        val productStr = myPreference.getString("selectedProduct", "")

        return jsonToProductArray(productStr).filter { it.type ==  type}
    }

    fun loadProducts(): List<ProductOption> {
        val myPreference = getSharedPreferences("info",0)
        val productStr = myPreference.getString("selectedProduct", "")

        return jsonToProductArray(productStr)
    }

    abstract fun check(view: View?)

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){

            R.id.m_appliances -> {
                Toast.makeText(this, "Displaying Appliances", Toast.LENGTH_LONG).show()
                check(view = null)
                intent = Intent(this, ApplicanceActivity::class.java)
                startActivity(intent)
            }

            R.id.m_tv -> {
                Toast.makeText(this, "Displaying TVs", Toast.LENGTH_LONG).show()
                check(view = null)
                intent = Intent(this, TvActivity::class.java)
                startActivity(intent)
            }

            R.id.m_comp -> {
                Toast.makeText(this, "Displaying Computers", Toast.LENGTH_LONG).show()
                check(view = null)
                intent = Intent(this, ComputerActivity::class.java)
                startActivity(intent)
            }


            R.id.m_furniture -> {
                Toast.makeText(this, "Displaying Furniture", Toast.LENGTH_LONG).show()
                check(view = null)
                intent = Intent(this, FurnitureActivity::class.java)
                startActivity(intent)
            }

            R.id.m_aa -> {
                Toast.makeText(this, "Displaying Auto Accessories", Toast.LENGTH_LONG).show()
                check(view = null)
                intent = Intent(this, AutoAccessories::class.java)
                startActivity(intent)
            }

        }

        return super.onOptionsItemSelected(item)
    }
}