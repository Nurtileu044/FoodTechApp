package kz.ablazim.foodtechapp.restaurants.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kz.ablazim.foodtechapp.restaurants.data.db.RestaurantEntity.Companion.TABLE_NAME
import kz.ablazim.foodtechapp.restaurants.data.model.Specialization

@Entity(tableName = TABLE_NAME)
data class RestaurantEntity(
    @PrimaryKey
    @ColumnInfo(name = RESTAURANT_NAME)
    val restaurantName: String,
    @ColumnInfo(name = LOGO_URL)
    val logoUrl: String,
    @ColumnInfo(name = MIN_COST)
    val minCost: Int,
    @ColumnInfo(name = DELIVERY_COST)
    val deliveryCost: Int,
    @ColumnInfo(name = DELIVERY_TIME)
    val deliveryTime: Int,
    @ColumnInfo(name = POSITIVE_REVIEWS)
    val positiveReviews: Int,
    @ColumnInfo(name = REVIEWS_COUNT)
    val reviewsCount: Int,
    @ColumnInfo(name = SPECIALIZATIONS)
    val specializations: List<Specialization>
) {
    companion object {
        const val TABLE_NAME = "restaurants"
        const val RESTAURANT_NAME = "restaurant_name"
        const val LOGO_URL = "logo_url"
        const val MIN_COST = "min_cost"
        const val DELIVERY_COST = "delivery_cost"
        const val DELIVERY_TIME = "delivery_time"
        const val POSITIVE_REVIEWS = "positive_reviews"
        const val REVIEWS_COUNT = "reviews_count"
        const val SPECIALIZATIONS = "specializations"
    }
}