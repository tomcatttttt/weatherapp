package com.nik.weatherapp.presentation.weather.web

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nik.weatherapp.databinding.FragmentWebBinding


class WebFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = FragmentWebBinding.inflate(inflater, container, false).apply {
        webView.loadUrl("https://www.google.com")
    }.root
}