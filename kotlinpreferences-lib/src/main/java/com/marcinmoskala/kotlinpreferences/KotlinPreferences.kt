package com.marcinmoskala.kotlinpreferences

import android.content.SharedPreferences
import com.marcinmoskala.kotlinpreferences.bindings.PreferenceFieldBinder
import com.marcinmoskala.kotlinpreferences.bindings.PreferenceFieldBinderNullable
import com.marcinmoskala.kotlinpreferences.bindings.PropertyWithBackup
import com.marcinmoskala.kotlinpreferences.bindings.PropertyWithBackupNullable
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

inline fun <reified T : Any> bindToPreferenceField(default: T?, key: String? = null): ReadWriteProperty<SharedPreferences, T>
        = bindToPreferenceField(T::class, default, key)

inline fun <reified T : Any> bindToPreferenceFieldNullable(key: String? = null): ReadWriteProperty<SharedPreferences, T?>
        = bindToPreferenceFieldNullable(T::class, key)

inline fun <reified T : Any> bindAsPropertyWithBackup(default: T?, key: String? = null): ReadWriteProperty<SharedPreferences, T>
        = bindAsPropertyWithBackup(T::class, default, key)

inline fun <reified T : Any> bindAsPropertyWithBackupNullable(key: String? = null): ReadWriteProperty<SharedPreferences, T?>
        = bindAsPropertyWithBackupNullable(T::class, key)

fun <T : Any> bindToPreferenceField(clazz: KClass<T>, default: T?, key: String? = null): ReadWriteProperty<SharedPreferences, T>
        = PreferenceFieldBinder(clazz, default, key)

fun <T : Any> bindToPreferenceFieldNullable(clazz: KClass<T>, key: String? = null): ReadWriteProperty<SharedPreferences, T?>
        = PreferenceFieldBinderNullable(clazz, key)

fun <T : Any> bindAsPropertyWithBackup(clazz: KClass<T>, default: T?, key: String? = null): ReadWriteProperty<SharedPreferences, T>
        = PropertyWithBackup(clazz, default, key)

fun <T : Any> bindAsPropertyWithBackupNullable(clazz: KClass<T>, key: String? = null): ReadWriteProperty<SharedPreferences, T?>
        = PropertyWithBackupNullable(clazz, key)