package kz.ablazim.foodtechapp.hits.data.api

import kz.ablazim.foodtechapp.hits.data.model.HitInfo
import retrofit2.http.GET

interface HitsService {
    @GET("v1/hits")
    suspend fun getHits(): List<HitInfo>
}