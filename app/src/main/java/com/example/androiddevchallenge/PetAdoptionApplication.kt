package com.example.androiddevchallenge.petstore.home

import android.app.Application
import android.content.Context

class PetAdoptionApplication : Application() {

    lateinit var appContext : Context

    override fun onCreate() {
        super.onCreate()
        appContext = this.applicationContext
    }
}