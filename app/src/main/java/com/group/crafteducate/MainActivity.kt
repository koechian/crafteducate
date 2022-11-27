package com.group.crafteducate

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.group.crafteducate.R
import com.group.crafteducate.databinding.FragmentLandingBinding
import com.group.crafteducate.databinding.FragmentRegisterBinding
import com.group.crafteducate.databinding.LoginBinding
import com.group.crafteducate.ui.login.Register
import com.group.crafteducate.ui.tasks.Tasks


class MainActivity : AppCompatActivity() {
    private lateinit var binding: FragmentLandingBinding
    private lateinit var firebase: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
//        hide title bar
        supportActionBar?.hide()

        firebase = FirebaseAuth.getInstance()
        binding = FragmentLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tasksButton.setOnClickListener{
            val intent = Intent(this, Tasks::class.java)
            startActivity(intent)
        }

    }
}