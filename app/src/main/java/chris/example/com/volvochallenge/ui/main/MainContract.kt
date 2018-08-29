package chris.example.com.volvochallenge.ui.main

import chris.dev.com.volvochallenge.model.WeatherResponse
import chris.example.com.volvochallenge.base.BasePresenter
import chris.example.com.volvochallenge.base.BaseView

interface MainContract
{
    interface View : BaseView
    {
        fun setWeather(weather: WeatherResponse)
        fun showProgress(message: String)
    }

    interface Presenter : BasePresenter<View>
    {
        fun getWeather(id: String)
    }
}