package com.example.passdatafromfragmenttoactivityusinginterface

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.passdatafromfragmenttoactivityusinginterface.R

/*
This method is not efficient as multiple fragments and Activities are being opened so you need to
press the back button several times to close them
 */

class MainActivity : AppCompatActivity(), MyInterface {     // remember to add this MyInterface that's inherited
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        textView = findViewById(R.id.textView)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, firstFragment)
                .addToBackStack("firstFragment")  //
                .commit()
        }
    }
    override fun transferMessage(message: String) {
            textView.text = message
    }

}