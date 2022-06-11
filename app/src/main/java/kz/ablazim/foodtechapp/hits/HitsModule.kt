package kz.ablazim.foodtechapp.hits

import kz.ablazim.foodtechapp.di.InjectionModule
import kz.ablazim.foodtechapp.hits.contract.HitsRemoteGateway
import kz.ablazim.foodtechapp.hits.data.api.HitsApi
import kz.ablazim.foodtechapp.hits.data.api.HitsService
import kz.ablazim.foodtechapp.hits.domain.GetHitsUseCase
import kz.ablazim.foodtechapp.hits.presentation.HitsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

object HitsModule : InjectionModule {
    override fun create(): Module = module {
        single<HitsRemoteGateway> { HitsApi(get<Retrofit>().create(HitsService::class.java)) }
        single { GetHitsUseCase(get()) }
        viewModel { HitsViewModel(get()) }
    }
}