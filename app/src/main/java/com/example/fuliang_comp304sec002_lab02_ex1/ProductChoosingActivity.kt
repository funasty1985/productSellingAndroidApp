package com.example.fuliang_comp304sec002_lab02_ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class ProductChoosingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_choosing)
    }

    // inflating the options menu by overriding event onCreateOptionsMenu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home_type, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){

            R.id.m_appliances -> {
                Toast.makeText(this, "Displaying Appliances", Toast.LENGTH_LONG).show()
                intent = Intent(this, ApplicanceActivity::class.java)
                startActivity(intent)
            }

        }

        return super.onOptionsItemSelected(item)
    }

}