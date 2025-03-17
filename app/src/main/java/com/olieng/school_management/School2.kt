package com.olieng.school_management

import android.app.Application
import android.content.Context

class School2: Application() {
    companion object{
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext=applicationContext
    }
}