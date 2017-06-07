package com.juanje.weatherapp_kotlinlearning.domain.commands

interface Command <out T> {
    fun execute(): T
}