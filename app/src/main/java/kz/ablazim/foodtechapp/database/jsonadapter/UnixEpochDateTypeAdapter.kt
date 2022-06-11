package kz.ablazim.foodtechapp.database.jsonadapter

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import java.util.Date

class UnixEpochDateTypeAdapter : TypeAdapter<Date?>() {
    override fun read(`in`: JsonReader): Date? = if (`in`.peek() == JsonToken.NULL) null else Date(`in`.nextLong())

    override fun write(out: JsonWriter, value: Date?) {
        if (value == null) out.nullValue() else out.value(value.time)
    }
}