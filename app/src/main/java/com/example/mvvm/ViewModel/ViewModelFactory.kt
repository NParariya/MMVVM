package com.example.mvvm.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.Network.RetroFitBuilder
import com.example.mvvm.repository.Listrepo
import java.lang.IllegalArgumentException

class ViewModelFactory():ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(com.example.mvvm.ViewModel.ViewModel::class.java)) {

            return com.example.mvvm.ViewModel.ViewModel(Listrepo(RetroFitBuilder.apiService)) as T

        }     //(RetroFitBuilder.apiService)

        throw IllegalArgumentException("unknown class name error")

    }
}