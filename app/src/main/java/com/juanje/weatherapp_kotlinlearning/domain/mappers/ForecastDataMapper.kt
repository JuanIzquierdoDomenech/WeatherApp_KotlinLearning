package com.juanje.weatherapp_kotlinlearning.domain.mappers

import com.juanje.weatherapp_kotlinlearning.data.server.Forecast
import com.juanje.weatherapp_kotlinlearning.data.server.ForecastResult
import com.juanje.weatherapp_kotlinlearning.domain.models.ForecastList
import java.util.*
import java.util.concurrent.TimeUnit
import com.juanje.weatherapp_kotlinlearning.domain.models.Forecast as ModelForecast

class ForecastDataMapper {

    fun convertFromDataModel(zipCode: Long, forecast: ForecastResult) = with(forecast) {
        ForecastList(zipCode, city.name, city.country, convertForecastListToDomain(list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(dt, weather[0].description, temp.max.toInt(), temp.min.toInt(),
                generateIconUrl(weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String): String = "http://openweathermap.org/img/w/$iconCode.png"
}