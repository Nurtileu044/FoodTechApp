package kz.ablazim.foodtechapp.restaurants.contract

import kz.ablazim.foodtechapp.restaurants.data.model.RestaurantInfo

interface RestaurantsLocalGateway {
    suspend fun save(restaurants: List<RestaurantInfo>)
    suspend fun getAll(): List<RestaurantInfo>
    suspend fun getRestaurantsByName(name: String): List<RestaurantInfo>
}