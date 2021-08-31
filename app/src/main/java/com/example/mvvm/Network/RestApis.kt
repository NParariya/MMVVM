package com.example.mvvm.Network

import com.example.mvvm.model.Mainlist
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApis {

    @GET("DevTides/DogsApi/master/dogs.json")
    suspend fun getList(): ArrayList<Mainlist>?


}