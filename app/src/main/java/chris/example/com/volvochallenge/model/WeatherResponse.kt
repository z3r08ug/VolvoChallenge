package chris.dev.com.volvochallenge.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WeatherResponse
{

    @SerializedName("consolidated_weather")
    @Expose
    var consolidatedWeather: List<ConsolidatedWeather>? = null
    @SerializedName("time")
    @Expose
    var time: String? = null
    @SerializedName("sun_rise")
    @Expose
    var sunRise: String? = null
    @SerializedName("sun_set")
    @Expose
    var sunSet: String? = null
    @SerializedName("timezone_name")
    @Expose
    var timezoneName: String? = null
    @SerializedName("parent")
    @Expose
    var parent: Parent? = null
    @SerializedName("sources")
    @Expose
    var sources: List<Source>? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("location_type")
    @Expose
    var locationType: String? = null
    @SerializedName("woeid")
    @Expose
    var woeid: Int? = null
    @SerializedName("latt_long")
    @Expose
    var lattLong: String? = null
    @SerializedName("timezone")
    @Expose
    var timezone: String? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()
    {
    }

    /**
     *
     * @param sunSet
     * @param timezone
     * @param title
     * @param time
     * @param consolidatedWeather
     * @param woeid
     * @param locationType
     * @param sunRise
     * @param lattLong
     * @param parent
     * @param sources
     * @param timezoneName
     */
    constructor(consolidatedWeather: List<ConsolidatedWeather>, time: String, sunRise: String, sunSet: String, timezoneName: String, parent: Parent, sources: List<Source>, title: String, locationType: String, woeid: Int?, lattLong: String, timezone: String) : super()
    {
        this.consolidatedWeather = consolidatedWeather
        this.time = time
        this.sunRise = sunRise
        this.sunSet = sunSet
        this.timezoneName = timezoneName
        this.parent = parent
        this.sources = sources
        this.title = title
        this.locationType = locationType
        this.woeid = woeid
        this.lattLong = lattLong
        this.timezone = timezone
    }

}
