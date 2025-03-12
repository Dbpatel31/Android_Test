package com.example.androidtest

import com.google.gson.annotations.SerializedName


data class Likeunlike(

    @SerializedName("data") var data: LikeData? = LikeData(),
    @SerializedName("meta") var meta: LikeMeta? = LikeMeta()

)


data class LikeMeta(

    @SerializedName("message") var message: String? = null

)

data class LikeData(

    @SerializedName("feed_id") var feedId: Int? = null,
    @SerializedName("is_liked") var isLiked: Int? = null,
    @SerializedName("likes_count") var likesCount: Int? = null

)