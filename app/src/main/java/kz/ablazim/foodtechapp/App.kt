package kz.ablazim.foodtechapp

import android.app.Application
import kz.ablazim.foodtechapp.comments.CommentsModule
import kz.ablazim.foodtechapp.di.CommonModule
import kz.ablazim.foodtechapp.hits.HitsModule
import kz.ablazim.foodtechapp.main.MainModule
import kz.ablazim.foodtechapp.restaurants.RestaurantsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        startKoin {
            androidContext(this@App)
            modules(
                MainModule.create(),
                CommonModule.create(),
                RestaurantsModule.create(),
                HitsModule.create(),
                CommentsModule.create()
            )
        }
    }
}