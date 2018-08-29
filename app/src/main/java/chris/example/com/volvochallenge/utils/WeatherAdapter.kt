package chris.example.com.volvochallenge.utils

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import java.util.ArrayList

import chris.dev.com.volvochallenge.model.WeatherResponse
import chris.example.com.volvochallenge.R

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

            for (i in weather.indices)
            {
                when (weather[i].weatherStateAbbr)
                {
                    "sn" -> holder.ivsWeather[i].setImageResource(R.drawable.ic_sn)
                    "sl" -> holder.ivsWeather[i].setImageResource(R.drawable.ic_sl)
                    "h" -> holder.ivsWeather[i].setImageResource(R.drawable.ic_h)
                    "t" -> holder.ivsWeather[i].setImageResource(R.drawable.ic_t)
                    "hr" -> holder.ivsWeather[i].setImageResource(R.drawable.ic_hr)
                    "lr" -> holder.ivsWeather[i].setImageResource(R.drawable.ic_lr)
                    "s" -> holder.ivsWeather[i].setImageResource(R.drawable.ic_s)
                    "hc" -> holder.ivsWeather[i].setImageResource(R.drawable.ic_hc)
                    "lc" -> holder.ivsWeather[i].setImageResource(R.drawable.ic_lc)
                    "c" -> holder.ivsWeather[i].setImageResource(R.drawable.ic_c)
                }
            }
        }
    }

    override fun getItemCount(): Int
    {
        return weatherResponses.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

        val tvCity: TextView = itemView.findViewById(R.id.tvCity)
        val ivsWeather: MutableList<ImageView>

        init
        {
            ivsWeather = ArrayList()
            ivsWeather.add(itemView.findViewById<View>(R.id.ivDay1) as ImageView)
            ivsWeather.add(itemView.findViewById<View>(R.id.ivDay2) as ImageView)
            ivsWeather.add(itemView.findViewById<View>(R.id.ivDay3) as ImageView)
            ivsWeather.add(itemView.findViewById<View>(R.id.ivDay4) as ImageView)
            ivsWeather.add(itemView.findViewById<View>(R.id.ivDay5) as ImageView)
            ivsWeather.add(itemView.findViewById<View>(R.id.ivDay6) as ImageView)
        }
    }

    companion object
    {
        internal var TAG = "CelebrityRcAdapter"
    }
}
