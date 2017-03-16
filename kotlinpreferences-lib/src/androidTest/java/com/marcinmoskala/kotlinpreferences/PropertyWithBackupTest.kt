package com.marcinmoskala.kotlinpreferences

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PropertyWithBackupTest: BaseTest() {

    @Test
    fun booleanDefaultChangeTest() {
        testValues(pref::p_canEatPie, true, false, true, false)
    }

    @Test
    fun intDefaultChangeTest() {
        testValues(pref::p_pieBaked, 5, 10, 0, 10, -19)
    }

    @Test
    fun longDefaultChangeTest() {
        testValues(pref::p_allPieInTheWorld, -1L, 10L, 0L, 100L)
    }

    @Test
    fun floatDefaultChangeTest() {
        testValues(pref::p_pieEaten, 0.0F, 10F, 0.06F, 100F)
    }

    @Test
    fun stringDefaultChangeTest() {
        testValues(pref::p_bestPieName, "Pie", "BlueberryPie", "SuperPie")
    }
}
