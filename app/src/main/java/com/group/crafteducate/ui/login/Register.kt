package com.group.crafteducate.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth
import com.group.crafteducate.R

class Register : AppCompatActivity() {
    private lateinit var firebaseAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.fragment_register)
        firebaseAuth = FirebaseAuth.getInstance()

//      binded vals from layout xml file

        val registerEmail: EditText = findViewById(R.id.registerEmail)
        val registerPassword: EditText = findViewById(R.id.registerPassword)
        val confirmPassword: EditText = findViewById(R.id.confirmPassword)
        val registerButton = findViewById<AppCompatButton>(R.id.registerButton)

        registerButton.setOnClickListener {
            if (registerPassword.text.isNullOrBlank() or registerEmail.text.isNullOrBlank() or confirmPassword.text.isNullOrBlank()) {
                showToast("Please make sure all fields are filled")
            } else {
                if (registerPassword == confirmPassword) {
                    firebaseAuth.createUserWithEmailAndPassword(
                        registerEmail.toString(),
                        registerPassword.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            showToast("Account has been created")
                        } else {
                            showToast(it.exception.toString())
                        }
                    }
                } else {
                    showToast("Passwords do not match")
                }
            }
        }
    }

    private fun showToast(message: String){
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_LONG
        ).show()
    }
}