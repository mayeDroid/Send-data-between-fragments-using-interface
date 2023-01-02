package com.example.passdatafromfragmenttoactivityusinginterface

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText



class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_first, container, false)

        val editText1 = view.findViewById<EditText>(R.id.editTextTextPersonName)
        val button = view.findViewById<Button>(R.id.button)

        val myInterface = activity as MyInterface

        button.setOnClickListener {
            val messageToBeSent = editText1.text.toString()
            myInterface.transferMessage(messageToBeSent)
        }

        return view
    }

}