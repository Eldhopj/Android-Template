package com.eldhopj.myapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import logcat.AndroidLogcatLogger

/**
 * Application class
 *
 * @constructor Create empty App
 */
@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        // Square logcat
        AndroidLogcatLogger.installOnDebuggableApp(this)
    }
}
