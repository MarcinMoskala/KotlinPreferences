@file:Suppress("UNCHECKED_CAST")

package com.marcinmoskala.kotlinpreferences.bindings

import android.content.SharedPreferences
import com.marcinmoskala.kotlinpreferences.fromJson
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

internal open class PreferenceFieldBinderNullable<T : Any>(val clazz: KClass<T>, val key: String? = null) : ReadWriteProperty<SharedPreferences, T?> {

    override operator fun getValue(thisRef: SharedPreferences, property: KProperty<*>): T? = readValue(thisRef, property)

    override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: T?) {
        if (value == null) {
            removeValue(thisRef, property)
        } else {
            saveValue(thisRef, property, value)
        }
    }

    private fun readValue(pref: SharedPreferences, property: KProperty<*>): T? {
        val key = getKey(property)
        if (!pref.contains(key)) return null
        return pref.getByKey(key)
    }

    private fun SharedPreferences.getByKey(key: String): T? = when (clazz.simpleName) {
        "Long" -> getLong(key, -1L) as? T
        "Int" -> getInt(key, -1) as? T
        "String" -> getString(key, null) as? T
        "Boolean" -> getBoolean(key, false) as? T
        "Float" -> getFloat(key, -1.0F) as T
        else -> getString(key, null)?.fromJson(clazz)
    }

    private fun removeValue(pref: SharedPreferences, property: KProperty<*>) {
        pref.edit()
                .remove(getKey(property))
                .apply()
    }

    private fun saveValue(pref: SharedPreferences, property: KProperty<*>, value: T) {
        pref.edit().apply { putValue(clazz, value, getKey(property)) }.apply()
    }

    private fun getKey(property: KProperty<*>) = key ?: "${property.name}Key"
}