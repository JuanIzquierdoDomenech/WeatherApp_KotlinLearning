package com.juanje.weatherapp_kotlinlearning.domain.models

data class ForecastList(val id: Long, val city: String, val country: String, val dailyForecast: List<Forecast>) {

    val size: Int
        get() = dailyForecast.size

    operator fun get(position: Int): Forecast = dailyForecast[position]
}

data class Forecast(val date: Long, val description: String, val high: Int, val low: Int, val iconUrl: String)
