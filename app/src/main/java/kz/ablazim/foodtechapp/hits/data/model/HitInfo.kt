package kz.ablazim.foodtechapp.hits.data.model

import com.google.gson.annotations.SerializedName

data class HitInfo(
    @SerializedName("ProductName")
    val productName: String,
    @SerializedName("ProductImage")
    val productImageUrl: String,
    @SerializedName("ProductPrice")
    val productPrice: Int,
    @SerializedName("ProductDescription")
    val productDescription: String,
    @SerializedName("RestaurantId")
    val restaurantId: Int,
    @SerializedName("RestaurantName")
    val restaurantName: String,
    @SerializedName("RestaurantLogo")
    val restaurantLogoUrl: String
)
