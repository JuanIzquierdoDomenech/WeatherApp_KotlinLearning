package com.juanje.weatherapp_kotlinlearning.data.server

data class ForecastResult(val city: com.juanje.weatherapp_kotlinlearning.data.server.City, val list: List<com.juanje.weatherapp_kotlinlearning.data.server.Forecast>)

data class City(val id: Long, val name: String, val coord: com.juanje.weatherapp_kotlinlearning.data.server.Coordinates, val country: String, val population: Int)

data class Coordinates(val lon: Float, val lat: Float)

data class Forecast(val dt: Long, val temp: com.juanje.weatherapp_kotlinlearning.data.server.Temperature, val pressure: Float, val humidity: Int, val weather: List<com.juanje.weatherapp_kotlinlearning.data.server.Weather>,
                    val speed: Float, val deg: Int, val clouds: Int, val rain: Float)

data class Temperature(val day: Float, val min: Float, val max: Float, val night: Float, val eve: Float, val morn: Float)

data class Weather(val id: Long, val main: String, val description: String, val icon: String)