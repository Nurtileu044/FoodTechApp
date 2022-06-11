package kz.ablazim.foodtechapp.restaurants.data.api

import kz.ablazim.foodtechapp.restaurants.data.model.RestaurantInfo
import retrofit2.http.GET

internal interface RestaurantsService {
    @GET("v1/restaurants")
    suspend fun getRestaurants(): List<RestaurantInfo>
}