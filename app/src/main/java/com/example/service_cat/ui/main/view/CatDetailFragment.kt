package com.example.service_cat.ui.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.service_cat.R



class CatDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cat_detail, container, false)

        val button = view.findViewById<Button>(R.id.buttonNavigate2)

        button.setOnClickListener{
            findNavController().navigate(R.id.action_catDetailFragment_to_catListFragment)
        }



        return view
    }

}