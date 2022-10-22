package com.example.weather_v3

data class DayItem(
    val city : String,
    val date : String,
    val condition : String,
    val imageURL : String,
    val currentTemp : String,
    val maxTemp : String,
    val minTemp : String,
    val hours : String
)
