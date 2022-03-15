package com.example.service_cat.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.service_cat.data.repository.CatRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val repository: CatRepository): ViewModel() {

    fun getBreedById(name: String) = liveData(Dispatchers.IO){
        try{
            val breed = repository.getBreedByName(name)
            emit(breed)
        }
        catch(ioException: Exception){
            print(ioException.message)
        }
    }
}