package com.example.androidtest

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface PostApiService {

    @GET("api/v2/get-all-feeds")
    fun getFeeds(): Call<List<Post>>

    @FormUrlEncoded
    @POST("api/v2/like-unlike-feed")
    fun getLikes(@Field("feed_id") feed_id: Int): Call<List<LikeData>>

}