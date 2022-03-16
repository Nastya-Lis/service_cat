package com.example.service_cat.ui.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.Bindable
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.service_cat.R
import com.example.service_cat.ui.main.viewmodel.MainViewModel


class CatListFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cat_list, container, false)

        val button = view.findViewById<Button>(R.id.buttonNavigate1)
        button.setOnClickListener{
            findNavController().navigate(R.id.action_catListFragment_to_catDetailFragment2)
        }

        val text = view.findViewById<TextView>(R.id.textbreed)

       // text.text = "bbbbeb"
       text.text = viewModel.getBreedById("sib").value?.name

        return view
    }

}