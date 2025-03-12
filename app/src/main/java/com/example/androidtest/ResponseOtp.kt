package com.example.androidtest

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseOtp (

    @SerializedName("data" ) var data : Data? = Data(),
    @SerializedName("meta" ) var meta : Metaa? = Metaa()

)


data class Data (

    @SerializedName("id"               ) var id              : Int?              = null,
    @SerializedName("name"             ) var name            : String?           = null,
    @SerializedName("username"         ) var username        : String?           = null,
    @SerializedName("email"            ) var email           : String?           = null,
    @SerializedName("contact_number"   ) var contactNumber   : String?           = null,
    @SerializedName("dob"              ) var dob             : String?           = null,
    @SerializedName("bio"              ) var bio             : String?           = null,
    @SerializedName("gender"           ) var gender          : String?           = null,
    @SerializedName("latitude"         ) var latitude        : Double?           = null,
    @SerializedName("longitude"        ) var longitude       : Double?           = null,
    @SerializedName("address"          ) var address         : String?           = null,
    @SerializedName("fitness_level"    ) var fitnessLevel    : String?           = null,
    @SerializedName("interests"        ) var interests       : ArrayList<String> = arrayListOf(),
    @SerializedName("profile_photo"    ) var profilePhoto    : String?           = null,
    @SerializedName("registered_at"    ) var registeredAt    : String?           = null,
    @SerializedName("total_followers"  ) var totalFollowers  : Int?              = null,
    @SerializedName("total_followings" ) var totalFollowings : Int?              = null,
    @SerializedName("is_following"     ) var isFollowing     : Int?              = null,
    @SerializedName("is_blocked"       ) var isBlocked       : Int?              = null,
    @SerializedName("share_location"   ) var shareLocation   : Int?              = null

) : Serializable


data class Metaa (

    @SerializedName("message" ) var message : String? = null

)
