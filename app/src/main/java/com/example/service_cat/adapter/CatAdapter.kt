package com.example.service_cat.adapter

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.service_cat.R
import com.example.service_cat.data.model.Cat


interface OnItemClickListener{
    fun onCatClick(cat: Cat?)
}

class CatAdapter(private val catList: List<Cat>?,
                 private val onItemListener: OnItemClickListener):
    RecyclerView.Adapter<CatAdapter.ViewHolder>() {


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.id_name)
        val image = view.findViewById<ImageView>(R.id.id_image)
        val temperament = view.findViewById<TextView>(R.id.id_temperament)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.cats_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val cat = catList?.get(position)

    //    Log.d("TAG33", "getBreedById: ${catList?.get(9)?.breed?.first()?.temperament}")

        holder.name.text = if(cat?.category?.size != 0) cat?.category?.first()?.name else "none"
        holder.temperament.text = if(cat?.breed?.size != 0)
            cat?.breed?.first()?.temperament else "none"
        transformImage(holder.image, cat)

        holder.itemView.setOnClickListener {
            onItemListener.onCatClick(cat)
        }

    }


    private fun transformImage(imageView: ImageView, cat: Cat?){
        Glide.with(imageView.context).load(Uri.parse(cat?.url_picture)).into(imageView)
    }

    override fun getItemCount(): Int {
        return catList?.size ?: 0
    }
}