package com.example.firebaseauthphone.base

import android.app.Application
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
    Firebase.initialize(this)
    }
}