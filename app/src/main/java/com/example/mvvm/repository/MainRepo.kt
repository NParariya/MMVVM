package com.example.mvvm.repository

import com.example.mvvm.model.Mainlist

interface MainRepo {

    suspend fun getList(): ArrayList<Mainlist>?
}
