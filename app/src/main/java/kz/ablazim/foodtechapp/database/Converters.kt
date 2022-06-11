package kz.ablazim.foodtechapp.database

import androidx.room.TypeConverter
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kz.ablazim.foodtechapp.database.jsonadapter.UnixEpochDateTypeAdapter
import kz.ablazim.foodtechapp.restaurants.data.model.Specialization
import java.util.*

class Converters {
    private val SPECIALIZATION_LIST = object : TypeToken<List<Specialization>>() {}.type
    private val gson = GsonBuilder()
        .registerTypeAdapter(Date::class.java, UnixEpochDateTypeAdapter())
        .create()

    @TypeConverter
    fun specializationsToString(values: List<Specialization>): String = gson.toJson(values)

    @TypeConverter
    fun stringToSpecializations(value: String): List<Specialization> = gson.fromJson(value, SPECIALIZATION_LIST)
}