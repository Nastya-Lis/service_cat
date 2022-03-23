package com.example.service_cat.ui.main.view

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.service_cat.R
import com.example.service_cat.ui.main.viewmodel.CatDetailViewModel



class CatDetailFragment : Fragment() {

    val catViewModel: CatDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cat_detail, container, false)

        val button = view.findViewById<Button>(R.id.buttonNavigate2)
        val image = view.findViewById<ImageView>(R.id.id_image)
        val categoryName = view.findViewById<TextView>(R.id.id_name)
        val temperament =view.findViewById<TextView>(R.id.id_temperament)
        val wikiUrl = view.findViewById<TextView>(R.id.id_wiki_url)

        button.setOnClickListener{
            findNavController().navigate(R.id.action_catDetailFragment_to_catListFragment)
        }

        catViewModel.mutableLiveDataCat.observe(requireActivity()){
            if(it!=null){
                Glide.with(image.context).load(Uri.parse(it?.url_picture)).into(image)
            }
            categoryName.text = if(it?.category?.size != 0) it?.category?.first()?.name else "none"
            temperament.text = if(it?.breed?.size != 0) it?.breed?.first()?.temperament else "none"
            wikiUrl.text = if(it?.breed?.size != 0) it?.breed?.first()?.wikipedia_url else "none"
        }

        arguments.let {
                bundle ->  val id_cat = bundle?.getString("cat_id")
            if(id_cat!=null){
                catViewModel.getCatById(id_cat)
            }
        }

        return view
    }

}