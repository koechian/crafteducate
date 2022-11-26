package com.group.crafteducate.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.group.crafteducate.R

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

//        input refs
        val button : AppCompatButton = findViewById(R.id.signinButton)
        val email : EditText = findViewById(R.id.loginEmail)
        val password : EditText = findViewById(R.id.password)


        button.setOnClickListener{
            if (email.text.isNullOrBlank() or password.text.isNullOrBlank()){
                Toast.makeText(this, "Please Fill all fields", Toast.LENGTH_LONG).show()
        }
            else{
                Toast.makeText(this,"${email.text}",Toast.LENGTH_SHORT).show()
            }
        }
    }
}