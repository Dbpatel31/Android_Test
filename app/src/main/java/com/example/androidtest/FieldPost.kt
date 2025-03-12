package com.example.androidtest


import com.google.gson.annotations.SerializedName


data class FieldPost(

    @SerializedName("data") var data: ArrayList<PostData> = arrayListOf(),
    @SerializedName("meta") var meta: PostMeta? = PostMeta()

)


data class Media(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("path") var path: String? = null,
    @SerializedName("thumbnail") var thumbnail: String? = null

)

data class Post(

    @SerializedName("post_id") var postId: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("media") var media: ArrayList<Media> = arrayListOf(),
    @SerializedName("is_liked") var isLiked: Int? = null,
    @SerializedName("likes_count") var likesCount: Int? = null,
    @SerializedName("is_saved") var isSaved: Int? = null,
    @SerializedName("saved_count") var savedCount: Int? = null,
    @SerializedName("comments_count") var commentsCount: Int? = null

)

data class PostData(

    @SerializedName("feed_id") var feedId: Int? = null,
    @SerializedName("user_id") var userId: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("username") var username: String? = null,
    @SerializedName("profile_photo") var profilePhoto: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("is_active") var isActive: Int? = null,
    @SerializedName("is_published") var isPublished: Int? = null,
    @SerializedName("is_following") var isFollowing: Int? = null,
    @SerializedName("is_blocked") var isBlocked: Int? = null,
    @SerializedName("post") var post: Post? = Post()

)

data class PostMeta(

    @SerializedName("message") var message: String? = null

)