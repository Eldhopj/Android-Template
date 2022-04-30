package com.eldhopj.myapplication.domain.utils.extensions

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

/** Parses Json to POJO class as given in the generic type
 * @param value [String] value to be parsed
 *
 * eg:      @TypeConverter
@JvmStatic
fun from(value: String): List<Model>? {
return Gson().fromJson(value)
}
 * */
inline fun <reified T> Gson.fromJson(value: String): T {
    return fromJson(value, toTypeToken<T>())
}

/** Parses Json to POJO class as given in the generic type
 * @param value [JsonElement] object to be parsed */
inline fun <reified T> Gson.fromJson(value: JsonElement): T {
    return fromJson(value, toTypeToken<T>())
}

/** Returns the type of the class*/
inline fun <reified T> toTypeToken(): Type {
    return object : TypeToken<T>() {}.type
}
