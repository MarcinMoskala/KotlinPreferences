@file:Suppress("UNCHECKED_CAST")

package com.marcinmoskala.kotlinpreferences.bindings

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

internal open class PreferenceFieldDelegate<T : Any>(
        private val clazz: KClass<T>,
        private val default: T?,
        private val key: String?
) : ReadWriteProperty<SharedPreferences, T> {

    override operator fun getValue(thisRef: SharedPreferences, property: KProperty<*>): T
            = thisRef.getValue<T>(clazz, default, getKey(property))

    override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: T) {
        thisRef.edit().apply { putValue(clazz, value, getKey(property)) }.apply()
    }

    private fun getKey(property: KProperty<*>) = key ?: "${property.name}Key"
}