package chris.dev.com.volvochallenge.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Source
{

    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("slug")
    @Expose
    var slug: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("crawl_rate")
    @Expose
    var crawlRate: Int? = null

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
     * @param crawlRate
     * @param slug
     * @param url
     */
    constructor(title: String, slug: String, url: String, crawlRate: Int?) : super()
    {
        this.title = title
        this.slug = slug
        this.url = url
        this.crawlRate = crawlRate
    }

}
