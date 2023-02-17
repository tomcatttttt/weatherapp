package com.nik.weatherapp.presentation.weather

import android.util.Log
import androidx.lifecycle.ViewModel
import com.nik.weatherapp.data.url.RetrofitHelper
import com.nik.weatherapp.data.url.WeatherApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel() : ViewModel() {

    val quotesApi = RetrofitHelper.getInstance().create(WeatherApi::class.java)

    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    var weatherFlow: MutableStateFlow<Double?> = MutableStateFlow(0.0)

    fun launchDataLoad() {
        uiScope.launch {
            val result = quotesApi.getApi()
             weatherFlow.value = (result.body()?.current?.temp_c ?: 0) as Double?

        }
    }
}