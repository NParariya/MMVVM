package com.example.mvvm.repository

import android.util.Log
import com.example.mvvm.model.Mainlist
import com.example.mvvm.Network.RestApis

class Listrepo
    (private val apiService: RestApis) : MainRepo
    {
        override suspend fun getList(): ArrayList<Mainlist>? {
                return try {
                    apiService.getList()
                } catch (e: Exception) {
                    Log.e("Error", e.stackTraceToString())
                    null
                }
            }

    }




