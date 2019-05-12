package com.marcinmoskala.kotlinpreferences.bindings

import android.content.SharedPreferences
import kotlin.concurrent.thread
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

internal class PropertyWithBackupNullable<T : Any>(
        clazz: KClass<T>,
        key: String? = null,
        applyAsync: Boolean = true
) : PreferenceFieldDelegateNullable<T>(clazz, key, applyAsync) {

    var propertySet: Boolean = false
    var field: T? = null

    override operator fun getValue(thisRef: SharedPreferences, property: KProperty<*>): T? = if (propertySet) field else {
        val newValue = super.getValue(thisRef, property)
        field = newValue
        propertySet = true
        newValue
    }

    override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: T?) {
        propertySet = true
        if (value == field) return
        field = value
        thread {
            super.setValue(thisRef, property, value)
        }
    }
}