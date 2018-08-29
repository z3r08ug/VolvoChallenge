package chris.example.com.volvochallenge.ui.main

import chris.dev.com.volvochallenge.model.WeatherResponse
import chris.example.com.volvochallenge.network.RemoteDataSource
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter : MainContract.Presenter
{
    private lateinit var remoteDataSource: RemoteDataSource
    internal var view: MainContract.View? = null
    private var weather: WeatherResponse? = null

    @Inject constructor(remoteDataSource: RemoteDataSource)
    {
        this.remoteDataSource = remoteDataSource
    }

    constructor()
    {

    }

    override fun attachView(view: MainContract.View)
    {
        this.view = view
    }

    override fun detachView()
    {
        this.view = null
    }

    override fun getWeather(id: String)
    {
        remoteDataSource.getWeather(id).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(object : Observer<WeatherResponse>
        {
            override fun onSubscribe(d: Disposable)
            {
                view!!.showProgress("Downloading Weather Data....")
            }

            override fun onNext(weatherResponse: WeatherResponse)
            {
                weather = weatherResponse
            }

            override fun onError(e: Throwable)
            {
                view!!.showError(e.toString())
            }

            override fun onComplete()
            {
                view!!.setWeather(weather!!)
            }
        })
    }

    companion object
    {
        val TAG = MainPresenter::class.java.simpleName + "_TAG"
    }
}