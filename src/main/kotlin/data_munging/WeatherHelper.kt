package org.example.data_munging

import java.io.File

object WeatherHelper {
    // http://codekata.com/kata/kata04-data-munging/

    fun getDayForSmallestTemperatureSpread(weatherDays: List<WeatherDay>): WeatherDay {
        return weatherDays.reduce { weatherDay, weatherDay2 ->
            getTheSmallestSpreadDay(weatherDay, weatherDay2)
        }
    }

    private fun getTheSmallestSpreadDay(day1: WeatherDay, day2: WeatherDay): WeatherDay {
        return if (day1.getDifference() > day2.getDifference()) {
            day2
        } else {
            day1
        }
    }

    fun parseWeatherFromString(fileString: String): WeatherDay {
        val items = fileString.trim().split(Regex("\\s+"))

        val day = items[0].removeNoise().toInt()
        val maxTemperature = items[1].removeNoise().toFloat()
        val minTemperature = items[2].removeNoise().toFloat()

        return WeatherDay(day, maxTemperature, minTemperature)
    }

    private fun String.removeNoise(): String {
        return this.replace(Regex("[^0-9.]"), "")
    }
}

fun main() {
    val file = File("src/main/resources/weater.dat")

    val lines = file.readLines()
    val cleanedLines = lines.subList(2, lines.lastIndex - 1)

    val days = cleanedLines.map(WeatherHelper::parseWeatherFromString)

    println(
        WeatherHelper.getDayForSmallestTemperatureSpread(days)
    )
}