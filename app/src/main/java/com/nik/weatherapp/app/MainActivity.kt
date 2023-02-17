package com.nik.weatherapp.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nik.weatherapp.R
import com.appsflyer.AppsFlyerLib

class MainActivity : AppCompatActivity() {
    private val appsflyer = AppsFlyerLib.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appsflyer.setDebugLog(true)

        appsflyer.init("AhhERdAaVmhRzACy7qCSoc", null, this)
        appsflyer.start(this)
    }
}