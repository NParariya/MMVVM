package com.example.mvvm.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName


@Keep
class Mainlist(

    @SerializedName("name")
     var name: String,
    @SerializedName("life_span")
     var id: String,
    @SerializedName("url")
    var url : String,



   // private var Image:String



)