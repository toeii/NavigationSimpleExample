package com.toeii.navigation.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.toeii.navigation.R


class ContactMessage : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_contact_msg, container, false)

        val phone = arguments?.getString("phone") ?: "null"

        view.findViewById<Button>(R.id.btn_look).setOnClickListener {
            val builder = Bundle()
            builder.putString("phone",phone)
            Navigation.findNavController(view).navigate(R.id.action_contactMessage_to_about,builder)
        }

        view.findViewById<Button>(R.id.btn_back).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_contactMessage_to_contactList)
        }

        return view

    }

}