package chris.dev.com.volvochallenge.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ConsolidatedWeather
{

    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("weather_state_name")
    @Expose
    var weatherStateName: String? = null
    @SerializedName("weather_state_abbr")
    @Expose
    var weatherStateAbbr: String? = null
    @SerializedName("wind_direction_compass")
    @Expose
    var windDirectionCompass: String? = null
    @SerializedName("created")
    @Expose
    var created: String? = null
    @SerializedName("applicable_date")
    @Expose
    var applicableDate: String? = null
    @SerializedName("min_temp")
    @Expose
    var minTemp: Double? = null
    @SerializedName("max_temp")
    @Expose
    var maxTemp: Double? = null
    @SerializedName("the_temp")
    @Expose
    var theTemp: Double? = null
    @SerializedName("wind_speed")
    @Expose
    var windSpeed: Double? = null
    @SerializedName("wind_direction")
    @Expose
    var windDirection: Double? = null
    @SerializedName("air_pressure")
    @Expose
    var airPressure: Double? = null
    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null
    @SerializedName("visibility")
    @Expose
    var visibility: Double? = null
    @SerializedName("predictability")
    @Expose
    var predictability: Int? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()
    {
    }

    /**
     *
     * @param visibility
     * @param windDirection
     * @param predictability
     * @param weatherStateAbbr
     * @param minTemp
     * @param weatherStateName
     * @param id
     * @param maxTemp
     * @param applicableDate
     * @param windSpeed
     * @param humidity
     * @param windDirectionCompass
     * @param created
     * @param theTemp
     * @param airPressure
     */
    constructor(id: String, weatherStateName: String, weatherStateAbbr: String, windDirectionCompass: String, created: String, applicableDate: String, minTemp: Double?, maxTemp: Double?, theTemp: Double?, windSpeed: Double?, windDirection: Double?, airPressure: Double?, humidity: Int?, visibility: Double?, predictability: Int?) : super()
    {
        this.id = id
        this.weatherStateName = weatherStateName
        this.weatherStateAbbr = weatherStateAbbr
        this.windDirectionCompass = windDirectionCompass
        this.created = created
        this.applicableDate = applicableDate
        this.minTemp = minTemp
        this.maxTemp = maxTemp
        this.theTemp = theTemp
        this.windSpeed = windSpeed
        this.windDirection = windDirection
        this.airPressure = airPressure
        this.humidity = humidity
        this.visibility = visibility
        this.predictability = predictability
    }

}
