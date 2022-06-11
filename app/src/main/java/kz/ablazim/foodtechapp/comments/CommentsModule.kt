package kz.ablazim.foodtechapp.comments

import kz.ablazim.foodtechapp.comments.contract.CommentsRemoteGateWay
import kz.ablazim.foodtechapp.comments.data.api.CommentsApi
import kz.ablazim.foodtechapp.comments.data.api.CommentsService
import kz.ablazim.foodtechapp.comments.domain.GetCommentsUseCase
import kz.ablazim.foodtechapp.comments.presentation.CommentsViewModel
import kz.ablazim.foodtechapp.di.InjectionModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

object CommentsModule : InjectionModule {
    override fun create(): Module = module {
        single<CommentsRemoteGateWay> { CommentsApi(get<Retrofit>().create(CommentsService::class.java)) }
        single { GetCommentsUseCase(get()) }
        viewModel { CommentsViewModel(get()) }
    }
}