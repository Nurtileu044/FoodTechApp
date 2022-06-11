package kz.ablazim.foodtechapp.restaurants.data

import kz.ablazim.foodtechapp.restaurants.data.db.RestaurantEntity
import kz.ablazim.foodtechapp.restaurants.data.model.RestaurantInfo

internal object RestaurantsConverter {
    fun toDatabase(restaurants: List<RestaurantInfo>): List<RestaurantEntity> {
        return restaurants.map { restaurantInfo ->
            RestaurantEntity(
                restaurantName = restaurantInfo.name,
                logoUrl = restaurantInfo.logoUrl,
                deliveryCost = restaurantInfo.deliveryCost,
                minCost = restaurantInfo.minCost,
                deliveryTime = restaurantInfo.deliveryTime,
                positiveReviews = restaurantInfo.positiveReviews,
                reviewsCount = restaurantInfo.reviewsCount,
                specializations = restaurantInfo.specializations
            )
        }
    }

    fun fromDatabase(restaurantsEntity: List<RestaurantEntity>): List<RestaurantInfo> {
        return restaurantsEntity.map { restaurantEntity ->
            RestaurantInfo(
                name = restaurantEntity.restaurantName,
                logoUrl = restaurantEntity.logoUrl,
                deliveryCost = restaurantEntity.deliveryCost,
                minCost = restaurantEntity.minCost,
                deliveryTime = restaurantEntity.deliveryTime,
                positiveReviews = restaurantEntity.positiveReviews,
                reviewsCount = restaurantEntity.reviewsCount,
                specializations = restaurantEntity.specializations
            )
        }
    }
}