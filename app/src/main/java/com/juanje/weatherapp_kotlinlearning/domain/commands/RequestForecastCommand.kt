package com.juanje.weatherapp_kotlinlearning.domain.commands

import com.juanje.weatherapp_kotlinlearning.domain.mappers.ForecastDataMapper
import com.juanje.weatherapp_kotlinlearning.domain.models.ForecastList

class RequestForecastCommand(val zipCode: String): Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = com.juanje.weatherapp_kotlinlearning.data.ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}