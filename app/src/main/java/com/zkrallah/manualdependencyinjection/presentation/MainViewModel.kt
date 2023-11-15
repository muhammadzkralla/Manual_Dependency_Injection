package com.zkrallah.manualdependencyinjection.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zkrallah.manualdependencyinjection.domain.model.Response
import com.zkrallah.manualdependencyinjection.domain.usecase.GetItems
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getItemsUseCase: GetItems
) : ViewModel() {

    private val _items: MutableStateFlow<List<Response?>?> = MutableStateFlow(null)
    val items: StateFlow<List<Response?>?> = _items

    fun getItems() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _items.emit(getItemsUseCase())
                Log.i("MainViewModel", "Fetched Successfully !")
            } catch (e: Exception) {
                Log.e("MainViewModel", e.message.toString())
            }
        }
    }
}