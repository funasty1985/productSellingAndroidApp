package com.example.fuliang_comp304sec002_lab02_ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // reference the enterBtn
        val enterBtn = findViewById<Button>(R.id.btnEnter)

        enterBtn.setOnClickListener {
            intent = Intent(this, ProductChoosingActivity::class.java)
            startActivity(intent)
        }
    }

}