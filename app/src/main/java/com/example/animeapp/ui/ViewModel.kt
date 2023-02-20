package com.example.animequotes.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.animeapp.data.model.AnimeResponse
import com.example.animeapp.data.repository.AnimeRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animeapp.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ViewModel @Inject constructor(
    private val repository: AnimeRepository
): ViewModel(){
    var animeObject: AnimeResponse? = null

    private val _result = MutableLiveData<UIState>()
    val result: LiveData<UIState> = _result

    fun getQuote(){
        viewModelScope.launch {
            _result.postValue(UIState.LOADING)
            val response = repository.getRandomQuote()
            if (response.isSuccessful){
                _result.postValue(UIState.SUCCESS(response.body()!!))
            }else{
                _result.postValue(UIState.ERROR(response.message()))
            }
        }
    }
}