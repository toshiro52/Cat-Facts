package com.example.catfacts.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catfacts.model.CatFact
import com.example.catfacts.network.CatFactsRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class MainScreenViewModel(private val repository: CatFactsRepository) : ViewModel() {

    private var _catFactList = MutableLiveData<List<CatFact>>()
    val catFactList: LiveData<List<CatFact>> = _catFactList

    init {
        getCatFacts()
    }

    fun getCatFacts() {
        viewModelScope.launch {
            try{
                val result = repository.getFacts()
                _catFactList.value = result
                Log.d("TAG", "Retrieved ${result.size} facts")
            }
            catch(e: Exception) {
                Log.d("TAG", "ERROR")
            }
        }
    }
}