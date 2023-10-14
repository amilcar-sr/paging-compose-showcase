package com.example.pagingcompose

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pagingcompose.data.ApiHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class MainViewModel(private val apiHelper: ApiHelper) : ViewModel() {
    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            apiHelper.getTitles()
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    // handle exception
                    e.printStackTrace()
                }
                .collect {
                    // list of users from the network
                    it.results.forEach { result ->
                        Log.i("", result.titleText?.text.orEmpty())
                    }
                }
        }
    }

    class Factory(val apiHelper: ApiHelper) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(apiHelper) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}