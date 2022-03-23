package com.example.service_cat.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.service_cat.data.model.Breed
import com.example.service_cat.data.model.Cat
import com.example.service_cat.data.repository.CatRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(): ViewModel() {

    private val repository: CatRepository = CatRepository()

    val breedLiveData = MutableLiveData<Breed>(null)

    val catsLiveData = MutableLiveData<List<Cat>>(null)

    fun getBreedById(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val breed = repository.getBreedByName(name)
            Log.d("TAG", "getBreedById: ${breed.first()}")
            breedLiveData.postValue(breed.last())
        }
    }

    fun getCats(){
        viewModelScope.launch (Dispatchers.IO){
            val cats = repository.getCats()
            Log.d("Tag2", "getCats: ${cats.size}")
            catsLiveData.postValue(cats)
        }
    }

}