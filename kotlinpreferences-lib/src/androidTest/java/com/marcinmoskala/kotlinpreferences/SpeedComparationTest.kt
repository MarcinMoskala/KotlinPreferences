package com.marcinmoskala.kotlinpreferences

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.reflect.KMutableProperty0

@RunWith(AndroidJUnit4::class)
class SpeedComparationTest: BaseTest() {

    fun measureTime(f: () -> Unit): Long {
        val startTime = System.currentTimeMillis()
        f()
        val endTime = System.currentTimeMillis()
        return endTime - startTime
    }

    @Test
    fun propertyReadTest() {
        val normalReadTime = getReadTime(pref::f)
        val propertyReadTime = getReadTime(pref::p)
        Assert.assertTrue(normalReadTime > propertyReadTime)
    }

    @Test
    fun propertyWriteTest() {
        val bigList = ListPackage((1..10000).toList())
        val normalWriteTime = measureTime {
            pref.f = bigList
        }
        val propertyWriteTime = measureTime {
            pref.p = bigList
        }
        Assert.assertTrue(normalWriteTime > propertyWriteTime)
    }

    private fun getReadTime(property: KMutableProperty0<ListPackage?>): Long {
        property.set(ListPackage((1..10).toList()))
        return measureTime {
            repeat(100) { property.get() }
        }
    }
}
