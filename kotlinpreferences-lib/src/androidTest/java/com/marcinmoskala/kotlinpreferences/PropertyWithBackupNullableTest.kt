package com.marcinmoskala.kotlinpreferences

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PropertyWithBackupNullableTest: BaseTest() {

    @Test
    fun booleanDefaultChangeTest() {
        testValues(pref::p_isMonsterKiller, null, true, false, true, null)
    }

    @Test
    fun intDefaultChangeTest() {
        testValues(pref::p_monstersKilled, null, 10, 0, 10, -19)
    }

    @Test
    fun longDefaultChangeTest() {
        testValues(pref::p_numberOfHahaInLough, null, 10L, 0L, 100L)
    }

    @Test
    fun floatDefaultChangeTest() {
        testValues(pref::p_experience, null, 10F, 0F, 100F)
    }

    @Test
    fun stringDefaultChangeTest() {
        testValues(pref::p_className, null, "BlueberryPie", "SuperPie")
    }
}
