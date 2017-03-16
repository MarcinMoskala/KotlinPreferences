package com.marcinmoskala.kotlinpreferences

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ObjectsTest: BaseTest() {

    @Test
    fun characterTest() {
        val character1 = Character("Marcin", "Human", "Wizzard")
        val character2 = Character("Marcin", "SuperHuman", "Wizzard")
        testValues(pref::character, null, character1, character2)
    }

    @Test
    fun bigObjectTest() {
        val game1 = Game(Character("Marcin", "Human", "Wizzard"), GameMode.Hard, 100)
        testValues(pref::savedGame, null, game1)
    }
}

