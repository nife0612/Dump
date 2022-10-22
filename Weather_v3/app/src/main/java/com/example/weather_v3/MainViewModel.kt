package com.example.weather_v3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather_v3.adapters.WeatherModel

class MainViewModel : ViewModel() {
    val liveDateCurrent = MutableLiveData<WeatherModel>()
    val liveDataList = MutableLiveData<List<WeatherModel>>()
}