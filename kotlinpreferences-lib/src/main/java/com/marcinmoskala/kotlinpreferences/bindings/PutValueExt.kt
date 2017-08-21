package com.marcinmoskala.kotlinpreferences.bindings

import android.content.SharedPreferences
import com.marcinmoskala.kotlinpreferences.fromJson
import com.marcinmoskala.kotlinpreferences.toJson
import kotlin.reflect.KClass

internal fun SharedPreferences.Editor.putValue(clazz: KClass<*>, value: Any, key: String) {
    when (clazz.simpleName) {
        "Long" -> putLong(key, value as Long)
        "Int" -> putInt(key, value as Int)
        "String" -> putString(key, value as String?)
        "Boolean" -> putBoolean(key, value as Boolean)
        "Float" -> putFloat(key, value as Float)
        else -> putString(key, value.toJson())
    }
}

internal inline fun <T: Any> SharedPreferences.getValue(clazz: KClass<*>, default: T?, key: String): T = when (clazz.simpleName) {
    "Long" -> getLong(key, default as Long)
    "Int" -> getInt(key, default as Int)
    "String" -> getString(key, default as? String)
    "Boolean" -> getBoolean(key, default as Boolean)
    "Float" -> getFloat(key, default as Float)
    else -> getString(key, default?.toJson()).fromJson(clazz)
} as T
