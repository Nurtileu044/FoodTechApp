package kz.ablazim.foodtechapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kz.ablazim.foodtechapp.restaurants.data.db.RestaurantEntity
import kz.ablazim.foodtechapp.restaurants.data.db.RestaurantsDao

@Database(entities = [RestaurantEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
internal abstract class FoodTechDatabase : RoomDatabase() {
    abstract fun restaurantsDao(): RestaurantsDao
}