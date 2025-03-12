package com.example.androidtest

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("api/v2/send-otp")
    fun getOtp(@Field("contact_number") contact_number:String) :Call<ExampleJson2KtKotlin>

    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("api/v2/verify-otp")
    fun getVerifyOtp(@Field("contact_number") contact_number: String, @Field("otp") otp :Int) : Call<ResponseOtp>
}

//https://strengthen-numbers-stag.dev-imaginovation.net/api