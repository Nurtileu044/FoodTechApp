package kz.ablazim.foodtechapp.restaurants.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kz.ablazim.foodtechapp.base.UseCase
import kz.ablazim.foodtechapp.restaurants.contract.RestaurantsLocalGateway
import kz.ablazim.foodtechapp.restaurants.data.model.RestaurantInfo

class GetLocalRestaurantsUseCase(
    private val restaurantsLocalGateway: RestaurantsLocalGateway
) : UseCase<Unit, List<RestaurantInfo>>() {
    override val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun execute(parameters: Unit): List<RestaurantInfo> = restaurantsLocalGateway.getAll()
}