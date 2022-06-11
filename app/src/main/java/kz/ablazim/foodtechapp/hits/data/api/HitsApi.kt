package kz.ablazim.foodtechapp.hits.data.api

import kz.ablazim.foodtechapp.hits.contract.HitsRemoteGateway
import kz.ablazim.foodtechapp.hits.data.model.HitInfo

class HitsApi(private val hitsService: HitsService) : HitsRemoteGateway {
    override suspend fun getHits(): List<HitInfo> = hitsService.getHits()
}