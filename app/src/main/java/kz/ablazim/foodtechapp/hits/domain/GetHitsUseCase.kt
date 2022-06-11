package kz.ablazim.foodtechapp.hits.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kz.ablazim.foodtechapp.base.UseCase
import kz.ablazim.foodtechapp.hits.contract.HitsRemoteGateway
import kz.ablazim.foodtechapp.hits.data.model.HitInfo

class GetHitsUseCase(private val hitsRemoteGateway: HitsRemoteGateway) : UseCase<Unit, List<HitInfo>>() {
    override val dispatcher: CoroutineDispatcher = Dispatchers.IO

    override suspend fun execute(parameters: Unit): List<HitInfo> = hitsRemoteGateway.getHits()
}