package data_munging

import com.google.common.truth.Truth.assertThat
import org.example.data_munging.WeatherHelper
import org.example.data_munging.WeatherDay
import org.junit.Assert
import org.junit.Test

class WeatherHelperTest {

    @Test
    fun `parse weather from string must accept string`() {
        WeatherHelper.parseWeatherFromString(
            "   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5"
        )
    }

    @Test
    fun `if valid string parse weather from string must return valid weather day`() {
        val day: WeatherDay = WeatherHelper.parseWeatherFromString(
            "   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5"
        )
        assertThat(day).isEqualTo(WeatherDay(1, 88f, 59f))
    }

    @Test
    fun `if not valid string must throw exception`() {
        Assert.assertThrows(Exception::class.java) {
            WeatherHelper.parseWeatherFromString("")
        }
    }

    @Test
    fun `get smallest temperature spread takes a list of weather days`() {
        WeatherHelper.getDayForSmallestTemperatureSpread(
            listOf(
                WeatherDay(
                    day = 1,
                    maxTemperature = 22f,
                    minTemperature = 12f
                )
            )
        )
    }

    @Test
    fun `get smallest temperature spread returns a WeatherDay`() {
        val day: WeatherDay = WeatherHelper.getDayForSmallestTemperatureSpread(
            weatherDays = listOf(
                WeatherDay(
                    day = 1,
                    maxTemperature = 22f,
                    minTemperature = 12f,
                )
            )
        )
    }

    @Test
    fun `empty list throws exception`() {
        Assert.assertThrows(Exception::class.java) {
            WeatherHelper.getDayForSmallestTemperatureSpread(listOf())
        }
    }

    @Test
    fun `should return the one with the smaller spread`() {
        val days = listOf(
            WeatherDay(
                day = 1,
                maxTemperature = 22f,
                minTemperature = 12f,
            ),
            WeatherDay(
                day = 2,
                maxTemperature = 18f,
                minTemperature = 16f,
            ),
            WeatherDay(
                day = 3,
                maxTemperature = 13f,
                minTemperature = 12f,
            ),
        )
        val day: WeatherDay = WeatherHelper.getDayForSmallestTemperatureSpread(
            weatherDays = days
        )
        assertThat(day.day).isEqualTo(3)
    }
}