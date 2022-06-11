package kz.ablazim.foodtechapp.di

import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kz.ablazim.foodtechapp.BuildConfig
import kz.ablazim.foodtechapp.database.DatabaseManager
import kz.ablazim.foodtechapp.database.FoodTechDatabase
import kz.ablazim.foodtechapp.restaurants.data.db.RestaurantsDaoProvider
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val DEFAULT_CONNECT_TIMEOUT_SECONDS = 30L
private const val DEFAULT_READ_TIMEOUT_SECONDS = 30L
private const val RESTAURANTS_BASE_URL = "https://front-task.chibbistest.ru/api/"
private const val DATABASE_NAME = "foodTech"

object CommonModule : InjectionModule {
    override fun create(): Module = module {
        factory {
            Room.databaseBuilder(
                androidApplication(),
                FoodTechDatabase::class.java,
                DATABASE_NAME
            ).allowMainThreadQueries().build()
        } bind FoodTechDatabase::class

        single { DatabaseManager() } bind RestaurantsDaoProvider::class

        single {
            GsonBuilder()
                .apply { if (BuildConfig.DEBUG) setPrettyPrinting() }
                .create()
        } bind Gson::class

        single {
            OkHttpClient.Builder()
                .connectTimeout(DEFAULT_CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                .apply {
                    if (BuildConfig.DEBUG) {
                        addInterceptor(HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        })
                    }
                }
                .build()
        }

        single {
            Retrofit.Builder()
                .baseUrl(RESTAURANTS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(get()))
                .client(get())
                .build()
        } bind Retrofit::class
    }
}