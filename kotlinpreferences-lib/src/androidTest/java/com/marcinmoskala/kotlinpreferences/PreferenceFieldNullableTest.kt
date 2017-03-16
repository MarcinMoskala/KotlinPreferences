package com.marcinmoskala.kotlinpreferences

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PreferenceFieldNullableTest: BaseTest() {

    @Test
    fun booleanDefaultChangeTest() {
        testValues(pref::isMonsterKiller, null, true, false, true, null)
    }

    @Test
    fun intDefaultChangeTest() {
        testValues(pref::monstersKilled, null, 10, 0, 10, -19)
    }

    @Test
    fun longDefaultChangeTest() {
        testValues(pref::numberOfHahaInLough, null, 10L, 0L, 100L)
    }

    @Test
    fun floatDefaultChangeTest() {
        testValues(pref::experience, null, 10F, 0F, 100F)
    }

    @Test
    fun stringDefaultChangeTest() {
        testValues(pref::className, null, "BlueberryPie", "SuperPie")
    }
}
