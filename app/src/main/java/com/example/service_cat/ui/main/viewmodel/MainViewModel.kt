package com.example.service_cat.ui.main.viewmodel

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.service_cat.data.api.NetworkService
import com.example.service_cat.data.repository.CatRepository
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit

class MainViewModel(): ViewModel() {

    private val repository: CatRepository = CatRepository()

    fun getBreedById(name: String) = liveData(Dispatchers.IO){
        try{
            val breed = repository.getBreedByName(name)
            print(breed.name)
            emit(breed)
        }
        catch(ioException: Exception){
            print(ioException.message)
        }
    }
}