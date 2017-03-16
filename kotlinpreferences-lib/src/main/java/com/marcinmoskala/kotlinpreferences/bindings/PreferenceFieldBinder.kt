@file:Suppress("UNCHECKED_CAST")
package com.marcinmoskala.kotlinpreferences.bindings

import android.content.SharedPreferences
import com.marcinmoskala.kotlinpreferences.fromJson
import com.marcinmoskala.kotlinpreferences.toJson
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

internal open class PreferenceFieldBinder<T : Any>(val clazz: KClass<T>, val default: T?, val key: String?) : ReadWriteProperty<SharedPreferences, T> {

    override operator fun getValue(thisRef: SharedPreferences, property: KProperty<*>): T = when (clazz.simpleName) {
        "Long" -> thisRef.getLong(getKey(property), default as Long) as T
        "Int" -> thisRef.getInt(getKey(property), default as Int) as T
        "String" -> thisRef.getString(getKey(property), default as? String) as T
        "Boolean" -> thisRef.getBoolean(getKey(property), default as Boolean) as T
        "Float" -> thisRef.getFloat(getKey(property), default as Float) as T
        else -> thisRef.getString(getKey(property), default?.toJson()).fromJson(clazz)
    }

    override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: T) {
        thisRef.edit().apply { putValue(clazz, value, getKey(property)) }.apply()
    }

    private fun getKey(property: KProperty<*>) = key ?: "${property.name}Key"
}