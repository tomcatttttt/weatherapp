package com.nik.weatherapp.presentation.weather

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.nik.weatherapp.databinding.FragmentWeatherBinding

class WeatherFragment : Fragment() {

    private val viewModel by viewModels<WeatherViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentWeatherBinding.inflate(inflater, container, false).apply {
        getWeather.setOnClickListener {
            viewModel.launchDataLoad()
            Log.d("ebta", "click")
        }
        lifecycleScope.launchWhenCreated {
            viewModel.launchDataLoad()
            viewModel.weatherFlow.collect {
                tvDegrees.text = it.toString()
            }
        }
        button.setOnClickListener {
            findNavController().navigate(WeatherFragmentDirections.actionWeatherFragmentToWebFragment())
            Log.d("ebta", "click1")
        }
    }.root
}