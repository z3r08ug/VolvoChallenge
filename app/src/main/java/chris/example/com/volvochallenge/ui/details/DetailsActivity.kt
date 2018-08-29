package chris.example.com.volvochallenge.ui.details

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import chris.dev.com.volvochallenge.model.ConsolidatedWeather
import chris.example.com.volvochallenge.R

class DetailsActivity : AppCompatActivity()
{
    lateinit var tvCity: TextView

    var weatherIvs: ArrayList<ImageView> = ArrayList()
    var temps: ArrayList<TextView> = ArrayList()

    lateinit var title: String
    lateinit var weather: ArrayList<ConsolidatedWeather>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        title = intent.getStringExtra("title")
        weather = intent.getParcelableArrayListExtra("weather")

        bindViews()

        displayWeatherData()
    }

    fun bindViews()
    {
        tvCity = findViewById(R.id.tvDetailsCity)

        weatherIvs.add(findViewById(R.id.ivDay1))
        weatherIvs.add(findViewById(R.id.ivDay2))
        weatherIvs.add(findViewById(R.id.ivDay3))
        weatherIvs.add(findViewById(R.id.ivDay4))
        weatherIvs.add(findViewById(R.id.ivDay5))
        weatherIvs.add(findViewById(R.id.ivDay6))

        temps.add(findViewById(R.id.tvTemp1))
        temps.add(findViewById(R.id.tvTemp2))
        temps.add(findViewById(R.id.tvTemp3))
        temps.add(findViewById(R.id.tvTemp4))
        temps.add(findViewById(R.id.tvTemp5))
        temps.add(findViewById(R.id.tvTemp6))
    }

    fun displayWeatherData()
    {
        tvCity.text = title

        for (i in weather.indices)
        {
            when (weather[i].weatherStateAbbr)
            {
                "sn" -> weatherIvs[i].setImageResource(R.drawable.ic_sn)
                "sl" -> weatherIvs[i].setImageResource(R.drawable.ic_sl)
                "h" -> weatherIvs[i].setImageResource(R.drawable.ic_h)
                "t" -> weatherIvs[i].setImageResource(R.drawable.ic_t)
                "hr" -> weatherIvs[i].setImageResource(R.drawable.ic_hr)
                "lr" -> weatherIvs[i].setImageResource(R.drawable.ic_lr)
                "s" -> weatherIvs[i].setImageResource(R.drawable.ic_s)
                "hc" -> weatherIvs[i].setImageResource(R.drawable.ic_hc)
                "lc" -> weatherIvs[i].setImageResource(R.drawable.ic_lc)
                "c" -> weatherIvs[i].setImageResource(R.drawable.ic_c)
            }

            var temp: Double = (weather[0].theTemp?.times(1.8)?.plus(32) ?: 0.0)
            var tempConv = Math.round(temp)
            var tempString: String = tempConv.toString().plus(getString(R.string.degree_f))
            temps[i].text = tempString
        }
    }
}
