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

enum class ApiServiceStatus { LOADING, ERROR, DONE}

class MainScreenViewModel(private val repository: CatFactsRepository) : ViewModel() {

    private var _catFactList = MutableLiveData<List<CatFact>>()
    val catFactList: LiveData<List<CatFact>> = _catFactList

    private var _status = MutableLiveData<ApiServiceStatus>()
    val status: LiveData<ApiServiceStatus> = _status

    init {
        getCatFacts()
    }

    fun getCatFacts() {
        viewModelScope.launch {
            _status.value = ApiServiceStatus.LOADING
            try{
                val result = repository.getFacts()
                _catFactList.value = result
                _status.value = ApiServiceStatus.DONE
            }
            catch(e: Exception) {
                _status.value = ApiServiceStatus.ERROR
                _catFactList.value = listOf()
            }
        }
    }
}