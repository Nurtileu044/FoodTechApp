package kz.ablazim.foodtechapp.restaurants.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kz.ablazim.foodtechapp.base.UseCase
import kz.ablazim.foodtechapp.restaurants.contract.RestaurantsLocalGateway
import kz.ablazim.foodtechapp.restaurants.data.model.RestaurantInfo

class GetLocalRestaurantsByName(
    private val restaurantsLocalGateway: RestaurantsLocalGateway
) : UseCase<String, List<RestaurantInfo>>() {
    override val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun execute(parameters: String): List<RestaurantInfo> =
        restaurantsLocalGateway.getRestaurantsByName(parameters)
}