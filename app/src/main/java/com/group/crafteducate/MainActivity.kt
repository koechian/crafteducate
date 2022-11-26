package com.group.crafteducate

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.group.crafteducate.R


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
//        hide title bar
        supportActionBar?.hide()

        setContentView(R.layout.fragment_register)
    }


}