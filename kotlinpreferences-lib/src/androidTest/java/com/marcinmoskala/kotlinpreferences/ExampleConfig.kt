package com.marcinmoskala.kotlinpreferences

import android.content.SharedPreferences

var SharedPreferences.canEatPie: Boolean by bindToPreferenceField(true)
var SharedPreferences.pieBaked: Int by bindToPreferenceField(5)
var SharedPreferences.allPieInTheWorld: Long by bindToPreferenceField(-1L)
var SharedPreferences.pieEaten: Float by bindToPreferenceField(0.0F)
var SharedPreferences.bestPieName: String by bindToPreferenceField("Pie")

var SharedPreferences.isMonsterKiller: Boolean? by bindToPreferenceFieldNullable()
var SharedPreferences.monstersKilled: Int? by bindToPreferenceFieldNullable()
var SharedPreferences.numberOfHahaInLough: Long? by bindToPreferenceFieldNullable()
var SharedPreferences.experience: Float? by bindToPreferenceFieldNullable()
var SharedPreferences.className: String? by bindToPreferenceFieldNullable()

var SharedPreferences.character: Character? by bindToPreferenceFieldNullable()
var SharedPreferences.savedGame: Game? by bindToPreferenceFieldNullable()


var SharedPreferences.p_canEatPie: Boolean by bindAsPropertyWithBackup(true)
var SharedPreferences.p_pieBaked: Int by bindAsPropertyWithBackup(5)
var SharedPreferences.p_allPieInTheWorld: Long by bindAsPropertyWithBackup(-1L)
var SharedPreferences.p_pieEaten: Float by bindAsPropertyWithBackup(0.0F)
var SharedPreferences.p_bestPieName: String by bindAsPropertyWithBackup("Pie")

var SharedPreferences.p_isMonsterKiller: Boolean? by bindAsPropertyWithBackupNullable()
var SharedPreferences.p_monstersKilled: Int? by bindAsPropertyWithBackupNullable()
var SharedPreferences.p_numberOfHahaInLough: Long? by bindAsPropertyWithBackupNullable()
var SharedPreferences.p_experience: Float? by bindAsPropertyWithBackupNullable()
var SharedPreferences.p_className: String? by bindAsPropertyWithBackupNullable()

var SharedPreferences.p_character: Character? by bindAsPropertyWithBackupNullable()
var SharedPreferences.p_savedGame: Game? by bindAsPropertyWithBackupNullable()

var SharedPreferences.f: ListPackage? by bindToPreferenceFieldNullable()
var SharedPreferences.p: ListPackage? by bindAsPropertyWithBackupNullable()

data class ListPackage(val list: List<Int>)

data class Character(
        val name: String,
        val race: String,
        val clazz: String
)

data class Game(
        val character: Character,
        val gameMode: GameMode,
        val level: Int
)

enum class GameMode {
    Easy, Normal, Hard
}