package com.example.service_cat.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.service_cat.data.model.Cat
import com.example.service_cat.data.repository.CatRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CatDetailViewModel: ViewModel() {

    private val repository: CatRepository = CatRepository()

    val mutableLiveDataCat = MutableLiveData<Cat>(null)

    fun getCatById(id_cat: String){
        viewModelScope.launch(Dispatchers.IO) {
            val cat = repository.getCatById(id_cat)
            mutableLiveDataCat.postValue(cat)
        }
    }
}