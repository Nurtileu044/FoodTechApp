package kz.ablazim.foodtechapp.restaurants

import kz.ablazim.foodtechapp.di.InjectionModule
import kz.ablazim.foodtechapp.restaurants.contract.RestaurantsLocalGateway
import kz.ablazim.foodtechapp.restaurants.contract.RestaurantsRemoteGateway
import kz.ablazim.foodtechapp.restaurants.data.api.RestaurantsApi
import kz.ablazim.foodtechapp.restaurants.data.api.RestaurantsService
import kz.ablazim.foodtechapp.restaurants.data.db.RestaurantsDatabase
import kz.ablazim.foodtechapp.restaurants.domain.GetLocalRestaurantsByName
import kz.ablazim.foodtechapp.restaurants.domain.GetLocalRestaurantsUseCase
import kz.ablazim.foodtechapp.restaurants.domain.GetRestaurantsUseCase
import kz.ablazim.foodtechapp.restaurants.domain.SaveLocalRestaurantsUseCase
import kz.ablazim.foodtechapp.restaurants.presentation.RestaurantsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

object RestaurantsModule : InjectionModule {
    override fun create(): Module = module {
        single<RestaurantsLocalGateway> { RestaurantsDatabase(get()) }
        single<RestaurantsRemoteGateway> { RestaurantsApi(get<Retrofit>().create(RestaurantsService::class.java)) }
        single { GetRestaurantsUseCase(get()) }
        single { GetLocalRestaurantsUseCase(get()) }
        single { SaveLocalRestaurantsUseCase(get()) }
        single { GetLocalRestaurantsByName(get()) }
        viewModel { RestaurantsViewModel(get(), get(), get(), get()) }
    }
}