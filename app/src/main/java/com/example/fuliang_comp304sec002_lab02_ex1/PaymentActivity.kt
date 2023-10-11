package com.example.fuliang_comp304sec002_lab02_ex1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val cashRb = findViewById<RadioButton>(R.id.cash_rb)
        val creditCardRb = findViewById<RadioButton>(R.id.credit_rb)
        val debitCardRb = findViewById<RadioButton>(R.id.debit_rb)
        val submitChoiceBtn = findViewById<Button>(R.id.submit_choice_btn)

        var resultRb: String? = null
        submitChoiceBtn.setOnClickListener {
            if(cashRb.isChecked){
                resultRb = "Cash"
            }
            if(creditCardRb.isChecked){
                resultRb = "Credit"
            }
            if(debitCardRb.isChecked){
                resultRb = "Debit"
            }
            intent = Intent(applicationContext,CustomerDetailActivity::class.java)
            intent.putExtra("paymentMethod",resultRb)
            startActivity(intent)
        }
    }
}