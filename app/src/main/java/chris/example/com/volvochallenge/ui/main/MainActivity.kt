package chris.example.com.volvochallenge.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import chris.dev.com.volvochallenge.model.WeatherResponse
import chris.example.com.volvochallenge.R
import chris.example.com.volvochallenge.application.VolvoChallengeApplication
import chris.example.com.volvochallenge.utils.WeatherAdapter
import java.util.ArrayList
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View
{
    @Inject
    lateinit var presenter: MainPresenter
    private var weatherResponseList: MutableList<WeatherResponse>? = null
    private var recyclerView: RecyclerView? = null
    private var weatherAdapter: WeatherAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        VolvoChallengeApplication[this].getMainComponent().inject(this)

        bindViews()

        presenter.attachView(this)

        //Gothenburg
        presenter.getWeather("890869")
        //Stockholm
        presenter.getWeather("906057")
        //Mountain View
        presenter.getWeather("2455920")
        //London
        presenter.getWeather("44418")
        //New York
        presenter.getWeather("2459115")
        //Berlin
        presenter.getWeather("638242")
    }

    private fun bindViews()
    {
        weatherResponseList = ArrayList()
        recyclerView = findViewById(R.id.rvEvents)
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.layoutManager = LinearLayoutManager(this)
    }

    override fun showError(error: String)
    {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        Log.d(TAG, "showError: $error")
    }

    override fun onDestroy()
    {
        super.onDestroy()
        presenter.detachView()
    }

    override fun onStop()
    {
        super.onStop()
        VolvoChallengeApplication[this].clearMainComponent()
    }

    override fun setWeather(weather: WeatherResponse)
    {
        weatherResponseList!!.add(weather)
        weatherAdapter = WeatherAdapter(weatherResponseList!!, this)

        recyclerView!!.adapter = weatherAdapter
    }


    override fun showProgress(message: String)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object
    {
        val TAG = MainActivity::class.java.simpleName + "_TAG"
    }
}