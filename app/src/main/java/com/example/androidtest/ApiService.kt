package com.example.androidtest

import retrofit2.Call
import retrofit2.http.POST

interface ApiService {
    @POST("api")
    fun getOtp(otp: PostOtp) : Call<List<OtpModel>>
}

//https://strengthen-numbers-stag.dev-imaginovation.net/api