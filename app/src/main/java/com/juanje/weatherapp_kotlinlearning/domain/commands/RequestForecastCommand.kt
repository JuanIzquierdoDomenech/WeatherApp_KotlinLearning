package com.juanje.weatherapp_kotlinlearning.domain.commands

import com.juanje.weatherapp_kotlinlearning.data.server.ForecastRequest
import com.juanje.weatherapp_kotlinlearning.domain.mappers.ForecastDataMapper
import com.juanje.weatherapp_kotlinlearning.domain.models.ForecastList

class RequestForecastCommand(private val zipCode: Long): Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(zipCode, forecastRequest.execute())
    }
}