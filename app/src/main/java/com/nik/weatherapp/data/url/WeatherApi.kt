package com.nik.weatherapp.data.url

import com.nik.weatherapp.data.entities.Weather
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApi {
 @GET("current.json?key=c9a55ddac95947a1947183349232701&q=Brovary&aqi=yes")
 suspend fun getApi(): Response<Weather>
}