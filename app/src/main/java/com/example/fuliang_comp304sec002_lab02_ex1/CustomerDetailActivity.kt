package com.example.fuliang_comp304sec002_lab02_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class CustomerDetailActivity : MenuEnableActivity() {
    override fun check(view: View?) {}
    lateinit var userName: EditText
    lateinit var userAddress: EditText
    lateinit var userEmail: EditText
    lateinit var userPhone: EditText
    lateinit var userHobby: EditText
    lateinit var userFav: EditText
    lateinit var userCardNum: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_detail)


        val paymentMethod = intent.getStringExtra("paymentMethod").toString()
        userName = findViewById<EditText>(R.id.et_customer_name)
        userAddress = findViewById<EditText>(R.id.et_customer_address)
        userEmail = findViewById<EditText>(R.id.et_customer_email)
        userPhone = findViewById<EditText>(R.id.et_customer_phone)
        userHobby = findViewById<EditText>(R.id.et_customer_hobby)
        userFav = findViewById<EditText>(R.id.et_customer_fav_place)
        userCardNum = findViewById<EditText>(R.id.et_customer_card_no)
        val finalSubmitBtn = findViewById<Button>(R.id.btn_final_submit)
        val finalOutput = findViewById<TextView>(R.id.tv_final_output)

        if(paymentMethod == "Cash"){
            userCardNum!!.visibility = View.GONE
        }

        finalSubmitBtn.setOnClickListener {
            var resultText = ""
            if(validateData(paymentMethod)){
                resultText += "Name: ${userName.text}\n" +
                        "Address: ${userAddress.text}\n" +
                        "Email: ${userEmail.text}\n" +
                        "Phone: ${userPhone.text}\n" +
                        "Hobby: ${userHobby.text}\n" +
                        "Favorite Place: ${userFav.text}\n" +
                        "Payment Method: $paymentMethod\n"

                if(paymentMethod != "Cash"){
                    resultText += "Card Number ${userCardNum.text}\n"
                }

                val myPreference = getSharedPreferences("info", 0)
                val checkoutProducts =  jsonToProductArray(myPreference.getString("checkoutProduct", "")).map{it.title}

                resultText += "Purchased Products :\n"
                for (str in checkoutProducts) {
                    resultText += "${str}\n"
                }
                finalOutput.text = resultText
                Toast.makeText(this, resultText, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateData(paymentMethod: String): Boolean{

        if(arrayListOf<String>("Credit", "Debit").contains(paymentMethod)){
            if(userCardNum!!.text.isEmpty()){
                Toast.makeText(applicationContext,"Please enter the card number ",Toast.LENGTH_LONG).show()
                return false
            }
        }

        if (userName!!.text.isEmpty()){
            Toast.makeText(applicationContext,"Please enter your name", Toast.LENGTH_LONG).show()
            return false
        }
        if (userAddress!!.text.isEmpty()){
            Toast.makeText(applicationContext,"Please enter your address", Toast.LENGTH_LONG).show()
            return false
        }
        if (userEmail!!.text.isEmpty()){
            Toast.makeText(applicationContext,"Please enter your E-mail", Toast.LENGTH_LONG).show()
            return false
        }
        if (userPhone!!.text.isEmpty()){
            Toast.makeText(applicationContext,"Please enter your phone number", Toast.LENGTH_LONG).show()
            return false
        }
        if(userHobby!!.text.isEmpty()){
            Toast.makeText(applicationContext,"Please enter your hobby", Toast.LENGTH_LONG).show()
            return false
        }
        if(userFav!!.text.isEmpty()){
            Toast.makeText(applicationContext,"Please enter your favourite place name", Toast.LENGTH_LONG).show()
            return false
        } else{
            return true
        }
    }
}