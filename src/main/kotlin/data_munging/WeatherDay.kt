package org.example.data_munging

data class WeatherDay(
    val day: Int,
    val maxTemperature: Float,
    val minTemperature: Float
)

fun WeatherDay.getDifference(): Float {
    return this.maxTemperature - this.minTemperature
}
