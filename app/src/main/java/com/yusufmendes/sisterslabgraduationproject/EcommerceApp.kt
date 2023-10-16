package com.yusufmendes.sisterslabgraduationproject

import android.app.Application
import com.yusufmendes.sisterslabgraduationproject.ui.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class EcommerceApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Android logger - Level.INFO by default
            androidLogger()

            // Reference Android context
            androidContext(this@EcommerceApp)

            // use properties from assets/koin.properties
            androidFileProperties()

            // Load modules
            modules(appModule)
        }
    }
}