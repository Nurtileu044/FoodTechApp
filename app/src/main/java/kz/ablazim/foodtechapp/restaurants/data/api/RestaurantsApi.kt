package kz.ablazim.foodtechapp.restaurants.data.api

import kz.ablazim.foodtechapp.restaurants.contract.RestaurantsRemoteGateway
import kz.ablazim.foodtechapp.restaurants.data.model.RestaurantInfo

internal class RestaurantsApi(private val service: RestaurantsService) : RestaurantsRemoteGateway {
    override suspend fun getRestaurants(): List<RestaurantInfo> = service.getRestaurants()
}