package kz.ablazim.foodtechapp.database

import kz.ablazim.foodtechapp.restaurants.data.db.RestaurantsDao
import kz.ablazim.foodtechapp.restaurants.data.db.RestaurantsDaoProvider
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

internal class DatabaseManager() : KoinComponent, RestaurantsDaoProvider {
    override val restaurantsDao: RestaurantsDao
        get() = getDatabase().restaurantsDao()

    private val databases = mutableMapOf<String, FoodTechDatabase>()

    private fun getDatabase(): FoodTechDatabase = databases.getOrPut("foodTech") { get() }
}