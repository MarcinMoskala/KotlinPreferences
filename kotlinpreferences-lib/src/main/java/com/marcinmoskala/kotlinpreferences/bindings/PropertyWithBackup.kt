package com.marcinmoskala.kotlinpreferences.bindings

import android.content.SharedPreferences
import kotlin.concurrent.thread
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

internal class PropertyWithBackup<T : Any>(clazz: KClass<T>, default: T?, key: String?) : PreferenceFieldDelegate<T>(clazz, default, key) {

    var field: T? = null

    override operator fun getValue(thisRef: SharedPreferences, property: KProperty<*>): T =
            field ?: super.getValue(thisRef, property).apply { field = this }

    override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: T) {
        if(value == field) return
        field = value
        thread {
            super.setValue(thisRef, property, value)
        }
    }
}