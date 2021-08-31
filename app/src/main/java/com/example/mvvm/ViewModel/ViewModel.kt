package com.example.mvvm.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.model.Mainlist
import com.example.mvvm.repository.Listrepo
import kotlinx.coroutines.launch


class ViewModel(private val repo: Listrepo):ViewModel(){

    private val _mylist : MutableLiveData<ArrayList<Mainlist>?> = MutableLiveData()
    val mylist : LiveData<ArrayList<Mainlist>?> = _mylist


    fun refresh(){
        getListFromServer()
    }
    fun getListFromServer(){

        viewModelScope.launch {
            _mylist.value = repo.getList()
        }


    }



}

