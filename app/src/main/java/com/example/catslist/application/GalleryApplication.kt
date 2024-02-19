package com.example.catslist.application

import android.app.Application
import com.example.catslist.module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GalleryApplication : Application(){

    override fun onCreate(){
        super.onCreate()

        startKoin{
            androidContext(this@GalleryApplication)
            modules(appModule)
        }

    }

}