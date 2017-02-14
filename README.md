# KotlinPreferences
Kotlin Android Library, that makes preference usage simple and fun.

[![](https://jitpack.io/v/marcinmoskala/kotlinpreferences.svg)](https://jitpack.io/#marcinmoskala/kotlinpreferences)

With KotlinPreferences, you can define different preference fields this way:

```kotlin
var SharedPreferences.canEatPie: Boolean by bindToPreferenceField(true)
```

And use it like any SharedPreference property:
```kotlin
preferences.canEatPie = true
if(preferences.canEatPie) //...
```

There are different ways to define this properties. Here are some possibilities: (see full example [here](https://github.com/MarcinMoskala/KotlinPreferences/blob/master/kotlinpreferences-lib/src/androidTest/java/com/marcinmoskala/kotlinpreferences/ExampleConfig.kt) and usage [here](https://github.com/MarcinMoskala/KotlinPreferences/tree/master/kotlinpreferences-lib/src/androidTest/java/com/marcinmoskala/kotlinpreferences))

With default value: 
```kotlin
var SharedPreferences.canEatPie: Boolean by bindToPreferenceField(true)
var SharedPreferences.allPieInTheWorld: Long by bindToPreferenceField(0)
```

Nullable:
```kotlin
var SharedPreferences.monstersKilled: Int? by bindToPreferenceFieldNullable()
var SharedPreferences.experience: Float? by bindToPreferenceFieldNullable()
var SharedPreferences.className: String? by bindToPreferenceFieldNullable()
```

Can also keep other objects: 
```kotlin
var SharedPreferences.character: Character by bindToPreferenceFieldNullable()
var SharedPreferences.savedGame: Game? by bindToPreferenceFieldNullable()
```
Node that this objects are serialized do string using Gson. If they include some, types that needs some serializers, then you need to set gson with converters. Instructions [here](https://github.com/MarcinMoskala/KotlinPreferences/wiki/Setting-gson).

Also keys can be specyfied: (this is important to make values immtuable to property name in case of changes in the app)
```kotlin
var SharedPreferences.monstersKilled: Int? by bindToPreferenceFieldNullable("MonstersKilledKey")
var SharedPreferences.allPieInTheWorld: Long by bindToPreferenceField(0, "AllPieKey")
```

## Install

To add KotlinPreferences to the project, add in build.gradle file:

```groovy
dependencies {
    compile 'com.github.marcinmoskala:kotlinpreferences:0.03'
}
```

And while library is located on JitPack, remember to add on module build.gradle (unless you already have it):

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
```
