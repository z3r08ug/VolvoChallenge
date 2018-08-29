package chris.example.com.volvochallenge.utils

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import chris.dev.com.volvochallenge.model.ConsolidatedWeather

import chris.dev.com.volvochallenge.model.WeatherResponse
import chris.example.com.volvochallenge.R
import chris.example.com.volvochallenge.ui.details.DetailsActivity

/**
 * Created by chris on 8/27/2018.
 */

class WeatherAdapter(internal var weatherResponses: List<WeatherResponse>, internal var context: Context) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        Log.d(TAG, "onCreateViewHolder: ")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_list_item, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val weatherResponse = weatherResponses[position]
        if (weatherResponse != null)
        {
            val weather = weatherResponse.consolidatedWeather
            Log.d(TAG, "onBindViewHolder: " + weather!!.size)
            holder.tvCity.text = weatherResponse.title

            var temp: Double = (weather[0].theTemp?.times(1.8)?.plus(32) ?: 0.0)
            var tempConv = Math.round(temp)
            var tempString: String = tempConv.toString().plus(context.getString(R.string.degree_f))
            holder.tvTemp.text = tempString

            holder.tvCity.setOnClickListener { sendToDetails(weather, weatherResponse.title) }

            when (weather[0].weatherStateAbbr)
            {
                "sn" -> holder.ivWeather.setImageResource(R.drawable.ic_sn)
                "sl" -> holder.ivWeather.setImageResource(R.drawable.ic_sl)
                "h" -> holder.ivWeather.setImageResource(R.drawable.ic_h)
                "t" -> holder.ivWeather.setImageResource(R.drawable.ic_t)
                "hr" -> holder.ivWeather.setImageResource(R.drawable.ic_hr)
                "lr" -> holder.ivWeather.setImageResource(R.drawable.ic_lr)
                "s" -> holder.ivWeather.setImageResource(R.drawable.ic_s)
                "hc" -> holder.ivWeather.setImageResource(R.drawable.ic_hc)
                "lc" -> holder.ivWeather.setImageResource(R.drawable.ic_lc)
                "c" -> holder.ivWeather.setImageResource(R.drawable.ic_c)
            }
        }
    }

    private fun sendToDetails(w: ArrayList<ConsolidatedWeather>?, t: String?)
    {
        var intent = Intent(context, DetailsActivity::class.java)
        intent.putParcelableArrayListExtra("weather", w)
        intent.putExtra("title", t)
        context.startActivity(intent)
    }

    override fun getItemCount(): Int
    {
        return weatherResponses.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

        val tvCity: TextView = itemView.findViewById(R.id.tvCity)
        val tvTemp: TextView = itemView.findViewById(R.id.tvTemp)
        val ivWeather: ImageView = itemView.findViewById(R.id.ivDay1)
    }

    companion object
    {
        internal var TAG = "CelebrityRcAdapter"
    }
}
