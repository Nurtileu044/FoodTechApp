package kz.ablazim.foodtechapp.main

import kz.ablazim.foodtechapp.di.InjectionModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object MainModule : InjectionModule {
    override fun create(): Module = module {
        viewModel { MainViewModel() }
    }
}