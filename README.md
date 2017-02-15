# KotlinPreferences
Kotlin Android Library, that makes preference usage simple and fun.

[![](https://jitpack.io/v/marcinmoskala/kotlinpreferences.svg)](https://jitpack.io/#marcinmoskala/kotlinpreferences)
[![Build Status](https://travis-ci.org/MarcinMoskala/KotlinPreferences.svg?branch=master)](https://travis-ci.org/MarcinMoskala/KotlinPreferences)
[![Awesome Kotlin Badge](https://kotlin.link/awesome-kotlin.svg)](https://github.com/KotlinBy/awesome-kotlin)
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

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
    compile 'com.github.marcinmoskala:kotlinpreferences:1.00'
}
```

And while library is located on JitPack, remember to add on module build.gradle (unless you already have it):

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
```


License
-------

    Copyright 2017 Marcin Moskała

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


