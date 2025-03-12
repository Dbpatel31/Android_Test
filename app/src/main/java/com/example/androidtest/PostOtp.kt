package com.example.androidtest

import com.google.gson.annotations.SerializedName

data class ExampleJson2KtKotlin (

    @SerializedName("data" ) var data : String? = null,
    @SerializedName("meta" ) var meta : Meta?   = Meta()

)

data class Meta (

    @SerializedName("message" ) var message : String? = null

)
