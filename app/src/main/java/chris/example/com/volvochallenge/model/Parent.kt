package chris.dev.com.volvochallenge.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Parent
{

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

    /**
     * No args constructor for use in serialization
     *
     */
    constructor()
    {
    }

    /**
     *
     * @param title
     * @param woeid
     * @param locationType
     * @param lattLong
     */
    constructor(title: String, locationType: String, woeid: Int?, lattLong: String) : super()
    {
        this.title = title
        this.locationType = locationType
        this.woeid = woeid
        this.lattLong = lattLong
    }

}
