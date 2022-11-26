package com.group.crafteducate.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.group.crafteducate.MainActivity
import com.group.crafteducate.databinding.LoginBinding

class Login : AppCompatActivity() {

    private lateinit var firebase: FirebaseAuth
    private lateinit var binding: LoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
//        hide title bar
        supportActionBar?.hide()

        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebase = FirebaseAuth.getInstance()

        binding.createAccount.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        binding.signinButton.setOnClickListener {
            val email = binding.loginEmail.text.toString()
            val password = binding.password.text.toString()

            if (email.isBlank() or password.isBlank()) {
                showToast("Please fill all fields")
            } else {
                firebase.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        showToast("Login Failed")
                        Log.e("Firebase",it.exception.toString())
                    }
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onStart() {
        super.onStart()

        if(firebase.currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

