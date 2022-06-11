package kz.ablazim.foodtechapp.restaurants.data.model

import com.google.gson.annotations.SerializedName

data class RestaurantInfo(
    @SerializedName("Name")
    val name: String,
    @SerializedName("Logo")
    val logoUrl: String,
    @SerializedName("MinCost")
    val minCost: Int,
    @SerializedName("DeliveryCost")
    val deliveryCost: Int,
    @SerializedName("DeliveryTime")
    val deliveryTime: Int,
    @SerializedName("PositiveReviews")
    val positiveReviews: Int,
    @SerializedName("ReviewsCount")
    val reviewsCount: Int,
    @SerializedName("Specializations")
    val specializations: List<Specialization>
)