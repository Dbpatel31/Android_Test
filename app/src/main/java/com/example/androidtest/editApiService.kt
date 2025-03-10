package com.example.androidtest

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface editApiService {
    @POST("api/v2/edit-profile")
    fun getProfile(@Body posteditModel: PostEditModel) : Call<Response<List<EditModel>>>
}