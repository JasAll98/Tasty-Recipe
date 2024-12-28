package com.jasallprojects.tastyrecipe

import android.app.Application
import com.jasallprojects.tastyrecipe.data.AppContainer
import com.jasallprojects.tastyrecipe.data.DefaultAppContainer

class TastyRecipeApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}