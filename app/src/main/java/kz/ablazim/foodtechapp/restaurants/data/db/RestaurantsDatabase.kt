package kz.ablazim.foodtechapp.restaurants.data.db

import androidx.sqlite.db.SimpleSQLiteQuery
import kz.ablazim.foodtechapp.restaurants.contract.RestaurantsLocalGateway
import kz.ablazim.foodtechapp.restaurants.data.RestaurantsConverter
import kz.ablazim.foodtechapp.restaurants.data.model.RestaurantInfo

internal class RestaurantsDatabase(
    private val restaurantsDaoProvider: RestaurantsDaoProvider
) : RestaurantsLocalGateway {
    override suspend fun save(restaurants: List<RestaurantInfo>) {
        restaurantsDaoProvider.restaurantsDao.save(RestaurantsConverter.toDatabase(restaurants))
    }

    override suspend fun getAll(): List<RestaurantInfo> {
        val restaurantsEntity = restaurantsDaoProvider.restaurantsDao.getAll()
        return RestaurantsConverter.fromDatabase(restaurantsEntity)
    }

    override suspend fun getRestaurantsByName(name: String): List<RestaurantInfo> {
        val restaurantsEntity = restaurantsDaoProvider.restaurantsDao.getRestaurantsByName(createSearchQuery(name))
        return RestaurantsConverter.fromDatabase(restaurantsEntity)
    }

    private fun createSearchQuery(name: String): SimpleSQLiteQuery {
        val params = mutableListOf<Any>()
        val sql = StringBuilder()
        sql.append("SELECT * FROM ${RestaurantEntity.TABLE_NAME} WHERE ${RestaurantEntity.RESTAURANT_NAME} LIKE ?")
        params.add("%${name}%")
        return SimpleSQLiteQuery(sql.toString(), params.toTypedArray())
    }
}