package kz.ablazim.foodtechapp.hits.contract

import kz.ablazim.foodtechapp.hits.data.model.HitInfo

interface HitsRemoteGateway {
    suspend fun getHits(): List<HitInfo>
}