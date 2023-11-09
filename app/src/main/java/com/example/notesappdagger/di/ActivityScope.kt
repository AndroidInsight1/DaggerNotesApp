package com.example.notesappdagger.di

import javax.inject.Scope

/** Custom Scope - we can create custom scope and naming convention as per our need. Here we name it
 * as ActivityScope. This scope alive as long as the activity exist. If activity destroyed and this custom
 * scope will be removed from the memory */

/** AnnotationRetention.RUNTIME - Annotation is stored in binary output and visible for reflection
 * (default retention)
 */

@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ActivityScope
