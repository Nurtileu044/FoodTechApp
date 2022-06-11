package kz.ablazim.foodtechapp.restaurants.contract

import kz.ablazim.foodtechapp.restaurants.data.model.RestaurantInfo

interface RestaurantsRemoteGateway {
    suspend fun getRestaurants(): List<RestaurantInfo>
}