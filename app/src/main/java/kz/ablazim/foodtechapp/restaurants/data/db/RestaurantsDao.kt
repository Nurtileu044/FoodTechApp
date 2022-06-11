package kz.ablazim.foodtechapp.restaurants.data.db

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery

@Dao
interface RestaurantsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(restaurants: List<RestaurantEntity>)

    @Query("SELECT * FROM restaurants")
    fun getAll(): List<RestaurantEntity>

    @RawQuery(observedEntities = [RestaurantEntity::class])
    fun getRestaurantsByName(query: SupportSQLiteQuery): List<RestaurantEntity>
}
