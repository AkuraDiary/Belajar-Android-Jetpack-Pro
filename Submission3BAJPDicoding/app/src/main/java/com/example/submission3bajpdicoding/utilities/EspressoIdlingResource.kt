package com.example.submission3bajpdicoding.utilities

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {
    private const val RESOURCE = "global"
    val espressoTestIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment(){
        espressoTestIdlingResource.increment()
    }

    fun decrement(){
        espressoTestIdlingResource.decrement()
    }
}