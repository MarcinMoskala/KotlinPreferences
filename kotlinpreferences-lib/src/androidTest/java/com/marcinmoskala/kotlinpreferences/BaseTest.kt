package com.marcinmoskala.kotlinpreferences

open class BaseTest {

    val pref get() = android.support.test.InstrumentationRegistry.getTargetContext().preferences

    init { pref.clear() }
}