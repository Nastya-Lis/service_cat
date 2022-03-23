package com.example.service_cat.ui.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.databinding.Bindable
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.service_cat.R
import com.example.service_cat.adapter.CatAdapter
import com.example.service_cat.adapter.OnItemClickListener
import com.example.service_cat.data.model.Cat
import com.example.service_cat.ui.main.viewmodel.MainViewModel


class CatListFragment : Fragment(), OnItemClickListener {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cat_list, container, false)

       /* val button = view.findViewById<Button>(R.id.buttonNavigate1)
        button.setOnClickListener{
            findNavController().navigate(R.id.action_catListFragment_to_catDetailFragment2)
        }*/

        //val text = view.findViewById<TextView>(R.id.textbreed)

        val recyclerView: RecyclerView = view.findViewById(R.id.cat_recycler)


   /*     viewModel.breedLiveData.observe(requireActivity()){
           if( it !=null ){
               text.text = it.name
           }
            else{
                text.text = "none"
           }
        }*/


        viewModel.catsLiveData.observe(requireActivity()){
            if( it !=null ){
                recyclerView.adapter = CatAdapter(it, this)
                recyclerView.adapter!!.notifyDataSetChanged()
            }
        }

      //  viewModel.getBreedById("sib")

        viewModel.getCats()

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        //recyclerView.adapter = CatAdapter()

        return view
    }

    override fun onCatClick(cat: Cat?) {

        val bundle = bundleOf( "cat_id" to cat!!.id)
        findNavController().navigate(R.id.action_catListFragment_to_catDetailFragment2, bundle)
    }

}