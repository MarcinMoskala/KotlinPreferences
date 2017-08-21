package com.marcinmoskala.kotlinpreferences

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import kotlin.reflect.KClass

var preferencesGson: Gson = GsonBuilder().create()

internal fun Any.toJson() = preferencesGson.toJson(this)!!

internal fun <T : Any> String.fromJson(clazz: KClass<T>) = try {
    preferencesGson.fromJson(this, clazz.java)
} catch (e: Throwable) {
    throw Error("Error in parsing to ${clazz.java}. Possibly lack of gson serializers. The string to parse: \"$this\"", e)
}