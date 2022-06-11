package kz.ablazim.foodtechapp.comments.data.model

import com.google.gson.annotations.SerializedName

data class CommentInfo(
    @SerializedName("IsPositive")
    val isPositive: Boolean,
    @SerializedName("Message")
    val message: String,
    @SerializedName("DateAdded")
    val dateAdded: String,
    @SerializedName("UserFIO")
    val userFio: String,
    @SerializedName("RestaurantName")
    val restaurantName: String
)
