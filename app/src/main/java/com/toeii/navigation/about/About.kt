package com.toeii.navigation.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.toeii.navigation.R


class About : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_about, container, false)

        val phone = arguments?.getString("phone") ?: "null"
        view.findViewById<TextView>(R.id.tv_me).text = phone

        view.findViewById<Button>(R.id.btn_back).setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }

        view.findViewById<Button>(R.id.btn_back_first).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_about_to_contactList)
        }

        return view
    }

}