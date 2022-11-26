package com.group.crafteducate.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth
import com.group.crafteducate.R
import com.group.crafteducate.databinding.FragmentRegisterBinding

class Register : AppCompatActivity() {
    private lateinit var firebaseAuth:FirebaseAuth
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
//        hide title bar
        supportActionBar?.hide()

        binding = FragmentRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()


        binding.backLogin.setOnClickListener(){
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }

        binding.registerButton.setOnClickListener {

            val registerEmail = binding.registerEmail.text.toString()
            val registerPassword =binding.registerPassword.text.toString()
            val confirmPassword =binding.confirmPassword.text.toString()


            if (registerEmail.isNullOrBlank() or registerEmail.isNullOrBlank() or confirmPassword.isNullOrBlank()) {
                showToast("Please make sure all fields are filled")
            } else {
                if (registerPassword == confirmPassword) {
                    firebaseAuth.createUserWithEmailAndPassword(
                        registerEmail, registerPassword
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            showToast("Account has been created")
                        } else {
                            showToast("Fuck")
                            Log.d("shit",it.exception.toString())
                        }
                    }
                } else {
                    showToast(registerPassword + "" + confirmPassword)
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